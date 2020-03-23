package com.restcurrency.myapp.service;

import com.restcurrency.myapp.model.Currency;
import com.restcurrency.myapp.repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CurrencyService {

    @Autowired
    private final CurrencyRepository currencyRepository;

    public CurrencyService(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }
    @Transactional
    public void saveCurrency(Currency currency){
        currencyRepository.saveAndFlush(currency);
    }
}
