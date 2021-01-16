package cn.ren.marvin.giraffe.auth.configure;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ：marvin ren
 * @date ：Created in  2021-01-15 下午5:16
 * @description：
 * @modified By：
 * @version: 1.0
 */
@Configuration
public class AuthConfiguration {

    @Bean
    ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
