package com.example.keabilabonnement.contracts.auxiliary;

public interface CarDetails {
    String getBrand();

    void setBrand(String brand);

    String getModel();

    void setModel(String model);

    String getInternalNumber();

    void setInternalNumber(String carNumber);

    String getVin();

    void setVin(String vin);

    int getYear();

    void setYear(int year);
}
