package com.example.keabilabonnement.contracts.factories;

import com.example.keabilabonnement.contracts.models.CustomerDetails;

import java.sql.ResultSet;

public interface CustomerFactory {
    CustomerDetails buildFromResultSet(ResultSet set);
    CustomerDetails fillDetailsFromResultSet(CustomerDetails details,ResultSet set);
}
