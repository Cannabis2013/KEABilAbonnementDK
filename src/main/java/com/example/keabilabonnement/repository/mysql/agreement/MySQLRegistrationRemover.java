package com.example.keabilabonnement.repository.mysql.agreement;

import com.example.keabilabonnement.services.db.DBConnection;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class MySQLRegistrationRemover {
    public boolean remove(String id) {
        try {
            var statement = DBConnection.statement("""
                    DELETE FROM RentalAgreement
                    WHERE id = ?;
                    """);
            statement.setString(1,id);
            statement.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }
}
