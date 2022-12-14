package com.example.keabilabonnement.contracts.agreement;

import com.example.keabilabonnement.contracts.auxiliary.CarDetails;
import com.example.keabilabonnement.contracts.auxiliary.CustomerDetails;
import com.example.keabilabonnement.contracts.shared.Entity;

import java.time.LocalDate;

public interface Agreement extends Entity {

    /*

        Authors: Nikki Deleuran - M. Kaan Arici - Stefan Jensen - Martin Hansen

    */

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
    String getCustomerLicenseID();

    void setCustomerLicenseID(String licenseID);
}
