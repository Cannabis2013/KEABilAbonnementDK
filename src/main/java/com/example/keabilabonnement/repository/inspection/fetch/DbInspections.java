package com.example.keabilabonnement.repository.inspection.fetch;

import com.example.keabilabonnement.models.registration.RentalAgreement;

import java.util.List;

public interface DbInspections {
    RentalAgreement getRegistration(String id);
    List<RentalAgreement> GetAllRegistrations();
    List<RentalAgreement> GetAllActiveRegistrations();
}
