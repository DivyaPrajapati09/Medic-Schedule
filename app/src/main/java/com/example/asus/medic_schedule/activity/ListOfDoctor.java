package com.example.asus.medic_schedule.activity;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.util.Log;
import android.view.View;
import android.widget.SimpleAdapter;

import com.example.asus.medic_schedule.R;

import java.util.ArrayList;
import java.util.HashMap;

public class ListOfDoctor extends ListActivity {

    static final ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
    private final String DB_NAME = "MEDICDB";
    private final String TABLE_NAME = "Doc_DB";

    SQLiteDatabase db = null;

    FloatingActionButton btn_doc;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.datalist_d);

        btn_doc = (FloatingActionButton) findViewById(R.id.add_doctor);

        try {
            db = this.openOrCreateDatabase(DB_NAME, MODE_PRIVATE, null);
            Cursor c = db.rawQuery("SELECT * FROM " + TABLE_NAME + ";", null);

            if (c != null) {
                if (c.moveToFirst()) {
                    do {
                        HashMap<String, String> map = new HashMap<String, String>();
                        // String doc_id=c.getString(c.getColumnIndex("d_id"));
                        String doc_name = c.getString(c.getColumnIndex("d_name"));
                        String doc_mail = c.getString(c.getColumnIndex("d_mail"));
                        String doc_phn = c.getString(c.getColumnIndex("d_phn"));

                        //map.put("d_id",doc_id);
                        map.put("d_name", doc_name);
                        map.put("d_mail", doc_mail);
                        map.put("d_phn", doc_phn);

                        list.add(map);
                    } while (c.moveToNext());

                }
            }

            Log.e("ListOfDoctor", "Total Records" + c.getCount());
        } catch (SQLiteException se) {
            Log.e("ListOfDoctor", "could not create or open database");

        }

        SimpleAdapter ad = new SimpleAdapter(this, list, R.layout.rowdata_d, new String[]{"d_name", "d_mail", "d_phn"}, new int[]{R.id.d_name, R.id.d_mail, R.id.d_phn});
        setListAdapter(ad);

        btn_doc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getBaseContext(), AddDoctorActivity.class);
                startActivity(in);
            }
        });
    }


}