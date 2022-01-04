package com.example.apiUsage.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountryInfo {

    private Name name;
    private Map<String, Currency> currencies;
    private int population;

    public CountryInfo() {
        this.currencies = new HashMap<>();
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Map<String, Currency> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(Map<String, Currency> currencies) {
        this.currencies = currencies;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Country Information: \n")
                .append("Full Name: " + name.getOfficial())
                .append("Population: " + population)
                .append("\nCurrency: \n");

        currencies.keySet().forEach(k -> {
            stringBuilder.append(currencies.get(k).getName() + " ");
        });

        return stringBuilder.toString();
    }
}
