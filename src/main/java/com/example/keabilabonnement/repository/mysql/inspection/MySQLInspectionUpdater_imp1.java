package com.example.keabilabonnement.repository.mysql.inspection;

import com.example.keabilabonnement.contracts.repository.InspectionUpdater;
import com.example.keabilabonnement.models.inspection.Report;
import org.springframework.stereotype.Service;

@Service
public class MySQLInspectionUpdater_imp1 implements InspectionUpdater {
    public boolean update(Report report) {
        return false;
    }


}
