package com.example.keabilabonnement.models.inspection;

import java.sql.Time;
import java.time.LocalDate;

public class Report {

    private int id;
    private Time date;

    public Report(int id, Time date) {
        this.id = id;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Time getDate() {
        return date;
    }

    public void setDate(Time date) {
        this.date = date;
    }
}
