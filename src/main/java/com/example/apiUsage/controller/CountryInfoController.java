package com.example.apiUsage.controller;

import com.example.apiUsage.Model.CountryInfo;
import com.example.apiUsage.Model.Response;
import com.example.apiUsage.helper.CountryInfoHelper;
import com.example.apiUsage.service.ApiRestCountriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/v1/country")
public class CountryInfoController {

    @Autowired
    private ApiRestCountriesService apiRestCountriesService;

    @GetMapping("/name/{name}")
    public Response details(@PathVariable String name) {
        return CountryInfoHelper.prepareResponse(
                apiRestCountriesService
                        .getCountryDetailsByName(name));
    }

}
