package cn.ren.marvin.giraffe.gateway.configueration;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author ：marvin ren
 * @date ：Created in  2021-01-11 下午3:05
 * @description：
 * @modified By：
 * @version: 1.0
 */
@Component
public class TokenGloabelFilter implements GlobalFilter, Ordered {
    Logger logger = LoggerFactory.getLogger(TokenGloabelFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // the uri path must star wiht '/api'
        if (exchange.getRequest().getURI().getPath().startsWith("/api")) {
            String token = exchange.getRequest().getQueryParams().getFirst("token");
            if (StringUtils.isEmpty(token)) {
                token = exchange.getRequest().getHeaders().getFirst("Authorization");
            }
            if (StringUtils.isEmpty(token)) {
                logger.info("token is empty...");
                // throw the exception, which will be responsed by the global exception handle.
                throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
                // direct response
                // exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                // return exchange.getResponse().setComplete();
            }
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return -100;
    }
}
