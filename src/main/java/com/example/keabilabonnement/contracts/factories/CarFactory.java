package com.example.keabilabonnement.contracts.factories;

import com.example.keabilabonnement.models.cars.Car;

import java.sql.ResultSet;

public interface CarFactory {
    Car fromResultSet(ResultSet set);
}
