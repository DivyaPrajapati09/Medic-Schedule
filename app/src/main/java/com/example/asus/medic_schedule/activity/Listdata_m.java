package com.example.asus.medic_schedule.activity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.asus.medic_schedule.R;

import java.util.ArrayList;

public class Listdata_m extends ActionBarActivity {

    private ArrayList<String> results = new ArrayList<String>();

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listdata_m);
        ListView list_m = (ListView) findViewById(R.id.list_m);
        Button btn_med = (Button) findViewById(R.id.btn_med);

        try {

            String DB_NAME = "MEDICDB";
            SQLiteDatabase db = this.openOrCreateDatabase(DB_NAME, MODE_PRIVATE, null);
            String TABLE_NAME = "Medicine_DB";
            Cursor c = db.rawQuery("SELECT * FROM " + TABLE_NAME + ";", null);
            if (c != null) {
                if (c.moveToFirst()) {
                    do {
                        String name = c.getString(c.getColumnIndex("m_name"));
                        String re = c.getString(c.getColumnIndex("reminder"));
                        String reminder_time = c.getString(c.getColumnIndex("reminder_time"));
                        String duration = c.getString(c.getColumnIndex("duration"));
                        String start_date = c.getString(c.getColumnIndex("start_date"));
                        String days = c.getString(c.getColumnIndex("Days"));
                        String mt = c.getString(c.getColumnIndex("medicine_type"));
                        String dosage = c.getString(c.getColumnIndex("Dosage"));
                        String d_id = c.getString(c.getColumnIndex("d_id"));
                        String p_id = c.getString(c.getColumnIndex("p_id"));
                        results.add("" + name + "\n" + re + "\n" + reminder_time + "\n" + duration + "\n" + start_date + "\n" + days + "\n" + mt + "\n" + dosage + "\n" + d_id + "\n" + p_id);
                    } while (c.moveToNext());
                }
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, android.R.id.text1, results);
            list_m.setAdapter(adapter);

        } catch (SQLiteException se) {
            se.printStackTrace();
        }
        btn_med.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getBaseContext(), AddMedicineActivity.class);
                startActivity(in);
            }
        });
    }
}




