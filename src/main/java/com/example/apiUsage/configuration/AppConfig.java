package com.example.apiUsage.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class AppConfig {

    @Bean
    public WebClient restCountriesApiClient() {
        return WebClient.create("https://restcountries.com/v3.1/name/");
    }
}
