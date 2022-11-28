package com.example.keabilabonnement.repository.registration.fetch;

import com.example.keabilabonnement.models.registration.RentalAgreement;

import java.util.List;

public interface DbRegistrationFetcher {
    RentalAgreement getRegistration(String id);
    List<RentalAgreement> GetAllRegistrations();
    List<RentalAgreement> GetAllActiveRegistrations();
}
