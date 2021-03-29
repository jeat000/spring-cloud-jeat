package com.alibaba.nacos.example.spring.cloud.config;

import com.alibaba.nacos.example.spring.cloud.filter.JwtFilter;
import com.alibaba.nacos.example.spring.cloud.handler.MyAccessDeniedHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.access.vote.RoleHierarchyVoter;
import org.springframework.security.access.vote.RoleVoter;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

import java.util.Base64;

@EnableWebFluxSecurity
@EnableReactiveMethodSecurity
public class SecurityConfig {

    @Autowired
    private SecurityContextRepository securityContextRepository;

    @Bean
    public RoleHierarchy roleHierarchy() {
        RoleHierarchyImpl roleHierarchy = new RoleHierarchyImpl();
        roleHierarchy.setHierarchy("ROLE_user > ROLE_user2");
        return roleHierarchy;
    }

    //webflux
    @Bean
    public SecurityWebFilterChain springWebFilterChain(ServerHttpSecurity http, RoleHierarchy roleHierarchy) {
        //权限不足 自定义拒绝策略
        http.exceptionHandling().accessDeniedHandler(new MyAccessDeniedHandler());

        return http
                .authorizeExchange(path -> path
                        //自定义访问权限
                        .pathMatchers("/service-consumer/**").access(new CustomReactiveAuthorizationManager<>("ROLE_user2", roleHierarchy))
                        .pathMatchers("/service-static/**").permitAll()
                        .pathMatchers("/login").permitAll()
                        .anyExchange().authenticated()
                )
                //检测是否有token的过滤器
                .addFilterAfter(new JwtFilter(), SecurityWebFiltersOrder.FIRST)
                //通过token 处理权限
                .securityContextRepository(securityContextRepository)
                .formLogin().disable()
                .httpBasic().disable()
                .csrf().disable()
                .logout().disable()
                .build();

    }


    public static void main(String[] args) {
        byte[] bytes = Base64.getDecoder().decode("eyJhdXRob3JpdHkiOiJhZG1pbixnb2QsUk9MRV91c2VyIiwidXNlcmlkIjoxLCJzdWIiOiJhYmMiLCJleHAiOjE2MTEyMDIxNzIsIm5iZiI6MTYxMTE5ODU3Mn0");
        String str = new String(bytes);
        System.out.println(str);


        String s = "{\"authority\":\"admin,god\",\"userid\":1,\"sub\":\"abc\",\"exp\":1611202172,\"nbf\":1611198572}";
        byte[] encode = Base64.getEncoder().encode(s.getBytes());
        System.out.println(new String(encode));
    }
}
