package org.tubetrue01.userconsumer.configuration;

import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by IntelliJ IDEA.
 * User : Pengfei Zhang
 * Mail : Tubetrue01@gmail.com
 * Date : 2020/3/17
 * Time : 4:09 下午
 * Description :
 */
@Configuration
public class OpenfeignConfiguration {

    @Value("${spring.security.user.name}")
    private String username;

    @Value("${spring.security.user.password}")
    private String password;

    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
        return new BasicAuthRequestInterceptor(username, password);
    }
    //
    // @Bean
    // public Logger.Level feignLoggerLevel() {
    //     return Logger.Level.FULL;
    // }
}
