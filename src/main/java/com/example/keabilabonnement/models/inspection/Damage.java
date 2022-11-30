package com.example.keabilabonnement.models.inspection;

import java.util.Date;

public class Damage {

    private int id;
    private String type;
    private String description;
    private Date date;
    private double cost;
    private int damageReportId;

    public Damage(int id, String type, String description, Date date, double cost, int damageReportId){
        this.id = id;
        this.type = type;
        this.description = description;
        this.date = date;
        this.cost = cost;
        this.damageReportId = damageReportId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getDamageReportId() {
        return damageReportId;
    }

    public void setDamageReportId(int damageReportId) {
        this.damageReportId = damageReportId;
    }


}
