package com.example.keabilabonnement.contracts.agreement;

import java.util.List;

public interface AgreementRepository {
    void addRegistration(Agreement agreement);
    void removeRegistration(String id);
    Agreement getAgreement(String id);
    List<Agreement > getAllRegistrations();
    List<Agreement > getActiveAgreements();
}
