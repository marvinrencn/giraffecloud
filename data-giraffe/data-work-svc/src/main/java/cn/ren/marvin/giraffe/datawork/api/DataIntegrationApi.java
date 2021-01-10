package cn.ren.marvin.giraffe.datawork.api;

import cn.ren.marvin.giraffe.taskschedule.client.TaskScheduleClient;
import cn.ren.marvin.giraffe.taskschedule.dto.GenericJobSchedulingResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：marvin ren
 * @date ：Created in 12/30/2020 1:56 PM
 * @description：
 * @modified By：
 * @version: 1.0
 */
@RestController
@RequestMapping("/datawork")
@Slf4j
public class DataIntegrationApi {

    @Autowired
    TaskScheduleClient taskScheduleClient;


    @GetMapping("/integration/{id}/publish")
    public String publishDataIntegration(@PathVariable("id")String id){
        GenericJobSchedulingResponse genericJobSchedulingResponse = taskScheduleClient.publicJob(id);
        log.info("result: {}", genericJobSchedulingResponse);
        return id;
    }
}
