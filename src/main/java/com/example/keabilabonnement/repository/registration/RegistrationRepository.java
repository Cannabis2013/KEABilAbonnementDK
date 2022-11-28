package com.example.keabilabonnement.repository.registration;

import com.example.keabilabonnement.models.registration.RentalAgreement;

import java.util.List;

public interface RegistrationRepository {
    boolean addRegistration(RentalAgreement agreement);
    boolean removeRegistration(String id);

    /*
        Subject for removal

        Further discussion required
     */
    default boolean updateRegistration(RentalAgreement agreement) {
        return false;
    }

    RentalAgreement getRegistration(String id);
    List<RentalAgreement> getAllRegistrations();
    List<RentalAgreement> getAllActiveRegistrations();
}
