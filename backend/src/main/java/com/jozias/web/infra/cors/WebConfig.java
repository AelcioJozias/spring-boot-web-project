package com.jozias.web.infra.cors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                // Permitir requisições apenas de http://localhost:3001
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:3001") // Corrigido para a origem específica
                        .allowedMethods("GET", "POST", "PUT", "DELETE") // Defina os métodos permitidos
                        .allowedHeaders("*"); // Permitir todos os cabeçalhos
            }
        };
    }
}
