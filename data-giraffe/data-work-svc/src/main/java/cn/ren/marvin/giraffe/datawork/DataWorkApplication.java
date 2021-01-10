package cn.ren.marvin.giraffe.datawork;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author ：marvin ren
 * @date ：Created in 12/30/2020 12:47 PM
 * @description：
 * @modified By：
 * @version: 1.0
 */
@SpringBootApplication(scanBasePackages = "cn.ren.marvin.giraffe")
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "cn.ren.marvin.giraffe.*.client")
public class DataWorkApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(DataWorkApplication.class).run(args);
    }

}
