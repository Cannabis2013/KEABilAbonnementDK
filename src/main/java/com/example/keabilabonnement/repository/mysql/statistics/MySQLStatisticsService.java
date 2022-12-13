package com.example.keabilabonnement.repository.mysql.statistics;

import com.example.keabilabonnement.contracts.statistics.StatisticsFactory;
import com.example.keabilabonnement.contracts.statistics.StatisticsService;
import com.example.keabilabonnement.models.analytics.Statistics;
import com.example.keabilabonnement.services.db.DBConnection;
import org.springframework.stereotype.Service;
import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class MySQLStatisticsService implements StatisticsService {
    /*

        Author: Martin Hansen

    */
    public MySQLStatisticsService(StatisticsFactory factory) {
        this.factory = factory;
    }

    @Override
    public Statistics getAgreementStatistics() {
        ResultSet result;
        try {
            result = DBConnection.statement("""
                    SELECT * FROM ActiveRevenue, NumberOfavailableCars, NumberOfUnavailableCars; ;
                    """).executeQuery();
            return factory.fromResultSet(result);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    private final StatisticsFactory factory;
}
