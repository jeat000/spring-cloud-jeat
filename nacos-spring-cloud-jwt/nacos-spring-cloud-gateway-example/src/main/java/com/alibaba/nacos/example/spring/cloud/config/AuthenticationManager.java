package com.alibaba.nacos.example.spring.cloud.config;

import com.alibaba.nacos.example.spring.cloud.utils.JwtHelper;
import io.jsonwebtoken.Claims;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class AuthenticationManager implements ReactiveAuthenticationManager {

    @Override
    public Mono<Authentication> authenticate(Authentication authentication) {
        return Mono.just(authentication)
                .map(auth -> (Claims) auth.getPrincipal())
                .onErrorResume(e -> {
                    return Mono.empty();
                })
                .map(claims -> {
                    String authoritiesStr = (String) claims.get("authority");
                    List<String> authorities = Arrays.asList(authoritiesStr.split(","));
                    return new UsernamePasswordAuthenticationToken(claims.getSubject(), null,
                            authorities.stream().map(auth -> new SimpleGrantedAuthority(auth)).collect(Collectors.toList()));
                });
    }
}
