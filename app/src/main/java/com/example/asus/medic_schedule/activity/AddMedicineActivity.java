package com.example.asus.medic_schedule.activity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.asus.medic_schedule.R;

import java.util.ArrayList;

public class AddMedicineActivity extends ActionBarActivity {

    private EditText m_name, reminder_time, duration, start_date, days, dosage;
    private Spinner reminder, medicine_type, d_name, p_name;
    private String name, rem_time, dur, st, d, dos, re, mt, doc_nam, pat_nam;

    private SQLiteDatabase db = null;

    private static final String DB_NAME = "MEDICDB";
    private final String TABLE_NAME = "Medicine_DB";

    private ArrayList<String> d_results = new ArrayList<String>();
    private ArrayList<String> p_results = new ArrayList<String>();

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.medicine);

        m_name = (EditText) findViewById(R.id.m_name);
        reminder = (Spinner) findViewById(R.id.reminder);
        reminder_time = (EditText) findViewById(R.id.reminder_time);
        duration = (EditText) findViewById(R.id.duration);
        start_date = (EditText) findViewById(R.id.start_date);
        days = (EditText) findViewById(R.id.days);
        dosage = (EditText) findViewById(R.id.dosage);

        medicine_type = (Spinner) findViewById(R.id.medicine_type);
        d_name = (Spinner) findViewById(R.id.d_name);
        p_name = (Spinner) findViewById(R.id.p_name);

        try {
            db = this.openOrCreateDatabase(DB_NAME, MODE_PRIVATE, null);
            db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (m_id INTEGER PRIMARY KEY AUTOINCREMENT ,m_name VARCHAR,reminder INTEGER,reminder_time VARCHAR,duration VARCHAR,start_date INTEGER,Days INTEGER,medicine_type VARCHAR,Dosage INTEGER,d_name VARCHAR,p_name VARCHAR);");
        } catch (SQLiteException se) {
            se.printStackTrace();
        }
        loadSpinnerDataDoctor();
        loadSpinnerDataPatient();


        reminder.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long l) {
                re = parent.getItemAtPosition(pos).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        medicine_type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long l) {
                mt = parent.getItemAtPosition(pos).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        d_name.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long l) {
                doc_nam = String.valueOf(parent);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        p_name.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long l) {
                pat_nam = String.valueOf(parent);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }


    private void loadSpinnerDataPatient() {
        try {
            Cursor d = db.rawQuery("SELECT p_name FROM Patient_DB", null);
            if (d != null) {
                if (d.moveToFirst()) {
                    do {
                        String pa_name = d.getString(d.getColumnIndex("p_name"));
                        p_results.add(pa_name);
                    } while (d.moveToNext());
                }
            }
            ArrayAdapter<String> aa = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, p_results);
            p_name.setAdapter(aa);
        } catch (SQLiteException se) {
            se.printStackTrace();
        }
    }

    private void loadSpinnerDataDoctor() {
        try {
            Cursor e = db.rawQuery("SELECT d_name FROM Doc_DB", null);
            if (e != null) {
                if (e.moveToFirst()) {
                    do {
                        String do_name = e.getString(e.getColumnIndex("d_name"));
                        d_results.add(do_name);
                    } while (e.moveToNext());
                }
            }
            ArrayAdapter<String> bb = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, d_results);
            d_name.setAdapter(bb);
        } catch (SQLiteException se) {
            se.printStackTrace();
        }
    }

    public void onSaveMedicineButtonClick(View view) {
        name = m_name.getText().toString();
        rem_time = reminder_time.getText().toString();
        dur = duration.getText().toString();
        st = start_date.getText().toString();
        d = days.getText().toString();
        dos = dosage.getText().toString();
        try {
            db.execSQL("INSERT INTO " + TABLE_NAME + "(m_name,reminder,reminder_time,duration,start_date,Days,medicine_type,Dosage,d_name,p_name) VALUES ('" + name + "','" + re + "','" + rem_time + "','" + dur + "','" + st + "','" + d + "','" + mt + "','" + dos + "','" + d_name + "','" + p_name + "');");
        } catch (SQLiteException se) {
            se.printStackTrace();
        }
    }

}





