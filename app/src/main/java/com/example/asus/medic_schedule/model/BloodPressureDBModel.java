package com.example.asus.medic_schedule.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Unique;

import java.util.Date;

@Entity
public class BloodPressureDBModel {
    @Id
    @Unique
    private long id;
    private int systol;
    private int dystol;
    private int pulse;
    private Date date;
    @Generated(hash = 695726434)
    public BloodPressureDBModel(long id, int systol, int dystol, int pulse,
            Date date) {
        this.id = id;
        this.systol = systol;
        this.dystol = dystol;
        this.pulse = pulse;
        this.date = date;
    }
    @Generated(hash = 1888584744)
    public BloodPressureDBModel() {
    }
    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public int getSystol() {
        return this.systol;
    }
    public void setSystol(int systol) {
        this.systol = systol;
    }
    public int getDystol() {
        return this.dystol;
    }
    public void setDystol(int dystol) {
        this.dystol = dystol;
    }
    public int getPulse() {
        return this.pulse;
    }
    public void setPulse(int pulse) {
        this.pulse = pulse;
    }
    public Date getDate() {
        return this.date;
    }
    public void setDate(Date date) {
        this.date = date;
    }

}
