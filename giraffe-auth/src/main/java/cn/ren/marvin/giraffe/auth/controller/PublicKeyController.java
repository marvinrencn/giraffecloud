package cn.ren.marvin.giraffe.auth.controller;

import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.KeyPair;
import java.security.interfaces.RSAPublicKey;
import java.util.Map;

/**
 * @author ：marvin ren
 * @date ：Created in  2021-01-14 下午3:30
 * @description：
 * @modified By：
 * @version: 1.0
 */
@RestController
@AllArgsConstructor
public class PublicKeyController {

    private KeyPair keyPair;

    @GetMapping("/oauth/getPublicKey")
    public Map<String, Object> getPublicKey() {
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        RSAKey key = new RSAKey.Builder(publicKey).build();
        return new JWKSet(key).toJSONObject();
    }

}
