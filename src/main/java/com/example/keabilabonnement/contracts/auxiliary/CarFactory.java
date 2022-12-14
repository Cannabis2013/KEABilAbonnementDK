package com.example.keabilabonnement.contracts.auxiliary;

import java.sql.ResultSet;

public interface CarFactory {

    /*

        Authors: Nikki Deleuran - M. Kaan Arici - Stefan Jensen - Martin Hansen

    */

    CarDetails buildFromResultSet(ResultSet set);
    CarDetails fillDetailsFromResultSet(CarDetails details, ResultSet set);
}
