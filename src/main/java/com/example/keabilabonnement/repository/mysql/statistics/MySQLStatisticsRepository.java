package com.example.keabilabonnement.repository.mysql.statistics;

import com.example.keabilabonnement.contracts.repository.StatisticsRepository;
import com.example.keabilabonnement.factories.SQLStatisticsFactory;
import com.example.keabilabonnement.models.analytics.Statistics;
import com.example.keabilabonnement.services.db.DBConnection;
import org.springframework.stereotype.Service;
import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class MySQLStatisticsRepository implements StatisticsRepository {
    public MySQLStatisticsRepository(SQLStatisticsFactory factory) {
        this.factory = factory;
    }

    @Override
    public Statistics getAgreementStatistics() {
        ResultSet result;
        try {
            result = DBConnection.statement("""
                    SELECT ar.Revenue ,as2.Active, as3.Inactive, COUNT(ra.Id) as total
                    FROM ActiveRevenue ar , ActiveSubscriptions as2,InActiveSubscriptions as3, RentalAgreement ra ;
                    """).executeQuery();
            return factory.fromResultSet(result);
        } catch (SQLException e) {
            return null;
        }
    }

    private final SQLStatisticsFactory factory;
}
