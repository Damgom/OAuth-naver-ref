package com.damgom.oauthnaver.feign;

import feign.Client;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableFeignClients
@Configuration
public class LoginConfig {
    @Bean
    public Client feignClient() {
        return new Client.Default(null, null);
    }
}
