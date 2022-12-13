package com.example.keabilabonnement.contracts.auxiliary;

public interface CustomerDetails {

    /*

        Authors: Nikki Deleuran - M. Kaan Arici - Stefan Jensen - Martin Hansen

    */

    String getCustomerName();

    void setCustomerName(String customerName);

    String getCustomerAddress();

    void setCustomerAddress(String customerAddress);

    String getCustomerPhone();

    void setCustomerPhone(String customerPhone);

    String getLicenseID();

    void setLicenseID(String licenseID);
}
