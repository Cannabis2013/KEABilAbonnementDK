package com.example.keabilabonnement.repository.mysql.registration;

import com.example.keabilabonnement.contracts.db.DbStatement;
import com.example.keabilabonnement.models.registration.RentalAgreement;
import org.springframework.stereotype.Service;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.UUID;

@Service
public class MySQLRegistrationAdder {
    public MySQLRegistrationAdder(DbStatement statementBuilder) {
        this.statementBuilder = statementBuilder;
    }

    public Boolean add(RentalAgreement agreement) {
        agreement.setId(UUID.randomUUID().toString());
        var prepared = statementBuilder.get(statement());
        try {
            initValues(prepared,agreement);
            prepared.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    private String statement(){
        return """
                    insert into RentalAgreement (StartDate, ExpirationDate, DeliveryDate, Id, CarNumber, CustomerLicense_Id)
                    values (?,?,?,?,?,?);
                """;
    }

    private PreparedStatement initValues(PreparedStatement statement, RentalAgreement agreement) throws SQLException {
        statement.setDate(0,toDate(agreement.getStart()));
        statement.setDate(1,toDate(agreement.getExpiration()));
        statement.setDate(2,toDate(agreement.getDelevery()));
        statement.setString(3,agreement.getId());
        statement.setString(4,agreement.getCar().getCarNumber());
        statement.setString(5,agreement.getCustomer().getLicenseID());
        return statement;
    }

    private Date toDate(LocalDate date){
        return Date.valueOf(date);
    }

    private final DbStatement statementBuilder;
}
