package com.example.keabilabonnement.Repository.Registration;

import com.example.keabilabonnement.contracts.db.DbStatement;
import com.example.keabilabonnement.repository.mysql.registration.MySQLRegistrationAdder;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestRegistrationServices {
    @Test
    void contextLoad(){

    }

    @AfterAll
    void cleanUp(){
        /*
            Cleanup section

            Removing RentalAgreement from database
         */
        try {
            statement.get("""
                    DELETE FROM RentalAgreement
                    WHERE id = '42a90b5e-bc1a-4380-aa34-d47c21fc617b';
                    """).execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    void addRegistrationWithDummyValues(){
        var rental = rentalFactory.rentalOne();
        var result = dbRegistrationAdder.add(rental);
        assertTrue(result);
    }

    @Autowired
    private MySQLRegistrationAdder dbRegistrationAdder;
    @Autowired
    private DbStatement statement;
    @Autowired
    private TestRentalFactory rentalFactory;
}
