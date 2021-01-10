package cn.ren.marvin.giraffe.auth.controller;

import cn.ren.marvin.giraffe.auth.service.UserService;
import cn.ren.marvin.giraffe.auth.service.dto.UserInfoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：marvin ren
 * @date ：Created in 1/5/2021 6:30 PM
 * @description：
 * @modified By：
 * @version: 1.0
 */
@RestController
@RequestMapping("/api/account/userInfo")
public class UserApiController {

    @Autowired
    UserService userService;

    @GetMapping("/{searchText}/search")
    Page<UserInfoDto> search(@PathVariable String searchText, Pageable pageable){
        return userService.searchUser(searchText, pageable);
    }

    @GetMapping("/search")
    Page<UserInfoDto> all(Pageable pageable){
        return userService.searchUser("", pageable);
    }
}
