package com.example.apiUsage.helper;

import com.example.apiUsage.Model.CountryInfo;
import com.example.apiUsage.Model.Response;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CountryInfoHelper {

    public static Response prepareResponse(CountryInfo countryInfo) {
        return new Response(
                countryInfo.getName().getOfficial(),
                countryInfo.getPopulation(),
                countryInfo.getCurrencies().keySet()
        );
    }
}
