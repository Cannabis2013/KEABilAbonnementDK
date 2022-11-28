package com.example.keabilabonnement.Repository.Registration;

import com.example.keabilabonnement.repository.mysql.registration.MySQLRegistrationAdder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class TestRegistrationServices {
    @Test
    void contextLoad(){

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
    private TestRentalFactory rentalFactory;
}
