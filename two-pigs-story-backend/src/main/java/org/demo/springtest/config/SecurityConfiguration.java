//package org.demo.springtest.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
//import org.springframework.security.config.web.server.ServerHttpSecurity;
//import org.springframework.security.web.server.SecurityWebFilterChain;
//
//@Configuration
//@EnableWebFluxSecurity
//public class SecurityConfiguration {
//    @Bean
//    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
//        return http
//                .authorizeExchange(authorizeExchanges -> authorizeExchanges
//                        .pathMatchers("/api/**").permitAll() // 允许所有人访问公共接口
//                        .anyExchange().authenticated() // 其他请求需要认证
//                )
//                .build();
//    }
//}
//
