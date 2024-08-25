package org.demo.TwoPigsStoryBackend.config.security;

import lombok.Getter;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Spring Security 模拟数据
 */
public class SecurityConstant {
    /**
     * 模拟用户数据。key：用户名，value：密码
     */
    public static final Map<String, String> USER_MAP = new ConcurrentHashMap<>();
    
    /**
     * 模拟权限数据。key：接口地址，value：所需权限
     */
    public static final Map<String, ConfigAttribute> PERMISSION_MAP = new ConcurrentHashMap<>();
    
    /**
     * 用户权限数据。key：用户名，value：权限
     */
    public static final Map<String, List<PERMISSION>> USER_PERMISSION_MAP = new ConcurrentHashMap<>();
    
    /**
     * 白名单
     */
    public static final String[] WHITELIST = {"/login"};
    
    static {
        // 填充模拟用户数据
        USER_MAP.put("admin", "$2a$10$KOvypkjLRv/iJo/hU5GOSeFsoZzPYnh2B4r7LPI2x8yBTBZhPLkhy");
        USER_MAP.put("user", "$2a$10$KOvypkjLRv/iJo/hU5GOSeFsoZzPYnh2B4r7LPI2x8yBTBZhPLkhy");
        // 填充用户权限
        USER_PERMISSION_MAP.put("admin", List.of(PERMISSION.ADMIN, PERMISSION.USER));
        USER_PERMISSION_MAP.put("user", List.of(PERMISSION.USER));
        // 填充接口权限
        PERMISSION_MAP.put("/user", new SecurityConfig(PERMISSION.USER.getValue()));
        PERMISSION_MAP.put("/admin", new SecurityConfig(PERMISSION.ADMIN.getValue()));
    }
    
    /**
     * 模拟权限
     */
    @Getter
    public enum PERMISSION {
        ADMIN("admin"), USER("user");
        
        private final String value;
        
        private PERMISSION (String value) {
            this.value = value;
        }
    }
}
