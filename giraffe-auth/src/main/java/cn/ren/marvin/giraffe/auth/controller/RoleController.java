package cn.ren.marvin.giraffe.auth.controller;

import cn.ren.marvin.giraffe.auth.dto.RoleInfoDto;
import cn.ren.marvin.giraffe.auth.dto.response.RoleResponse;
import cn.ren.marvin.giraffe.auth.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ：marvin ren
 * @date ：Created in 1/17/2021 8:30 PM
 * @description：
 * @modified By：
 * @version: 1.0
 */
@RestController
@AllArgsConstructor
@RequestMapping("/api/auth/role")
public class RoleController {

    @Autowired
    RoleService roleService;

    @PostMapping("")
    public RoleResponse saveDepartment(@RequestBody RoleInfoDto roleDto){
        RoleInfoDto saved = roleService.saveRole(roleDto);
        return new RoleResponse(saved);
    }

    @GetMapping("")
    public List<RoleInfoDto> fetchAll(){
        return roleService.fetchAllRole();
    }

    @GetMapping("/{searchText}/search")
    public List<RoleInfoDto> search(@PathVariable("searchText") String searchText){
        return roleService.searchRoles(searchText);
    }

    @DeleteMapping("/{roleId}")
    public RoleResponse delete(@PathVariable("roleId") String roleId){
        roleService.delete(roleId);
        return new RoleResponse(null);
    }
}
