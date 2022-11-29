package com.example.keabilabonnement.repository.mysql.registration;

import com.example.keabilabonnement.services.db.DBConnection;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class MySQLRegistrationRemover {
    public boolean remove(String id) {
        try {
            return DBConnection.statement("""
                    DELETE FROM RentalAgreement
                    WHERE id = ?;
                    """).setString(1,id).execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
