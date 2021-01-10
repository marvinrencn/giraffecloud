package cn.ren.marvin.giraffe.auth.service;

import cn.ren.marvin.giraffe.auth.model.UserInfo;
import cn.ren.marvin.giraffe.auth.repo.UserInfoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author ：marvin ren
 * @date ：Created in 1/7/2021 12:28 PM
 * @description：
 * @modified By：
 * @version: 1.0
 */
@Service
@Slf4j
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    UserInfoRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        Optional<UserInfo> optionalUser = userRepository.findUserInfoByUsername(name);

        if (!optionalUser.isPresent()) {
            throw new UsernameNotFoundException("invalid username or password");
        }
        UserInfo userInfo = optionalUser.get();

        return userInfo;
    }
}
