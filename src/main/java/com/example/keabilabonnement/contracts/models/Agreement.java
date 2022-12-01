package com.example.keabilabonnement.contracts.models;

import java.time.LocalDate;

public interface Agreement extends CustomerDetails, CarDetails {
    String getId();

    void setId(String id);

    LocalDate getStart();

    void setStart(LocalDate start);

    LocalDate getExpiration();

    void setExpiration(LocalDate expiration);

    LocalDate getDelevery();

    void setDelevery(LocalDate delevery);

    double getPayment();

    void setPayment(double payment);

    void setCarNumber(String number);
    String getCarNumber();
}
