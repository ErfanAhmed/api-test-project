package com.example.apiUsage.service;

import com.example.apiUsage.Model.CountryInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class ApiRestCountriesService {

    @Autowired
    private WebClient webClient;

    public CountryInfo getCountryDetailsByName(String name) {
        return webClient
                .get()
                .uri(name)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(CountryInfo[].class)
                .block()[0];
    }
}
