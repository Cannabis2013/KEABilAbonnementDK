package com.example.keabilabonnement.factories;

import com.example.keabilabonnement.contracts.auxiliary.CarFactory;
import com.example.keabilabonnement.contracts.auxiliary.CarDetails;
import com.example.keabilabonnement.models.cars.RentalCar;
import org.springframework.stereotype.Service;
import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class MySQLCarFactory implements CarFactory {
    @Override
    public CarDetails buildFromResultSet(ResultSet set) {
        try {
            return buildFromSQLResult(set);
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

    private CarDetails buildFromSQLResult(ResultSet set) throws SQLException {
        CarDetails details = new RentalCar();
        details.setInternalNumber(set.getString("Number"));
        details.setVin(set.getString("VIN"));
        details.setModel(set.getString("Model"));
        details.setBrand(set.getString("Brand"));
        details.setYear(set.getInt("Year"));
        return details;
    }
}
