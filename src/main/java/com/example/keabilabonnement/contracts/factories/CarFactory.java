package com.example.keabilabonnement.contracts.factories;

import com.example.keabilabonnement.contracts.models.CarDetails;

import java.sql.ResultSet;

public interface CarFactory {
    CarDetails buildFromResultSet(ResultSet set);
    CarDetails fillDetailsFromResultSet(CarDetails details, ResultSet set);
}
