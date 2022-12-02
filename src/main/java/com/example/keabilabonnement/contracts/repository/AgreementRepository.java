package com.example.keabilabonnement.contracts.repository;

import com.example.keabilabonnement.contracts.models.Agreement;

import java.util.List;

public interface AgreementRepository {
    void addRegistration(Agreement agreement);
    void removeRegistration(String id);
    Agreement getAgreement(String id);
    List<Agreement > getAllRegistrations();
    List<Agreement > getActiveAgreements();
}
