package cn.ren.marvin.giraffe.auth;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author ：marvin ren
 * @date ：Created in 1/7/2021 1:05 PM
 * @description：
 * @modified By：
 * @version: 1.0
 */
public class TestC {
    public static void main(String[] args) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        System.out.println(bCryptPasswordEncoder.encode("admin"));
    }
}
