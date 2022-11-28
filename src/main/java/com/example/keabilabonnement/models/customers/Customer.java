package com.example.keabilabonnement.models.customers;

import com.example.keabilabonnement.models.entity.Entity;

public class Customer extends Entity {
    private String licenseID;

    public String getLicenseID() {
        return licenseID;
    }

    public void setLicenseID(String licenseID) {
        this.licenseID = licenseID;
    }
}
