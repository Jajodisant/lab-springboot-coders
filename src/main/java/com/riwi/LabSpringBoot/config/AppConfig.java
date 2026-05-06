package com.riwi.LabSpringBoot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Configuration
public class AppConfig {

    @Bean
    public LocalDateTime serverStartTime() {
        return LocalDateTime.now();
    }
}
