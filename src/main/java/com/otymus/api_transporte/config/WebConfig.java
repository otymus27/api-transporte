package com.otymus.api_transporte.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        System.out.println("CORS configurado!");
        registry.addMapping("/**") // Define para qual endpoint da API a configuração se aplica ("/**" permite todas)
                .allowedOrigins("http://localhost:5173") // Domínio do seu frontend
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Métodos HTTP permitidos
                .allowedHeaders("*") // Cabeçalhos permitidos
                .allowCredentials(true) // Se você precisar enviar cookies
                .maxAge(3600); // Tempo de cache da preflight request em segundos
    }
}
