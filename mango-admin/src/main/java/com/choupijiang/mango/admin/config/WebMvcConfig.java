package com.choupijiang.mango.admin.config;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebMvcConfig implements WebMvcConfigurer {


    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("POST", "GET", "PUT", "DELETE", "OPTIONS")
                .maxAge(168000)
                .allowedHeaders("*")
                .allowCredentials(true);

    }

}
