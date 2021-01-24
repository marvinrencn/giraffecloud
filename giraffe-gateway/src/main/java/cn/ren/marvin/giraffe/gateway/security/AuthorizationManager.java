package cn.ren.marvin.giraffe.gateway.security;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.authorization.ReactiveAuthorizationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.server.authorization.AuthorizationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author ：marvin ren
 * @date ：Created in  2021-01-14 下午8:12
 * @description：
 * @modified By：
 * @version: 1.0
 */
@Component
@AllArgsConstructor
@Slf4j
public class AuthorizationManager implements ReactiveAuthorizationManager<AuthorizationContext> {

    @Autowired
    private RestTemplate restTemplate;


    @Override
    public Mono<AuthorizationDecision> check(Mono<Authentication> mono, AuthorizationContext authorizationContext) {

//        return Mono.just(new AuthorizationDecision(true));

        URI uri = authorizationContext.getExchange().getRequest().getURI();

        //通过auth服务获取path的权限需求列表
        // TODO: 1/23/2021 该部分需要提供缓存能力，提升访问速度
        ResponseEntity<ResourceInfoDto[]> forEntity = restTemplate.getForEntity("http://giraffe-auth/oauth/resourcePathRule", ResourceInfoDto[].class);
        List<ResourceInfoDto> pathAuthorizationCache = Arrays.asList(Objects.requireNonNull(forEntity.getBody()));
        pathAuthorizationCache.sort(Comparator.comparingInt(ResourceInfoDto::getSite));

        //寻找匹配url路径的权限
        AntPathMatcher antPathMatcher = new AntPathMatcher();
        String authorities = null;
        for (ResourceInfoDto authorization:pathAuthorizationCache) {
            if(antPathMatcher.match(authorization.getPath(), uri.getPath())){
                //由于我们获取的权限编码是角色编码，需要增加前缀ROLE_
                authorities = Arrays.stream(authorization.getRoleCodes().split(",")).map((auth)-> AuthConstants.AUTHORITY_PREFIX +auth).collect(Collectors.joining(","));
                break;
            }
        }


        if(StringUtils.isEmpty(authorities)){
            //如果没有匹配的权限则返回授权通过
            return Mono.just(new AuthorizationDecision(true));
        } else {
            //过滤授权
            log.info("this authorities [{}] is needed.", authorities);
            List<String> authoritiesList = Collections.singletonList(authorities);
            return mono
                .filter(Authentication::isAuthenticated)
                .flatMapIterable(Authentication::getAuthorities)
                .map(GrantedAuthority::getAuthority).log()
                .any(authoritiesList::contains)
                .map(AuthorizationDecision::new)
                .defaultIfEmpty(new AuthorizationDecision(false));
        }


    }
}
