package com.restcurrency.myapp.controller;

import com.restcurrency.myapp.model.Currency;
import com.restcurrency.myapp.service.CurrencyService;
import com.restcurrency.myapp.service.RatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@EnableScheduling
public class CurrencyController {

    @Autowired
    private final RestTemplate restTemplate;
    private final CurrencyService currencyService;
    private final RatesService ratesService;

    public CurrencyController(RestTemplate restTemplate, CurrencyService currencyService, RatesService ratesService) {
        this.restTemplate = restTemplate;
        this.currencyService = currencyService;
        this.ratesService = ratesService;
    }

    @Scheduled(fixedDelay = 10000L)
    @GetMapping("/currency")
    public Currency getCurrencies(){
        String url = "https://api.exchangeratesapi.io/latest";
        Currency currency = restTemplate.getForObject(url, Currency.class);
        currencyService.saveCurrency(currency);
        ratesService.saverates(currency.getRates());
        return currency;
    }
}
