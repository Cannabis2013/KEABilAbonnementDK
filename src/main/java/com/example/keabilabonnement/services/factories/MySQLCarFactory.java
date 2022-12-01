package com.example.keabilabonnement.services.factories;

import com.example.keabilabonnement.contracts.factories.CarFactory;
import com.example.keabilabonnement.contracts.models.CarDetails;
import com.example.keabilabonnement.models.cars.RentalCar;
import org.springframework.stereotype.Service;
import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class MySQLCarFactory implements CarFactory {
    @Override
    public CarDetails buildFromResultSet(ResultSet set) {
        try {
            return buldFromSQLResult(set);
        } catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public CarDetails fillDetailsFromResultSet(CarDetails details,ResultSet set) {
        try {
            return fillFromSQLResult(details,set);
        }
        catch (SQLException e){
            return null;
        }
    }

    private CarDetails fillFromSQLResult(CarDetails details, ResultSet set) throws SQLException {
        details.setInternalNumber(set.getString("Number"));
        details.setVin(set.getString("VIN"));
        details.setModel(set.getString("Model"));
        details.setBrand(set.getString("Brand"));
        details.setYear(set.getInt("Year"));
        return details;
    }

    private CarDetails buldFromSQLResult(ResultSet set) throws SQLException {
        CarDetails details = new RentalCar();
        details.setInternalNumber(set.getString("Number"));
        details.setVin(set.getString("VIN"));
        details.setModel(set.getString("Model"));
        details.setBrand(set.getString("Brand"));
        details.setYear(set.getInt("Year"));
        return details;
    }
}
