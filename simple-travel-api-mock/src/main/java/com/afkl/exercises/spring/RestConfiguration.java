package com.afkl.exercises.spring;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
public class RestConfiguration extends WebMvcConfigurerAdapter {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
            .allowedOrigins("http://localhost:9000")
            .allowedMethods("POST", "GET", "OPTIONS")
            .allowedHeaders("Access-Control-Allow-Origin", "Content-Type", "Authorization")
            .allowCredentials(false).maxAge(3600);
    }
}