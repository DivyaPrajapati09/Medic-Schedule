package com.example.asus.medic_schedule.activity;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.asus.medic_schedule.R;

public class Patient extends ActionBarActivity {

    EditText p_name;

    String name;

    SQLiteDatabase db = null;

    private final String DB_NAME = "MEDICDB";
    private final String TABLE_NAME = "Patient_DB";

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.patient);

        p_name = (EditText) findViewById(R.id.p_name);

        try {
            db = this.openOrCreateDatabase(DB_NAME, MODE_PRIVATE, null);
            db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (p_id INTEGER PRIMARY KEY AUTOINCREMENT,p_name VARCHAR);");

        } catch (SQLiteException se) {
            Log.e("Patient", "Could not create or Open the database: " + se);

        }

    }


    public void onSavePatientButtonClick(View view) {
        name = p_name.getText().toString();
        try {
            db.execSQL("INSERT INTO " + TABLE_NAME + " (p_name) Values ('" + name + "');");
            Log.e("Patient", "p_name:" + p_name);

        } catch (SQLiteException se) {
            Log.e("Patient", "Error in insert query: " + se);


        }

    }
}

