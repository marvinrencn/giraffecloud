package cn.ren.marvin.giraffe.taskschedule.api;

import cn.ren.marvin.giraffe.taskschedule.dto.GenericJobSchedulingResponse;
import cn.ren.marvin.giraffe.taskschedule.dto.JobSchedulingDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：marvin ren
 * @date ：Created in 12/30/2020 12:15 PM
 * @description：
 * @modified By：
 * @version: 1.0
 */
@RestController
@RequestMapping("/taskschedule")
@Slf4j
public class TaskScheduleApi {

    @Value("${server.port}")
    private String port;

    @GetMapping("/job/{id}/publish")
    GenericJobSchedulingResponse publicJob(@PathVariable("id")String jobId){
        log.info("=============here==============");
        log.info("port: {}", port);
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new GenericJobSchedulingResponse(JobSchedulingDto.builder().build());
    }
}
