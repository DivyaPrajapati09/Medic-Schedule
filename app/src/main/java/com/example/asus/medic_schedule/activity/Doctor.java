package com.example.asus.medic_schedule.activity;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;

import com.example.asus.medic_schedule.R;

public class Doctor extends ActionBarActivity {

    EditText d_name, txt_mail, txt_phn;
    String name, phn, mail;
    SQLiteDatabase db = null;

    private final String DB_NAME = "MEDICDB";
    private final String TABLE_NAME = "Doc_DB";

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.doctor);

        txt_mail = (EditText) findViewById(R.id.txt_mail);
        d_name = (EditText) findViewById(R.id.d_name);
        txt_phn = (EditText) findViewById(R.id.txt_phn);

        try {
            db = this.openOrCreateDatabase(DB_NAME, MODE_PRIVATE, null);
            db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (d_id INTEGER PRIMARY KEY AUTOINCREMENT,d_name VARCHAR,d_mail VARCHAR,d_phn INTEGER);");
        } catch (SQLiteException se) {
            se.printStackTrace();

        }

    }


    public void onSaveDoctorButtonClicked(View view) {
        name = d_name.getText().toString();
        mail = txt_mail.getText().toString();
        phn = txt_phn.getText().toString();
        try {
            db.execSQL("INSERT INTO " + TABLE_NAME + " (d_name,d_mail,d_phn) VALUES ('" + name + "','" + mail + "','" + phn + "');");
        } catch (SQLiteException se) {
            se.printStackTrace();
        }
    }
}

