package cn.ren.marvin.giraffe.auth.service;

import cn.ren.marvin.giraffe.auth.domain.UserInfo;
import cn.ren.marvin.giraffe.auth.repo.UserInfoRepository;
import cn.ren.marvin.giraffe.auth.dto.UserInfoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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
public class UserService {

    @Autowired
    UserInfoRepository userInfoRepository;

    @Transactional(readOnly = true)
    public Page<UserInfoDto> searchUser(String search_text, Pageable pageable){
        Page<UserInfo> userInfos = userInfoRepository.searchUserBySearchtext("%" + search_text + "%", pageable);
        List<UserInfoDto> dtos = userInfos.get().map(this::toDto).collect(Collectors.toList());
        return new PageImpl<>(dtos, pageable, userInfos.getTotalElements());
    }

    private UserInfoDto toDto(UserInfo userInfo){
        return UserInfoDto.builder().id(userInfo.getId())
                .username(userInfo.getUsername())
                .displayName(userInfo.getDisplayName())
                .status(userInfo.getStatus())
                .mobile(userInfo.getMobile())
                .email(userInfo.getEmail())
                .build();
    }
}
