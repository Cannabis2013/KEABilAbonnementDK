package com.example.keabilabonnement.models.customers;

import com.example.keabilabonnement.contracts.auxiliary.CustomerDetails;

public class Customer implements CustomerDetails {
    protected String licenseID;
    protected String customerName;
    protected String customerAddress;
    protected String customerPhone;


    @Override
    public String getCustomerName() {
        return customerName;
    }

    @Override
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Override
    public String getCustomerAddress() {
        return customerAddress;
    }

    @Override
    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    @Override
    public String getCustomerPhone() {
        return customerPhone;
    }

    @Override
    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    @Override
    public String getLicenseID() {
        return licenseID;
    }

    @Override
    public void setLicenseID(String licenseID) {
        this.licenseID = licenseID;
    }
}
