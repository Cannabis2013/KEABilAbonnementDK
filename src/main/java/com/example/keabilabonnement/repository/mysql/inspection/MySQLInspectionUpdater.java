package com.example.keabilabonnement.repository.mysql.inspection;

import com.example.keabilabonnement.models.inspection.Report;
import com.example.keabilabonnement.services.DBConnection;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.SQLException;

@Service
public class MySQLInspectionUpdater {
    public boolean update(Report report) {
        return false;
    }


}
