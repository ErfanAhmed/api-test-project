package com.example.apiUsage.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class AppConfig {

    @Bean(name = "country")
    public WebClient restCountriesApiClient() {
        return WebClient.create("https://restcountries.com/v3.1/name/");
    }

    @Bean(name = "currency")
    public WebClient restCurrencyApiClient() {
        return WebClient.create("http://data.fixer.io/api/latest?access_key=e056fb84a8c422775fa61f6fce629d7a");
    }
}
