package org.tubetrue01.gateway.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

/**
 * Created by IntelliJ IDEA.
 * User : Pengfei Zhang
 * Mail : Tubetrue01@gmail.com
 * Date : 2020/3/17
 * Time : 9:24 下午
 * Description :
 */
@EnableWebFluxSecurity
public class GatewaySecurityConfiguration {

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {

        return http.authorizeExchange()
                .pathMatchers("/actuator/**")
                .authenticated().and()
                .authorizeExchange()
                .anyExchange().permitAll().and()
                .formLogin().and()
                .httpBasic().and()
                .csrf().disable()
                .build();
    }

}
