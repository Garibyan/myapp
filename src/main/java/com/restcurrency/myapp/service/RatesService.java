package com.restcurrency.myapp.service;

import com.restcurrency.myapp.model.Currency;
import com.restcurrency.myapp.model.Rates;
import com.restcurrency.myapp.repository.RatesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class RatesService {


    @Autowired
    private final RatesRepository ratesRepository;

    public RatesService(RatesRepository ratesRepository) {
        this.ratesRepository = ratesRepository;
    }

    @Transactional
    public void saverates(Rates rates){
        ratesRepository.saveAndFlush(rates);
    }
}
