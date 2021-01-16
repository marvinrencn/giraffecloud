package cn.ren.marvin.giraffe.auth.controller;

import cn.ren.marvin.giraffe.auth.dto.DepartmentDto;
import cn.ren.marvin.giraffe.auth.dto.response.DepartmentResponse;
import cn.ren.marvin.giraffe.auth.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ：marvin ren
 * @date ：Created in  2021-01-15 下午8:48
 * @description：
 * @modified By：
 * @version: 1.0
 */
@RestController
@AllArgsConstructor
@RequestMapping("/api/auth/department")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @PostMapping("/")
    public DepartmentResponse saveDepartment(@RequestBody DepartmentDto departmentDto){
        DepartmentDto saved = departmentService.saveDepartment(departmentDto);
        return new DepartmentResponse(saved);
    }

    @GetMapping("/")
    public List<DepartmentDto> fetchAll(){
        return departmentService.fetachAllDepartmentToTree();
    }

    @GetMapping("/{searchText}/search")
    public List<DepartmentDto> search(@PathVariable("searchText") String searchText){
        return departmentService.searchDeparments(searchText);
    }

    @DeleteMapping("/{departmentId}")
    public DepartmentResponse delete(@PathVariable("departmentId") String departmentId){
        departmentService.deleteDepartment(departmentId);
        return new DepartmentResponse(null);
    }

}
