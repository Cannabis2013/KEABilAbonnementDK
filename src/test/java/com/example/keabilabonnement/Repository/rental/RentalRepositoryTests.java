package com.example.keabilabonnement.Repository.rental;

import com.example.keabilabonnement.repository.mysql.agreement.AgreementPersistence;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class RentalRepositoryTests {
    @AfterAll
    void cleanUp(){
        cleaner.cleanUp();
    }

    @Test
    void addRegistrationWithDummyValues(){
        var rental = rentalFactory.rentalOne();
        var result = dbRegistrationAdder.add(rental);
        assertTrue(result);
    }

    @Autowired
    private AgreementPersistence dbRegistrationAdder;

    @Autowired
    private RentalFactoryTest rentalFactory;

    @Autowired
    private RentalTestCleanup cleaner;
}
