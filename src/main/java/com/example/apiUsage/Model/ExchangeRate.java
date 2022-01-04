package com.example.apiUsage.Model;

import java.util.HashMap;
import java.util.Map;

public class ExchangeRate {
    private Map<String, Double> rates;

    public ExchangeRate() {
        this.rates = new HashMap<>();
    }

    public Map<String, Double> getRates() {
        return rates;
    }

    public void setRates(Map<String, Double> rates) {
        this.rates = rates;
    }
}
