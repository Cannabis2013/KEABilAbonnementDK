package com.example.keabilabonnement.models.cars;

import com.example.keabilabonnement.contracts.auxiliary.CarDetails;
import com.example.keabilabonnement.models.customers.Customer;

public class RentalCar extends Customer implements CarDetails {

    /*

        Authors: Martin Hansen - Nikki Deleuran - M. Kaan Arici - Stefan Jensen

    */

    protected String carNumber;
    protected String vin;
    protected int year;
    protected String brand;
    protected String model;

    @Override
    public String getBrand() {
        return brand;
    }

    @Override
    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String getInternalNumber() {
        return carNumber;
    }

    @Override
    public void setInternalNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    @Override
    public String getVin() {
        return vin;
    }

    @Override
    public void setVin(String vin) {
        this.vin = vin;
    }

    @Override
    public int getYear() {
        return year;
    }

    @Override
    public void setYear(int year) {
        this.year = year;
    }
}
