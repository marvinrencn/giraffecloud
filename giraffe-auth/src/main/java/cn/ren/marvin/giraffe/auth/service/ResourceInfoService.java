package cn.ren.marvin.giraffe.auth.service;

import cn.ren.marvin.giraffe.auth.domain.ResourceInfo;
import cn.ren.marvin.giraffe.auth.domain.RoleInfo;
import cn.ren.marvin.giraffe.auth.dto.ResourceInfoDto;
import cn.ren.marvin.giraffe.auth.repo.ResourceInfoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ：marvin ren
 * @date ：Created in 1/23/2021 9:38 PM
 * @description：
 * @modified By：
 * @version: 1.0
 */
@Service
@Transactional
public class ResourceInfoService {

    @Autowired
    ResourceInfoRepository resourceInfoRepository;

    @Autowired
    ModelMapper modelMapper;

    public List<ResourceInfoDto> all(){
        return resourceInfoRepository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    public List<ResourceInfoDto> getPathRule(){
        List<ResourceInfo> all = resourceInfoRepository.findAll();
        return all.stream().map((r)->{
            ResourceInfoDto resourceInfoDto = this.toDto(r);
            resourceInfoDto.setRoleCodes(r.getRoleInfos().stream().map(RoleInfo::getCode).collect(Collectors.joining(",")));
            return resourceInfoDto;
        }).collect(Collectors.toList());
    }

    public ResourceInfoDto toDto(ResourceInfo resourceInfo){
        return modelMapper.map(resourceInfo, ResourceInfoDto.class);
    }
}
