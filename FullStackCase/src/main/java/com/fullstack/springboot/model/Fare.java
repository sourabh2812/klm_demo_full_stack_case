package com.fullstack.springboot.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.jsonschema.JsonSerializableSchema;

/**
 * Created by Sourabh Suman on 06/12/2017.
 */
@JsonSerializableSchema
@JsonIgnoreProperties(ignoreUnknown = true)
public class Fare {

    double amount;
    Currency currency;
    Location origin, destination;

    public Fare() {
    }

    public Fare(FareResponse fareResponse) {
        this();
        this.amount = fareResponse.getAmount();
        this.currency = fareResponse.getCurrency();
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Location getOrigin() {
        return origin;
    }

    public void setOrigin(Location origin) {
        this.origin = origin;
    }

    public Location getDestination() {
        return destination;
    }

    public void setDestination(Location destination) {
        this.destination = destination;
    }

    @Override
    public String toString() {
        return "Fare{" +
                "amount=" + amount +
                ", currency=" + currency +
                ", origin=" + origin +
                ", destination=" + destination +
                '}';
    }
}
