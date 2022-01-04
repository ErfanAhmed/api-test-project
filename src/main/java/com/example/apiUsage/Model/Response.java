package com.example.apiUsage.Model;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Response {
    private String fullName;
    private int population;
    private Set<String> currencies;
    private Map<String, Double> exchangeRates;

    public Response(String fullName, int population, Set<String> currencies, Map<String, Double> exchangeRates) {
        this.fullName = fullName;
        this.population = population;
        this.currencies = currencies;
        this.exchangeRates = exchangeRates;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public Set<String> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(Set<String> currencies) {
        this.currencies = currencies;
    }

    public Map<String, Double> getExchangeRates() {
        return exchangeRates;
    }

    public void setExchangeRates(Map<String, Double> exchangeRates) {
        this.exchangeRates = exchangeRates;
    }
}
