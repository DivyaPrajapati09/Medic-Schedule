package com.example.asus.medic_schedule.activity;

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

import com.example.asus.medic_schedule.R;

import java.util.ArrayList;

public class Listdata_d extends ActionBarActivity {

    ListView list_d;
    Button btn_doc;

    private final String DB_NAME = "MEDICDB";
    private final String TABLE_NAME = "Doc_DB";

    ArrayList<String> results = new ArrayList<String>();

    SQLiteDatabase db = null;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listdata_d);
        list_d = (ListView) findViewById(R.id.list_d);
        btn_doc = (Button) findViewById(R.id.btn_doc);
        try {

            db = this.openOrCreateDatabase(DB_NAME, MODE_PRIVATE, null);
            Cursor c = db.rawQuery("SELECT * FROM " + TABLE_NAME + ";", null);

            if (c != null)

            {
                if (c.moveToFirst()) {
                    do {
                        // String doc_id = c.getString(c.getColumnIndex("d_id"));
                        String doc_name = c.getString(c.getColumnIndex("d_name"));
                        String doc_mail = c.getString(c.getColumnIndex("d_mail"));
                        String doc_phn = c.getString(c.getColumnIndex("d_phn"));

                        results.add("" + doc_name + "\n" + doc_mail + "\n" + doc_phn);

                    } while (c.moveToNext());
                }
            }

            Log.e("Medic_Schedule", "could not create or open database");
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, results);
            list_d.setAdapter(adapter);

        } catch (SQLiteException se) {
            Log.e("Medic_Schedule", "could not open or create database");

        }

        btn_doc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getBaseContext(), Doctor.class);
                startActivity(in);
            }
        });
    }
}
