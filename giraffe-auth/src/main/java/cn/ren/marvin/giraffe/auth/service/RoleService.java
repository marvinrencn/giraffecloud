package cn.ren.marvin.giraffe.auth.service;

import cn.ren.marvin.giraffe.auth.domain.ResourceInfo;
import cn.ren.marvin.giraffe.auth.domain.RoleInfo;
import cn.ren.marvin.giraffe.auth.dto.RoleInfoDto;
import cn.ren.marvin.giraffe.auth.repo.ResourceInfoRepository;
import cn.ren.marvin.giraffe.auth.repo.RoleInfoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ：marvin ren
 * @date ：Created in 1/16/2021 9:12 PM
 * @description：
 * @modified By：
 * @version: 1.0
 */
@Service
@Transactional
public class RoleService {

    @Autowired
    RoleInfoRepository roleInfoRepository;

    @Autowired
    ResourceInfoRepository resourceInfoRepository;

    @Autowired
    ModelMapper modelMapper;

    public RoleInfoDto saveRole(RoleInfoDto dto) {
        RoleInfo roleInfo = roleInfoRepository.save(this.toRoleInfo(dto));
        roleInfo.setResourceInfos(new HashSet<>(resourceInfoRepository.findAllById(dto.getResourceIds())));
        return this.toRoleInfoDto(roleInfo);
    }

    @Transactional(readOnly = true)
    public List<RoleInfoDto> fetchAllRole() {
        List<RoleInfo> roleInfos = roleInfoRepository.findAll();
        return roleInfos.stream().map(this::toRoleInfoDto).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<RoleInfoDto> searchRoles(String search_text) {
        List<RoleInfo> roleInfos = roleInfoRepository.searchRoleBySearchText("%" + search_text + "%");
        return roleInfos.stream().map(this::toRoleInfoDto).collect(Collectors.toList());
    }

    public void delete(String id) {
        roleInfoRepository.deleteById(id);
    }


    private RoleInfo toRoleInfo(RoleInfoDto roleInfoDto) {
        return modelMapper.map(roleInfoDto, RoleInfo.class);
    }

    private RoleInfoDto toRoleInfoDto(RoleInfo roleInfo) {
        RoleInfoDto dto = modelMapper.map(roleInfo, RoleInfoDto.class);
        dto.setResourceIds(roleInfo.getResourceInfos().stream().map(ResourceInfo::getId).collect(Collectors.toSet()));
        return dto;
    }
}
