package com.alibaba.nacos.example.spring.cloud.handler;

import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.server.authorization.ServerAccessDeniedHandler;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


/**
 * @author fucker
 */
public class MyAccessDeniedHandler implements ServerAccessDeniedHandler {
//    @Override
//    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
//        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
//        response.setHeader("Content-Type", "application/json;charset=UTF-8");
//        PrintWriter out = response.getWriter();
//        out.write("{\"status\":\"error\",\"msg\":\"权限不足，请联系管理员！\"}");
//        out.flush();
//        out.close();
//    }

    @Override
    public Mono<Void> handle(ServerWebExchange exchange, AccessDeniedException denied) {
        ServerHttpResponse response = exchange.getResponse();
        response.setStatusCode(HttpStatus.UNAUTHORIZED);
        response.getHeaders().add("Content-Type", "application/json;charset=UTF-8");
        byte[] responseStr = "{\"status\":\"error\",\"msg\":\"权限不足，请联系管理员！\"}".getBytes();
        DataBuffer buffer = response.bufferFactory().wrap(responseStr);
        return response.writeWith(Flux.just(buffer));
    }
}
