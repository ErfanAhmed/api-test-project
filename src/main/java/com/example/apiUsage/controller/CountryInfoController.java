package com.example.apiUsage.controller;

import com.example.apiUsage.Model.Response;
import com.example.apiUsage.helper.CountryInfoHelper;
import com.example.apiUsage.service.RestApiService;
import com.example.apiUsage.service.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.apiUsage.helper.CountryInfoHelper.prepareUserDetail;

@RestController()
@RequestMapping("/v1/country")
public class CountryInfoController {

    @Autowired
    private RestApiService apiRestCountriesService;

    @Autowired
    private UserDetailService userDetailService;

    @GetMapping("/name/{name}")
    public Response details(@PathVariable String name,
                            @AuthenticationPrincipal OAuth2User principal) {

        Response response = CountryInfoHelper.prepareResponse(
                apiRestCountriesService.getCountryDetailsByName(name),
                apiRestCountriesService.getExchangeRate());

        try {
            userDetailService.save(prepareUserDetail(response.getExchangeRates(), principal));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }
}
