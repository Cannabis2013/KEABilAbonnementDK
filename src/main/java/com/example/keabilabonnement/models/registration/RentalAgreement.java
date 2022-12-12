package com.example.keabilabonnement.models.registration;

import com.example.keabilabonnement.contracts.agreement.Agreement;
import com.example.keabilabonnement.contracts.shared.Entity;
import com.example.keabilabonnement.models.cars.RentalCar;
import java.time.LocalDate;

public final class RentalAgreement extends RentalCar implements Agreement {
    private String id;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }
    private LocalDate start;
    private LocalDate expiration;
    private LocalDate delevery;
    private double payment;

    @Override
    public LocalDate getStart() {
        return start;
    }

    @Override
    public void setStart(LocalDate start) {
        this.start = start;
    }

    @Override
    public LocalDate getExpiration() {
        return expiration;
    }

    @Override
    public void setExpiration(LocalDate expiration) {
        this.expiration = expiration;
    }

    @Override
    public LocalDate getDelevery() {
        return delevery;
    }

    @Override
    public void setDelevery(LocalDate delevery) {
        this.delevery = delevery;
    }

    @Override
    public double getPayment() {
        return payment;
    }

    @Override
    public void setPayment(double payment) {
        this.payment = payment;
    }

    @Override
    public void setCarNumber(String number) {
        carNumber = number;
    }

    @Override
    public String getCarNumber() {
        return carNumber;
    }

    @Override
    public String getCustomerLicenseID() {
        return licenseID;
    }

    @Override
    public void setCustomerLicenseID(String licenseID) {
        this.licenseID = licenseID;
    }
}
