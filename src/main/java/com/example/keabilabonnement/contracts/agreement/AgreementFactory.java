package com.example.keabilabonnement.contracts.agreement;

import com.example.keabilabonnement.models.registration.RentalAgreement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface AgreementFactory {
    RentalAgreement empty();

    RentalAgreement agreementFromResultSet(ResultSet set) throws SQLException;
    RentalAgreement fromResultSet(ResultSet set) throws SQLException;
    List<Agreement> agreementsFromResultSet(ResultSet set) throws SQLException;
}
