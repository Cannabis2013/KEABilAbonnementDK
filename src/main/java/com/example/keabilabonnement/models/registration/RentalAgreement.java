package com.example.keabilabonnement.models.registration;

import com.example.keabilabonnement.models.entity.Entity;
import java.time.LocalDate;

public class RentalAgreement extends Entity {
    private LocalDate start;
    private LocalDate expiration;
    private LocalDate delevery;

    private String customerAddress;
    private String customerPhone;
    private double payment;

    private String licenseID;

    private String customerName;

    private String carNumber;

    public String getLicenseID() {
        return licenseID;
    }

    public void setLicenseID(String licenseID) {
        this.licenseID = licenseID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public LocalDate getExpiration() {
        return expiration;
    }

    public void setExpiration(LocalDate expiration) {
        this.expiration = expiration;
    }

    public LocalDate getDelevery() {
        return delevery;
    }

    public void setDelevery(LocalDate delevery) {
        this.delevery = delevery;
    }

    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }
}
