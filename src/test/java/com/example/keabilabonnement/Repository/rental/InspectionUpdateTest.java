package com.example.keabilabonnement.Repository.rental;

import com.example.keabilabonnement.models.inspection.Damage;
import com.example.keabilabonnement.models.inspection.Report;
import com.example.keabilabonnement.repository.mysql.inspection.MySQLInspectionUpdater;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class InspectionUpdateTest {


    @Autowired
    private MySQLInspectionUpdater mySQLInspectionUpdater;

    //arrange
    private Report report(){
        var report = new Report();
        report.setId("acce7faa-a9f5-42e2-a33f-63410bcf2cee");
        return report;
    }

    private Damage damage(){
        var damage = new Damage();
        damage().setId("1d258cbc-00be-494a-9035-272bfff1513c");
        return damage;
    }

    @Test
    void updateReportTest() {
        //act
            var rental = report();
            boolean result = mySQLInspectionUpdater.update(rental);

        //assert
            assertTrue(result, "Update Successful.");
    }

    @Test
    void updateDamageTest() {
        //act
        var damage = damage();
        boolean result = mySQLInspectionUpdater.updateDamage(damage);

        //assert
        assertTrue(result, "Update Successful.");
    }


}

