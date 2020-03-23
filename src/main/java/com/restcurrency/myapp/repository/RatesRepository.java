package com.restcurrency.myapp.repository;

import com.restcurrency.myapp.model.Rates;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatesRepository extends JpaRepository<Rates, Long> {
}
