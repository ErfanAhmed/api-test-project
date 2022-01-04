package com.example.apiUsage.helper;

import com.example.apiUsage.Model.CountryInfo;
import com.example.apiUsage.Model.ExchangeRate;
import com.example.apiUsage.Model.Response;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CountryInfoHelper {

    public static Response prepareResponse(CountryInfo countryInfo, ExchangeRate exchangeRate) {
        return new Response(
                countryInfo.getName().getOfficial(),
                countryInfo.getPopulation(),
                countryInfo.getCurrencies().keySet(),
                getExchangeRatesToIDR(exchangeRate.getRates(), countryInfo.getCurrencies().keySet())
        );
    }

    private static Map<String, Double> getExchangeRatesToIDR(Map<String, Double> exchangeRates, Set<String> currencies) {
        Map<String, Double> exchangeRatesToIDR = new HashMap<>();

        double idr = exchangeRates.get("IDR");

        currencies.forEach(c -> {
            exchangeRatesToIDR.put(c, idr/exchangeRates.get(c));
        });

        return exchangeRatesToIDR;
    }
}
