package com.example.delivery_ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EntityScan(basePackages = "com.example.delivery_ms.entity")
@EnableEurekaClient

public class DeliveryMsApplication {

    public static void main(String[] args) {
        SpringApplication.run(DeliveryMsApplication.class, args);
    }

    @Bean
    public WebMvcConfigurer corsCofigurer()
    {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("http://localhost:3000/**");
            }
        };
    }

}
