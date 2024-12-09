package com.crud_rest_api.product_catlog_backend;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  // This applies to all endpoints
                .allowedOrigins("https://crud-frontend-project-c153e12e87bc.herokuapp.com/")  // Specify the allowed frontend domain
                .allowedMethods("GET", "POST", "PUT", "DELETE")  // Specify allowed methods
                .allowedHeaders("*")  // Allow all headers
                .allowCredentials(true);  // Allow credentials like cookies
    }
}