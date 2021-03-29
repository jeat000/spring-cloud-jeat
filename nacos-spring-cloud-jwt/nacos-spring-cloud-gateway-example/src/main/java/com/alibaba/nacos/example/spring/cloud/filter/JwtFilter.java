package com.alibaba.nacos.example.spring.cloud.filter;


import com.alibaba.nacos.example.spring.cloud.model.HttpResult;
import com.alibaba.nacos.example.spring.cloud.utils.JwtHelper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import lombok.SneakyThrows;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;


public class JwtFilter implements WebFilter {

    protected Mono<Void> writeErrorMessage(ServerHttpResponse response, HttpStatus status, String msg) throws JsonProcessingException, UnsupportedEncodingException {
        response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
        ObjectMapper mapper = new ObjectMapper();
        String body = mapper.writeValueAsString(new HttpResult(status.value(), msg, null));
        DataBuffer dataBuffer = response.bufferFactory().wrap(body.getBytes(StandardCharsets.UTF_8));
        return response.writeWith(Mono.just(dataBuffer));
    }

    //1.过期时间设置长点  例如 一周
    //2.设置永不过期，用redis 或者 concurrentHashMap 来控制
    //3.前端计时 比如 超过1个小时 有请求，则先 用老token 请求 刷新token的接口，老token过期则 跳转登录页面，未过期则返回新的token
    @SneakyThrows
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();
        String path = request.getURI().getPath();
        //登录不过滤
        System.out.println(path);
        if (path.contains("/login") || path.contains("service-static")) {
            return chain.filter(exchange);
        }

        String token = request.getHeaders().getFirst(HttpHeaders.AUTHORIZATION);

        final Claims claims = JwtHelper.parseJWT(token);
        if (claims == null) {
            return this.writeErrorMessage(response, HttpStatus.UNAUTHORIZED, "没有携带token");
        }
        exchange.getAttributes().put("claims", claims);
        return chain.filter(exchange);
    }
}
