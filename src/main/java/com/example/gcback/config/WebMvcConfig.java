package com.example.gcback.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import java.util.List;

@Configuration
public class WebMvcConfig {

    @Bean
    public CorsConfiguration corsConfiguration(){
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowedHeaders(List.of("Authorization", "Cache-Control", "Content-Type"));
        corsConfiguration.setAllowedOrigins(List.of(
                //DEV
                "http://127.0.0.1:4200/",
                "http://localhost:4200/",
                "http://127.0.0.1:4201/",
                "http://localhost:4201/",
                "http://127.0.0.1:4202/",
                "http://localhost:4202/",
                //PROD
                "http://127.0.0.1:9999/",
                "http://localhost:9999/",
                "http://193.0.0.66:9999/"
        ));
        corsConfiguration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "PUT","OPTIONS","PATCH", "DELETE"));
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.setExposedHeaders(List.of("Authorization"));
        return corsConfiguration;
    }

}
