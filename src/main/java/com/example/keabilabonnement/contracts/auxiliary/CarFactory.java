package com.example.keabilabonnement.contracts.auxiliary;

import java.sql.ResultSet;

public interface CarFactory {
    CarDetails buildFromResultSet(ResultSet set);
    CarDetails fillDetailsFromResultSet(CarDetails details, ResultSet set);
}
