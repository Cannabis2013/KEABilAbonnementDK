package com.example.keabilabonnement.repository.mysql.inspection;

import com.example.keabilabonnement.contracts.inspection.InspectionUpdater;
import com.example.keabilabonnement.models.inspection.Damage;
import com.example.keabilabonnement.models.inspection.Report;
import org.springframework.stereotype.Service;

@Service
public class MySQLInspectionUpdater implements InspectionUpdater {

    /*

        Author: M. Kaan Arici

    */

    private final MySQLInspectionAdder adder;
    private final DbInspectionRemover remover;


    public MySQLInspectionUpdater(MySQLInspectionAdder adder, DbInspectionRemover remover) {
        this.adder = adder;
        this.remover = remover;
    }

    //A primitive damage update method that first deletes and then adds.
    @Override
    public boolean updateDamage(Damage damage) {
        String id = damage.getId();
        try{
            remover.deleteDamageById(id);
            adder.addDamage(damage);
        } catch (Exception e) {
            System.out.println("Damage Update Fail.");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    //A primitive update method that first deletes and then adds a new report.
    @Override
    public boolean update(Report report) {
        String reportId = report.getId();
        try{
            remover.remove(reportId);
            adder.add(report);
        } catch (Exception e) {
            System.out.println("Report Update Fail.");
            e.printStackTrace();
            return false;
        }
        return true;
    }
}

