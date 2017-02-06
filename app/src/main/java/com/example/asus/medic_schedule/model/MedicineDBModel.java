package com.example.asus.medic_schedule.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

@Entity
public class MedicineDBModel {
    @Id
    private int id;
    private String medicineName;
    private String timeToTakeMedicine;
    private boolean isTaken;
    private long quantity;
    private String expiryDate;
    @Generated(hash = 941414222)
    public MedicineDBModel(int id, String medicineName, String timeToTakeMedicine,
            boolean isTaken, long quantity, String expiryDate) {
        this.id = id;
        this.medicineName = medicineName;
        this.timeToTakeMedicine = timeToTakeMedicine;
        this.isTaken = isTaken;
        this.quantity = quantity;
        this.expiryDate = expiryDate;
    }
    @Generated(hash = 971482414)
    public MedicineDBModel() {
    }
    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getMedicineName() {
        return this.medicineName;
    }
    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }
    public String getTimeToTakeMedicine() {
        return this.timeToTakeMedicine;
    }
    public void setTimeToTakeMedicine(String timeToTakeMedicine) {
        this.timeToTakeMedicine = timeToTakeMedicine;
    }
    public boolean getIsTaken() {
        return this.isTaken;
    }
    public void setIsTaken(boolean isTaken) {
        this.isTaken = isTaken;
    }
    public long getQuantity() {
        return this.quantity;
    }
    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }
    public String getExpiryDate() {
        return this.expiryDate;
    }
    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    }
