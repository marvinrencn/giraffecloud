package cn.ren.marvin.giraffe.taskschedule;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author ：marvin ren
 * @date ：Created in 12/30/2020 11:20 AM
 * @description：
 * @modified By：
 * @version: 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient

public class TaskScheduleApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(TaskScheduleApplication.class).run(args);
    }
}
