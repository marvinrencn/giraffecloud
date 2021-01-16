package cn.ren.marvin.giraffe.common.configure;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ：marvin ren
 * @date ：Created in  2021-01-15 下午5:14
 * @description：
 * @modified By：
 * @version: 1.0
 */
@Configuration
public class ModelMapperConfiguration {
    @Bean
    ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
