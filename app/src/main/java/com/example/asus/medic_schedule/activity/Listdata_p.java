package com.example.asus.medic_schedule.activity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.asus.medic_schedule.R;

import java.util.ArrayList;

public class Listdata_p extends ActionBarActivity {

    ListView list_p;
    FloatingActionButton btn_pat;

    private final String DB_NAME = "MEDICDB";
    private final String TABLE_NAME = "Patient_DB";

    ArrayList<String> results = new ArrayList<String>();

    SQLiteDatabase db = null;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listdata_p);
        list_p = (ListView) findViewById(R.id.list_p);
        btn_pat = (FloatingActionButton) findViewById(R.id.add_p);
        try {

            db = this.openOrCreateDatabase(DB_NAME, MODE_PRIVATE, null);
            Cursor c = db.rawQuery("SELECT * FROM " + TABLE_NAME + ";", null);

            if (c != null)

            {
                if (c.moveToFirst()) {
                    do {

                        String pat_name = c.getString(c.getColumnIndex("p_name"));

                        results.add(pat_name);

                    } while (c.moveToNext());
                }
            }

            Log.e("Medic_Schedule1", "could not create or open database");
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, results);
            list_p.setAdapter(adapter);

        } catch (SQLiteException se) {
            Log.e("Medic_Schedule", "could not open or create database");

        }


        btn_pat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getBaseContext(), Patient.class);
                startActivity(in);
            }
        });
    }
}
