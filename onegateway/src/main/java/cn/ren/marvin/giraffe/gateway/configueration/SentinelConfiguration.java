package cn.ren.marvin.giraffe.gateway.configueration;

import com.alibaba.cloud.sentinel.SentinelProperties;
import com.alibaba.cloud.sentinel.datasource.config.NacosDataSourceProperties;
import com.alibaba.csp.sentinel.adapter.gateway.common.rule.GatewayFlowRule;
import com.alibaba.csp.sentinel.adapter.gateway.common.rule.GatewayRuleManager;
import com.alibaba.csp.sentinel.adapter.gateway.sc.SentinelGatewayFilter;
import com.alibaba.csp.sentinel.datasource.ReadableDataSource;
import com.alibaba.csp.sentinel.datasource.nacos.NacosDataSource;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

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
