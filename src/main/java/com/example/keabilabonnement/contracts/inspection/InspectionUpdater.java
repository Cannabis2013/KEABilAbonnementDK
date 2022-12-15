package com.example.keabilabonnement.contracts.inspection;

import com.example.keabilabonnement.models.inspection.Damage;
import com.example.keabilabonnement.models.inspection.Report;

public interface InspectionUpdater {

    /*

        Authors: Nikki Deleuran - M. Kaan Arici - Stefan Jensen - Martin Hansen

    */

    boolean update(Report report);
    boolean updateDamage (Damage damage);

}
