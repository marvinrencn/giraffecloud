package cn.ren.marvin.giraffe.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author ：marvin ren
 * @date ：Created in 12/30/2020 2:58 PM
 * @description：
 * @modified By：
 * @version: 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OneGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(OneGatewayApplication.class, args);
    }

}
