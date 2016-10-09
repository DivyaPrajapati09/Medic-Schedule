package com.example.asus.medic_schedule.activity;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.asus.medic_schedule.Medicine;
import com.example.asus.medic_schedule.R;

import java.util.ArrayList;

public class Listdata_m extends ActionBarActivity {

    ListView list_m;
    Button btn_med;
    private final String DB_NAME = "MEDICDB";
    private final String TABLE_NAME = "Medicine_DB";

    ArrayList<String> results = new ArrayList<String>();

    SQLiteDatabase db = null;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listdata_m);
        list_m = (ListView) findViewById(R.id.list_m);
        btn_med = (Button) findViewById(R.id.btn_med);

        try {

            db = this.openOrCreateDatabase(DB_NAME, MODE_PRIVATE, null);
            Cursor c = db.rawQuery("SELECT * FROM " + TABLE_NAME + ";", null);

            if (c != null)

            {
                if (c.moveToFirst()) {
                    do {
                        // String id = c.getString(c.getColumnIndex("m_id"));
                        String name = c.getString(c.getColumnIndex("m_name"));
                        String re = c.getString(c.getColumnIndex("reminder"));
                        String reminder_time = c.getString(c.getColumnIndex("reminder_time"));
                        String duration = c.getString(c.getColumnIndex("duration"));
                        String start_date = c.getString(c.getColumnIndex("start_date"));
                        String days = c.getString(c.getColumnIndex("Days"));
                        String mt = c.getString(c.getColumnIndex("medicine_type"));
                        String dosage = c.getString(c.getColumnIndex("Dosage"));
                        // String remark= c.getString(c.getColumnIndex("remark"));
                        String d_id = c.getString(c.getColumnIndex("d_id"));
                        String p_id = c.getString(c.getColumnIndex("p_id"));

                        results.add("" + name + "\n" + re + "\n" + reminder_time + "\n" + duration + "\n" + start_date + "\n" + days + "\n" + mt + "\n" + dosage + "\n" + d_id + "\n" + p_id);

                    } while (c.moveToNext());
                }
            }

            Log.e("Listdata_m", "Database created");
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, results);
            list_m.setAdapter(adapter);

        } catch (SQLiteException se) {
            Log.e("Listdata_m", "could not open or create database: " + se);

        }
        btn_med.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getBaseContext(), Medicine.class);
                startActivity(in);
            }
        });
    }
}




