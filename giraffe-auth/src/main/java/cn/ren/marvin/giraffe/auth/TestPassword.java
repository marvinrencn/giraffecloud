package cn.ren.marvin.giraffe.auth;

import org.springframework.core.io.ClassPathResource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

import java.security.KeyPair;

/**
 * @author ：marvin ren
 * @date ：Created in  2021-01-14 下午3:21
 * @description：
 * @modified By：
 * @version: 1.0
 */
public class TestPassword {
    public static void main(String[] args) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println(passwordEncoder.encode("amdin"));

        KeyStoreKeyFactory factory = new KeyStoreKeyFactory(
                new ClassPathResource("giraffe.jks"), "marvinrencn".toCharArray());
        KeyPair keyPair = factory.getKeyPair(
                "giraffe", "marvinrencn".toCharArray());
        System.out.println(keyPair.getPublic().toString());
    }
}
