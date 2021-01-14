package onegateway.configueration;

import com.alibaba.cloud.sentinel.SentinelProperties;
import com.alibaba.csp.sentinel.adapter.gateway.sc.SentinelGatewayFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

/**
 * @author ：marvin ren
 * @date ：Created in  2021-01-11 下午9:22
 * @description：
 * @modified By：
 * ersion: 1.0
 */
@Configuration
public class SentinelConfiguration {

    @Autowired
    private SentinelProperties sentinelProperties;

    /**
     * add sentinel global filter
     * @return
     */
    @Bean
    @Order(-1)
    public GatewayFilter sentinelGloabelFilter(){
        return new SentinelGatewayFilter();
    }


}
