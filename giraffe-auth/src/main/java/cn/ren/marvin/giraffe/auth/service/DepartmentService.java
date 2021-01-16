package cn.ren.marvin.giraffe.auth.service;

import cn.ren.marvin.giraffe.auth.domain.DepartmentInfo;
import cn.ren.marvin.giraffe.auth.repo.DepartmentInfoRepository;
import cn.ren.marvin.giraffe.auth.dto.DepartmentDto;
import cn.ren.marvin.giraffe.common.exception.NotFoundException;
import org.apache.commons.lang.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author ：marvin ren
 * @date ：Created in  2021-01-15 下午4:55
 * @description：
 * @modified By：
 * @version: 1.0
 */
@Service
@Transactional
public class DepartmentService {
    @Autowired
    DepartmentInfoRepository departmentInfoRepository;

    @Autowired
    ModelMapper modelMapper;


    public DepartmentDto saveDepartment(DepartmentDto dto) {
        DepartmentInfo departmentInfo = departmentInfoRepository.save(this.toDepartmentInfo(dto));
        return this.toDepartmentDto(departmentInfo);

    }

    @Transactional(readOnly = true)
    public List<DepartmentDto> fetachAllDepartmentToTree() {
        List<DepartmentInfo> all_deparments = departmentInfoRepository.findAll();
        return getDepartmentDtos(all_deparments);
    }

    @Transactional(readOnly = true)
    public List<DepartmentDto> searchDeparments(String search_text) {
        List<DepartmentInfo> departmentInfos = departmentInfoRepository.searchUserBySearchText("%" + search_text + "%");
        return getDepartmentDtos(departmentInfos);
    }

    public void deleteDepartment(String id) {
        departmentInfoRepository.deleteById(id);
    }

    private List<DepartmentDto> getDepartmentDtos(List<DepartmentInfo> all_deparments) {
        List<DepartmentDto> result = new ArrayList<>();
        Map<String, DepartmentDto> map = new HashMap<>();

        for (DepartmentInfo departmentInfo : all_deparments) {
            DepartmentDto departmentDto = this.toDepartmentDto(departmentInfo);
            result.add(departmentDto);
            map.put(departmentDto.getId(), departmentDto);
        }

        for (DepartmentDto departmentDto : result) {
            if (StringUtils.isNotEmpty(departmentDto.getParentId())) {
                map.get(departmentDto.getParentId()).getChildren().add(departmentDto);
            }
        }

        return result.stream().filter((d) -> StringUtils.isEmpty(d.getParentId())).collect(Collectors.toList());
    }


    private DepartmentDto toDepartmentDto(DepartmentInfo departmentInfo) {
        DepartmentDto dto = modelMapper.map(departmentInfo, DepartmentDto.class);
        if (departmentInfo.getParent() != null) {
            dto.setParentId(departmentInfo.getParent().getId());
            dto.setParentName(departmentInfo.getParent().getName());
        }
        dto.setChildren(new ArrayList<>());
        return dto;
    }

    private DepartmentInfo toDepartmentInfo(DepartmentDto dto) {
        DepartmentInfo info = DepartmentInfo.builder()
                .id(dto.getId())
                .name(dto.getName())
                .mobile(dto.getMobile())
                .status(dto.getStatus())
                .email(dto.getEmail())
                .notes(dto.getNotes())
                .build();
        if (StringUtils.isNotEmpty(dto.getParentId())) {
            Optional<DepartmentInfo> parentDepartment = departmentInfoRepository.findById(dto.getParentId());
            parentDepartment.orElseThrow(() -> new NotFoundException("The Parent Department Not Found"));
            info.setParent(parentDepartment.get());
        }
        return info;
    }


}
