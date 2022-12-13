package com.example.keabilabonnement.contracts.auxiliary;

import java.sql.ResultSet;

public interface CustomerFactory {

    /*

        Authors: Nikki Deleuran - M. Kaan Arici - Stefan Jensen - Martin Hansen

    */

    CustomerDetails buildFromResultSet(ResultSet set);
    CustomerDetails fillDetailsFromResultSet(CustomerDetails details,ResultSet set);
}
