package com.example.asus.medic_schedule.core;

import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.asus.medic_schedule.model.DaoMaster;
import com.example.asus.medic_schedule.model.DaoSession;

import org.greenrobot.greendao.database.Database;


public class MedicScheduleApp extends Application {

    public static DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();

        DatabaseOpenHelper helper = new DatabaseOpenHelper(this, "medic-schedule-db");
        SQLiteDatabase db = helper.getWritableDatabase();
        daoSession = new DaoMaster(db).newSession();
    }

    private class DatabaseOpenHelper extends DaoMaster.OpenHelper {

        public DatabaseOpenHelper(Context context, String name) {
            super(context, name);
        }

        @Override
        public void onUpgrade(Database db, int oldVersion, int newVersion) {
            DaoMaster.dropAllTables(db, true);
            onCreate(db);
        }
    }


    public DaoSession getDaoSession() {
        return daoSession;
    }
}
