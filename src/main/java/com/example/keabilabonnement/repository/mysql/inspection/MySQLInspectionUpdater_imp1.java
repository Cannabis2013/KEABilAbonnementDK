package com.example.keabilabonnement.repository.mysql.inspection;

import com.example.keabilabonnement.contracts.inspection.InspectionUpdater;
import com.example.keabilabonnement.models.inspection.Report;
import org.springframework.stereotype.Service;

@Service
public class MySQLInspectionUpdater_imp1 implements InspectionUpdater {

    /*

        Author: M. Kaan Arici

    */

    private final MySQLInspectionAdder adder;
    private final DbInspectionRemover remover;

    public MySQLInspectionUpdater_imp1(MySQLInspectionAdder adder, DbInspectionRemover remover) {
        this.adder = adder;
        this.remover = remover;
    }

    public boolean update(Report report) {
        //Report parameter is still here but report in DB is empty.
        return remover.remove(report.getId()) && adder.add(report);
    }

}
