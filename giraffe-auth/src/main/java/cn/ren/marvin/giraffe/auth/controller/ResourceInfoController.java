package cn.ren.marvin.giraffe.auth.controller;

import cn.ren.marvin.giraffe.auth.domain.ResourceInfo;
import cn.ren.marvin.giraffe.auth.dto.ResourceInfoDto;
import cn.ren.marvin.giraffe.auth.repo.ResourceInfoRepository;
import cn.ren.marvin.giraffe.auth.service.ResourceInfoService;
import cn.ren.marvin.giraffe.auth.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ：marvin ren
 * @date ：Created in 1/23/2021 9:42 PM
 * @description：
 * @modified By：
 * @version: 1.0
 */
@RestController
@AllArgsConstructor
@RequestMapping("/api/auth/resource")
public class ResourceInfoController {
    @Autowired
    ResourceInfoService resourceInfoService;

    @GetMapping("")
    List<ResourceInfoDto> getAllResourceInfo(){
        return resourceInfoService.all();
    }


}
