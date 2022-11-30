package com.example.keabilabonnement.models.inspection;

import java.sql.Date;

public class Report {

    private int id;
    private Date date;

    public Report(int id, Date date) {
        this.id = id;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
