package com.example.apiUsage.service;

import com.example.apiUsage.Model.CountryInfo;
import com.example.apiUsage.Model.ExchangeRate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

@Service
public class RestApiService {

    @Qualifier("country")
    @Autowired
    private WebClient countryWebClient;

    @Qualifier("currency")
    @Autowired
    private WebClient currencyWebClient;

    public CountryInfo getCountryDetailsByName(String name) {
        return countryWebClient
                .get()
                .uri(name)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(CountryInfo[].class)
                .block()[0];
    }

    public ExchangeRate getExchangeRate() {
        return currencyWebClient
                .get()
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(ExchangeRate.class)
                .block();
    }
}
