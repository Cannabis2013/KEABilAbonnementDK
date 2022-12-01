package com.example.keabilabonnement.contracts.repository;

import com.example.keabilabonnement.contracts.models.Agreement;
import com.example.keabilabonnement.models.registration.RentalAgreement;

import java.util.List;

public interface RegistrationRepository {
    boolean addRegistration(Agreement agreement);
    boolean removeRegistration(String id);

    /*
        Subject for removal

        Further discussion required
     */
    default boolean updateRegistration(Agreement agreement) {
        return false;
    }

    Agreement  getRegistration(String id);
    List<Agreement > getAllRegistrations();
    List<Agreement > getAllActiveRegistrations();
}
