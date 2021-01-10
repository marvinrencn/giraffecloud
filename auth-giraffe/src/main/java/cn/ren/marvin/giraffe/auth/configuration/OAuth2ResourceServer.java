package cn.ren.marvin.giraffe.auth.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * @author ：marvin ren
 * @date ：Created in 1/7/2021 11:27 AM
 * @description：
 * @modified By：
 * @version: 1.0
 */
@Configuration
@EnableResourceServer
public class OAuth2ResourceServer extends
        ResourceServerConfigurerAdapter {
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .anyRequest().authenticated().and()
                .requestMatchers().antMatchers("/api/**");
    }
}
