package com.example.apiUsage.helper;

import com.example.apiUsage.Model.CountryInfo;
import com.example.apiUsage.Model.ExchangeRate;
import com.example.apiUsage.Model.Response;
import com.example.apiUsage.domain.ExchangeRateDetail;
import com.example.apiUsage.domain.UserDetail;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.*;

public class CountryInfoHelper {

    public static Response prepareResponse(CountryInfo countryInfo, ExchangeRate exchangeRate) {
        return new Response(
                countryInfo.getName().getOfficial(),
                countryInfo.getPopulation(),
                countryInfo.getCurrencies().keySet(),
                getExchangeRatesToIDR(exchangeRate.getRates(), countryInfo.getCurrencies().keySet())
        );
    }

    public static UserDetail prepareUserDetail(Map<String, Double> exchangeRatesToIDR, OAuth2User principal) {

        List<ExchangeRateDetail> exchangeRateDetails = new ArrayList<>();

        UserDetail userDetail = new UserDetail();
        userDetail.setUserName(principal.getAttribute("name"));
        userDetail.setEmail(principal.getAttribute("email"));

        exchangeRatesToIDR.forEach((cur, rate) -> {
            exchangeRateDetails.add(new ExchangeRateDetail(cur, rate));
        });

        userDetail.getExchangeRateDetails().addAll(exchangeRateDetails);

        return userDetail;
    }

    private static Map<String, Double> getExchangeRatesToIDR(Map<String, Double> exchangeRates, Set<String> currencies) {
        Map<String, Double> exchangeRatesToIDR = new HashMap<>();

        double idr = exchangeRates.get("IDR");

        currencies.forEach(c -> {
            exchangeRatesToIDR.put(c, idr / exchangeRates.get(c));
        });

        return exchangeRatesToIDR;
    }
}
