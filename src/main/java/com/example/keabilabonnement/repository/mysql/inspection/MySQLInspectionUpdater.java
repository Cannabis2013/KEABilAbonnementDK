package com.example.keabilabonnement.repository.mysql.inspection;

import com.example.keabilabonnement.contracts.inspection.InspectionUpdater;
import com.example.keabilabonnement.models.inspection.Report;
import org.springframework.stereotype.Service;

@Service
public class MySQLInspectionUpdater implements InspectionUpdater {

    /*

        Author: M. Kaan Arici

    */

    private final MySQLInspectionAdder damageAdder;
    private final DbInspectionRemover damageRemover;

    public MySQLInspectionUpdater(MySQLInspectionAdder adder, DbInspectionRemover remover) {
        this.damageAdder = adder;
        this.damageRemover = remover;
    }

    //A primitive update method that first deletes the damage to make new one.
    public boolean update(Report report) {
        return damageRemover.remove(report.getId()) && damageAdder.add(report);
    }

}
