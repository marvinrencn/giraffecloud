package cn.ren.marvin.giraffe.auth.service;

import cn.ren.marvin.giraffe.auth.domain.UserInfo;
import cn.ren.marvin.giraffe.auth.repo.UserInfoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author ：marvin ren
 * @date ：Created in  2021-01-14 下午2:49
 * @description：
 * @modified By：
 * @version: 1.0
 */
@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserInfoRepository userInfoRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {



        Optional<UserInfo> optionalUser = userInfoRepository.findUserInfoByUsername(username);

        if (!optionalUser.isPresent()) {
            throw new UsernameNotFoundException("invalid username or password");
        }
        UserInfo user = optionalUser.get();

        if (!user.isEnabled()) {
            throw new DisabledException("the account is disabled!");
        } else if (!user.isAccountNonLocked()) {
            throw new LockedException("the account is locked!");
        } else if (!user.isAccountNonExpired()) {
            throw new AccountExpiredException("this account is expired!");
        }
        return user;
    }
}
