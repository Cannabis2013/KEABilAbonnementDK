package com.example.keabilabonnement.models.cars;

import com.example.keabilabonnement.models.entity.Entity;

public class Car extends Entity {
    private String carNumber;

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }
}
