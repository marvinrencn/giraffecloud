package cn.ren.marvin.giraffe.auth.service;

import cn.ren.marvin.giraffe.auth.domain.DepartmentInfo;
import cn.ren.marvin.giraffe.auth.domain.RoleInfo;
import cn.ren.marvin.giraffe.auth.domain.UserInfo;
import cn.ren.marvin.giraffe.auth.dto.RoleInfoDto;
import cn.ren.marvin.giraffe.auth.repo.DepartmentInfoRepository;
import cn.ren.marvin.giraffe.auth.repo.RoleInfoRepository;
import cn.ren.marvin.giraffe.auth.repo.UserInfoRepository;
import cn.ren.marvin.giraffe.auth.dto.UserInfoDto;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author ：marvin ren
 * @date ：Created in 1/8/2021 3:29 PM
 * @description：
 * @modified By：
 * @version: 1.0
 */
@Service
@Transactional
@Slf4j
public class UserService {

    @Autowired
    UserInfoRepository userInfoRepository;

    @Autowired
    RoleInfoRepository roleInfoRepository;

    @Autowired
    DepartmentInfoRepository departmentInfoRepository;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Transactional(readOnly = true)
    public Page<UserInfoDto> searchUser(String search_text, Pageable pageable){
        Page<UserInfo> userInfos = userInfoRepository.searchUserBySearchtext("%" + search_text + "%", pageable);
        List<UserInfoDto> dtos = userInfos.get().map(this::toDto).collect(Collectors.toList());
        return new PageImpl<>(dtos, pageable, userInfos.getTotalElements());
    }


    public UserInfoDto saveUser(UserInfoDto userInfoDto){
        UserInfo userInfo = this.toUserInfo(userInfoDto);
        userInfo.setPassword(passwordEncoder.encode(userInfoDto.getPassword()));
        userInfo.setRoleInfos(new HashSet<>(roleInfoRepository.findAllById(userInfoDto.getRoleIds())));
        userInfo.setDepartmentInfos(new HashSet<>(departmentInfoRepository.findAllById(userInfoDto.getDepartmentIds())));
        UserInfo saved = userInfoRepository.save(userInfo);
        return this.toDto(saved);

    }

    public UserInfoDto updateUser(UserInfoDto userInfoDto){
        UserInfo userInfo = this.toUserInfo(userInfoDto);
        userInfo.setPassword(userInfoRepository.findById(userInfoDto.getId()).get().getPassword());
        userInfo.setRoleInfos(new HashSet<>(roleInfoRepository.findAllById(userInfoDto.getRoleIds())));
        userInfo.setDepartmentInfos(new HashSet<>(departmentInfoRepository.findAllById(userInfoDto.getDepartmentIds())));
        UserInfo saved = userInfoRepository.save(userInfo);
        return this.toDto(saved);
    }

    public void delete(String id) {
        userInfoRepository.deleteById(id);
    }

    public void changePassword(String id, String password){
        UserInfo userInfo = userInfoRepository.findById(id).get();
        userInfo.setPassword(passwordEncoder.encode(password));
        userInfoRepository.save(userInfo);
    }


    private UserInfoDto toDto(UserInfo userInfo) {
        return UserInfoDto.builder().id(userInfo.getId())
                .username(userInfo.getUsername())
                .displayName(userInfo.getDisplayName())
                .state(userInfo.getState())
                .mobile(userInfo.getMobile())
                .email(userInfo.getEmail())
                .notes(userInfo.getNotes())
                .departmentIds(userInfo.getDepartmentInfos().stream().map(DepartmentInfo::getId).collect(Collectors.toSet()))
                .departmentNames(userInfo.getDepartmentInfos().stream().map(DepartmentInfo::getName).collect(Collectors.toSet()))

                .roleIds(userInfo.getRoleInfos().stream().map(RoleInfo::getId).collect(Collectors.toSet()))
                .roleNames(userInfo.getRoleInfos().stream().map(RoleInfo::getName).collect(Collectors.toSet()))
                .roleCodes(userInfo.getRoleInfos().stream().map(RoleInfo::getCode).collect(Collectors.toSet()))
                .build();
    }

    private UserInfo toUserInfo(UserInfoDto userInfoDto){
        UserInfo userInfo = modelMapper.map(userInfoDto, UserInfo.class);

        return userInfo;
    }
}
