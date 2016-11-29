package com.example.asus.medic_schedule.core;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.example.asus.medic_schedule.dal.DaoMaster;
import com.example.asus.medic_schedule.dal.DaoSession;


public class MedicScheduleApp extends Application {

    private DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();

        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this,"notes-db-encrypted",null);
        SQLiteDatabase db = helper.getWritableDatabase();
        daoSession = new DaoMaster(db).newSession();
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }
}
