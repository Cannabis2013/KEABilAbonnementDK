package com.example.keabilabonnement.contracts.agreement;

import java.util.List;

public interface AgreementRepository {

    /*

        Authors: Nikki Deleuran - M. Kaan Arici - Stefan Jensen - Martin Hansen

    */

    void addRegistration(Agreement agreement);
    void removeRegistration(String id);
    Agreement getAgreement(String id);
    List<Agreement > getAllRegistrations();
    List<Agreement > getActiveAgreements();
}
