package com.example.keabilabonnement.contracts.statistics;

import com.example.keabilabonnement.models.analytics.Statistics;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface StatisticsFactory {
    Statistics fromResultSet(ResultSet set) throws SQLException;
}
