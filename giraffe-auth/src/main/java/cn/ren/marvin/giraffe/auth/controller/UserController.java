package cn.ren.marvin.giraffe.auth.controller;

import cn.ren.marvin.giraffe.auth.dto.DepartmentDto;
import cn.ren.marvin.giraffe.auth.dto.UserInfoDto;
import cn.ren.marvin.giraffe.auth.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ：marvin ren
 * @date ：Created in  2021-01-16 上午8:08
 * @description：
 * @modified By：
 * @version: 1.0
 */
@RestController
@AllArgsConstructor
@RequestMapping("/api/auth/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/{searchText}/search")
    public Page<UserInfoDto> search(@PathVariable("searchText") String searchText, Pageable pageable){
        return userService.searchUser(searchText, pageable);
    }
}
