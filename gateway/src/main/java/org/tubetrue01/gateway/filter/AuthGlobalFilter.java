package org.tubetrue01.gateway.filter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * Created by IntelliJ IDEA.
 * User : Pengfei Zhang
 * Mail : Tubetrue01@gmail.com
 * Date : 2020/3/17
 * Time : 9:00 下午
 * Description :
 */
@Component
public class AuthGlobalFilter implements GlobalFilter, Ordered {

    @Value("${spring.security.user.name}")
    private String username;

    @Value("${spring.security.user.password}")
    private String password;


    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String auth = username.concat(":").concat(password);
        String encodeAuth = new String(Base64.getEncoder().encode(auth.getBytes(StandardCharsets.ISO_8859_1)));
        String authHeader = "Basic " + encodeAuth;
        ServerHttpRequest authorization = exchange.getRequest().mutate().header("Authorization", authHeader).build();
        ServerWebExchange build = exchange.mutate().request(authorization).build();
        return chain.filter(build);
    }

    @Override
    public int getOrder() {
        return 0;
    }

}
