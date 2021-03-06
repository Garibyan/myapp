package com.restcurrency.myapp.repository;

import com.restcurrency.myapp.model.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepository extends JpaRepository<Currency, Long> {
}
