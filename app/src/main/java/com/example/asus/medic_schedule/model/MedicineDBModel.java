package com.example.asus.medic_schedule.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

@Entity
public class MedicineDBModel {
    @Id
    private long id;
    private String medicineName;
    private String timeToTakeMedicine;
    private boolean isTaken;
    private int quantity;
    private String expiryDate;
    private long userId;
    @Generated(hash = 521628469)
    public MedicineDBModel(long id, String medicineName, String timeToTakeMedicine,
            boolean isTaken, int quantity, String expiryDate, long userId) {
        this.id = id;
        this.medicineName = medicineName;
        this.timeToTakeMedicine = timeToTakeMedicine;
        this.isTaken = isTaken;
        this.quantity = quantity;
        this.expiryDate = expiryDate;
        this.userId = userId;
    }
    @Generated(hash = 971482414)
    public MedicineDBModel() {
    }
    public long getId() {
        return this.id;
    }
    public void setId(long id) {
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
    public int getQuantity() {
        return this.quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public String getExpiryDate() {
        return this.expiryDate;
    }
    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }
    public long getUserId() {
        return this.userId;
    }
    public void setUserId(long userId) {
        this.userId = userId;
    }

   
}
