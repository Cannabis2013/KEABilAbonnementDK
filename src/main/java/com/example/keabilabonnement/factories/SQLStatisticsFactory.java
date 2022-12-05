package com.example.keabilabonnement.factories;

import com.example.keabilabonnement.contracts.statistics.StatisticsFactory;
import com.example.keabilabonnement.models.analytics.Statistics;
import org.springframework.stereotype.Service;
import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class SQLStatisticsFactory implements StatisticsFactory {
    @Override
    public Statistics fromResultSet(ResultSet set) throws SQLException {
        var statistics = new Statistics();
        if(set.next()){
            statistics.setRevenue(set.getDouble("Revenue"));
            statistics.setActiveSubscriptions(set.getInt("Active"));
            statistics.setInactiveSubscription(set.getInt("Inactive"));
            statistics.setTotal(set.getInt("Inactive"));
        }
        return statistics;
    }
}
