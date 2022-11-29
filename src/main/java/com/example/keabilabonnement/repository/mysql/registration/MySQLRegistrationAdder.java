package com.example.keabilabonnement.repository.mysql.registration;

import com.example.keabilabonnement.models.Db.MySQLStatement;
import com.example.keabilabonnement.models.registration.RentalAgreement;
import com.example.keabilabonnement.services.db.DBConnection;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

@Service
public class MySQLRegistrationAdder {
    public MySQLRegistrationAdder() {
    }

    public Boolean add(RentalAgreement agreement) {
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
                                            Id, CarNumber, 
                                            CustomerLicense_Id)
                values (?,?,?,?,?,?);
                """;
    }

    private MySQLStatement initValues(MySQLStatement statement, RentalAgreement agreement) throws SQLException {
        return statement.setDate(1,agreement.getStart())
                .setDate(2,agreement.getExpiration())
                .setDate(3,agreement.getDelevery())
                .setString(4,agreement.getId())
                .setString(5,agreement.getCar().getCarNumber())
                .setString(6,agreement.getCustomer().getLicenseID());
    }

    private Date toDate(LocalDate date){
        return Date.valueOf(date);
    }
}
