package cn.ren.marvin.giraffe.gateway.configueration;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author ：marvin ren
 * @date ：Created in 1/23/2021 10:27 PM
 * @description：
 * @modified By：
 * @version: 1.0
 */

@Configuration
public class RestTemplateConfig {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
