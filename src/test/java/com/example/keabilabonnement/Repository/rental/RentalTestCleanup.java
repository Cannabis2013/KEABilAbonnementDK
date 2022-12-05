package com.example.keabilabonnement.Repository.rental;

import com.example.keabilabonnement.services.db.DBConnection;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class RentalTestCleanup {
    public void cleanUp(){
        /*
            Cleanup section

            Removing RentalAgreement from database
         */
        try {
            DBConnection.statement("""
                    DELETE FROM RentalAgreement
                    WHERE id = '42a90b5e-bc1a-4380-aa34-d47c21fc617b';
                    """).execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
