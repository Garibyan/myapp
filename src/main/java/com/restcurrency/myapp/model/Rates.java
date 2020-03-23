package com.restcurrency.myapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "Rates")
public class Rates {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @JsonProperty("RUB")
    private double rub;
    @JsonProperty("USD")
    private double usd;
    @JsonProperty("GBP")
    private double gbp;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "currencyId", referencedColumnName = "id")
    private Currency currencyId;

    public double getRub() {
        return rub;
    }
    public void setRub(double rub) {
        this.rub = rub;
    }
    public double getUsd() {
        return usd;
    }
    public void setUsd(double usd) {
        this.usd = usd;
    }
    public double getGbp() {
        return gbp;
    }
    public void setGbp(double gbp) {
        this.gbp = gbp;
    }
}
