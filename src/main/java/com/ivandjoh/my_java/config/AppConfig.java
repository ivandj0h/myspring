package com.ivandjoh.my_java.config;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public String externalApiUrl() {
        Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();
        return dotenv.get("EXTERNAL_API_URL");
    }
}
