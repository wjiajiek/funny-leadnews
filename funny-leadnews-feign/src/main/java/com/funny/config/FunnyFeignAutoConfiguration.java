package com.funny.config;

import feign.Logger;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "com.funny.feigns")
@ComponentScan("com.funny.feigns.fallback")
public class FunnyFeignAutoConfiguration {
    @Bean
    Logger.Level level(){
        return Logger.Level.FULL;
    }
}