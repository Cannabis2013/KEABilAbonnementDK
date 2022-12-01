package com.example.keabilabonnement.contracts.factories;

import com.example.keabilabonnement.models.customers.Customer;

import java.sql.ResultSet;

public interface CustomerFactory {
    Customer fromResultSet(ResultSet set);
}
