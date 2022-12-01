package com.example.keabilabonnement.services.factories;

import com.example.keabilabonnement.contracts.factories.CarFactory;
import com.example.keabilabonnement.models.cars.Car;
import org.springframework.stereotype.Service;
import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class MySQLCarFactory implements CarFactory {
    @Override
    public Car fromResultSet(ResultSet set) {
        try {
            return buildFromSQLResult(set);
        }
        catch (SQLException e){
            return null;
        }
    }

    private Car buildFromSQLResult(ResultSet set) throws SQLException {
        Car car = new Car();
        car.setCarNumber(set.getString("Number"));
        car.setVin(set.getString("VIN"));
        car.setModel(set.getString("Model"));
        car.setBrand(set.getString("Brand"));
        car.setYear(set.getInt("Year"));
        return car;
    }
}
