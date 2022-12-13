package com.example.keabilabonnement.repository.mysql.agreement;

import com.example.keabilabonnement.contracts.agreement.Agreement;
import com.example.keabilabonnement.services.db.DBConnection;
import org.springframework.stereotype.Service;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

// Implemented by Martin Hansen

@Service
public class AgreementPersistence {
    public AgreementPersistence() {
    }

    public Boolean add(Agreement agreement) {
        try {
            var prepared = DBConnection.statement(statement());
            initValues(prepared,agreement).execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    private String statement(){
        return """
                insert into RentalAgreement (StartDate, 
                                            ExpirationDate, 
                                            DeliveryDate,
                                            Payment,
                                            Id, CarNumber, 
                                            CustomerLicense_Id)
                values (?,?,?,?,?,?,?);
                """;
    }

    private PreparedStatement initValues(PreparedStatement statement, Agreement agreement) throws SQLException {
        statement.setDate(1,toDate(agreement.getStart()));
        statement.setDate(2,toDate(agreement.getExpiration()));
        statement.setDate(3,toDate(agreement.getDelevery()));
        statement.setDouble(4,agreement.getPayment());
        statement.setString(5,agreement.getId());
        statement.setString(6,agreement.getCarNumber());
        statement.setString(7,agreement.getCustomerLicenseID());
        return statement;
    }

    private Date toDate(LocalDate date){
        return Date.valueOf(date);
    }
}
