package cn.ren.marvin.giraffe.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author ：marvin ren
 * @date ：Created in  2021-01-14 下午8:00
 * @description：
 * @modified By：
 * @version: 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class GiraffeGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GiraffeGatewayApplication.class, args);
    }

}
