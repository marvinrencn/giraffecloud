package cn.ren.marvin.giraffe.taskschedule.client;

import cn.ren.marvin.giraffe.taskschedule.dto.GenericJobSchedulingResponse;
import cn.ren.marvin.giraffe.taskschedule.dto.JobSchedulingListResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name="task-schedule-svc")
@RequestMapping("/taskschedule")
public interface TaskScheduleClient {
    @GetMapping("/job/{id}/once")
    GenericJobSchedulingResponse execOnceJob(@PathVariable("id")String jobId);

    @GetMapping("/job/{id}/publish")
    GenericJobSchedulingResponse publicJob(@PathVariable("id")String jobId);

    @GetMapping("/jobScheduling/{id}/offline")
    GenericJobSchedulingResponse offlineJob(@PathVariable("id")String jobSchedulingId);

    @GetMapping("/jobScheduling")
    JobSchedulingListResponse searchJobScheduling();
}
