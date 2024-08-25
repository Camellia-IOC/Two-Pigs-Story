package org.demo.TwoPigsStoryBackend.config.security.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * 安全服务工具类
 *
 * @author KaryCc
 */
public class SecurityUtils {
    /**
     * 加密密码
     *
     * @param password 密码
     *
     * @return 加密后的密码
     */
    public static String encodePassword (String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(password);
    }
    
    /**
     * 判断密码是否相同
     *
     * @param input  当前输入的密码
     * @param encode 加密后的密码
     *
     * @return 结果
     */
    public static boolean matchPassword (String input, String encode) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.matches(input, encode);
    }
}
