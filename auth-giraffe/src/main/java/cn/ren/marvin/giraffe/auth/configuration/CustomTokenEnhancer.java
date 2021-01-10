package cn.ren.marvin.giraffe.auth.configuration;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

import cn.ren.marvin.giraffe.auth.model.UserInfo;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

/**
 * token的增强：在返回token的时候可以加上一些自定义数据
 * @author ：marvin ren
 * @date ：Created in 1/5/2021 1:54 PM
 * @description：
 * @modified By：
 * @version: 1.0
 */
public class CustomTokenEnhancer implements TokenEnhancer {

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        final Map<String, Object> additionalInfo = new HashMap<>();
        //增加授权组织信息
        additionalInfo.put("organization", authentication.getName() + randomAlphabetic(4));
        //增加用户姓名（以便直接使用）
        additionalInfo.put("username", ((UserInfo)authentication.getPrincipal()).getUsername());
        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);
        return accessToken;
    }
}
