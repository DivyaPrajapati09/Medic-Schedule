package com.example;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Property;
import de.greenrobot.daogenerator.Schema;

public class dbgenerator {

    public static void main(String[] args) {
        Schema schema = new Schema(1, "com.example.asus.medic_schedule.dal");
        schema.enableKeepSectionsByDefault();

        addTables(schema);

        try {
            new DaoGenerator().generateAll(schema, "./app/src/main/java");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void addTables(final Schema schema) {
        Entity user = addUser(schema);
        Entity repo = addRepo(schema);

        Entity bloodPressure = addBloodPressure(schema);
        Entity bloodSugar = addBloodSugar(schema);
        Entity userDetails = addUserDetails(schema);
        Entity medicineData = addMedicineData(schema);
        Entity doctorDetails = addDoctorDetails(schema);

        Property userId = repo.addLongProperty("userId").notNull().getProperty();
        user.addToMany(repo, userId, "userRepos");
    }

    private static Entity addDoctorDetails(Schema schema) {
        Entity doctorDetails = schema.addEntity("DoctorDetails");
        doctorDetails.addIdProperty().primaryKey().autoincrement();
        doctorDetails.addStringProperty("Name").notNull();
        doctorDetails.addStringProperty("EmailId");
        doctorDetails.addStringProperty("PhoneNumber");
        return doctorDetails;
    }

    private static Entity addMedicineData(Schema schema) {
        Entity medicineData=schema.addEntity("MedicineDetails");
        medicineData.addIdProperty().autoincrement().primaryKey();
        medicineData.addStringProperty("MedicineName");
        medicineData.addIntProperty("Dosage");
        medicineData.addStringProperty("Time");
        medicineData.addBooleanProperty("Repetition");
        medicineData.addStringProperty("Days");
        return medicineData;
    }

    private static Entity addUserDetails(Schema schema) {
        Entity userData=schema.addEntity("UserDetails");
        userData.addIdProperty().autoincrement().primaryKey();
        userData.addStringProperty("UserName");
        userData.addIntProperty("Age");
        userData.addStringProperty("MobileNumber");
        userData.addStringProperty("EmailId");
        userData.addStringProperty("BloodGroup");
        userData.addStringProperty("Allergies");
        return userData;
    }

    private static Entity addBloodSugar(Schema schema) {
        return null;
    }

    private static Entity addBloodPressure(Schema schema){
        Entity bloodPressureData=schema.addEntity("BloodSugarData");
        bloodPressureData.addIdProperty().autoincrement().primaryKey();
        bloodPressureData.addIntProperty("Systol");
        bloodPressureData.addIntProperty("Dystol");
        bloodPressureData.addIntProperty("Pulse");
        return null;
    }

    private static Entity addUser(final Schema schema) {
        Entity user = schema.addEntity("User");
        user.addIdProperty().primaryKey().autoincrement();
        user.addStringProperty("name").notNull();
        user.addShortProperty("age");

        return user;
    }

    private static Entity addRepo(final Schema schema) {
        Entity repo = schema.addEntity("Repo");
        repo.addIdProperty().primaryKey().autoincrement();
        repo.addStringProperty("title").notNull();
        repo.addStringProperty("language");
        repo.addIntProperty("watchers_count");

        return repo;
    }
}
