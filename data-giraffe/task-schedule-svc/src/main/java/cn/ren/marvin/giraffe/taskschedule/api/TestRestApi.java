package cn.ren.marvin.giraffe.taskschedule.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：marvin ren
 * @date ：Created in  2021-01-12 下午2:11
 * @description：
 * @modified By：
 * @version: 1.0
 */
@RestController
@RequestMapping("/api/taskschedule")
@Slf4j
public class TestRestApi {

    @GetMapping("/test")
    public String helloworld(){
        return "Hello, world";
    }
}
