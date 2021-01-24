package cn.ren.marvin.giraffe.auth.controller;

import cn.ren.marvin.giraffe.auth.dto.DepartmentDto;
import cn.ren.marvin.giraffe.auth.dto.UserInfoDto;
import cn.ren.marvin.giraffe.auth.dto.UserPasswordChangeRequest;
import cn.ren.marvin.giraffe.auth.dto.response.RoleResponse;
import cn.ren.marvin.giraffe.auth.dto.response.UserResponse;
import cn.ren.marvin.giraffe.auth.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/")
    public Page<UserInfoDto> search(Pageable pageable){
        return userService.searchUser("", pageable);
    }

    @PostMapping("")
    public UserResponse save(@RequestBody UserInfoDto userInfoDto) {
        return new UserResponse(userService.saveUser(userInfoDto));
    }

    @PutMapping("")
    public UserResponse update(@RequestBody UserInfoDto userInfoDto){
        return new UserResponse(userService.updateUser(userInfoDto));
    }

    @DeleteMapping("/{userId}")
    public UserResponse delete(@PathVariable("userId") String userId){
        userService.delete(userId);
        return new UserResponse(null);
    }

    @PostMapping("/{id}/changepassword")
    public UserResponse changepassword(@PathVariable("id")String id, @RequestBody UserPasswordChangeRequest request){
        userService.changePassword(id, request.getPassword());
        return new UserResponse(null);
    }
}
