package com.example.asus.medic_schedule.activity;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.asus.medic_schedule.CustomListViewAdapter;
import com.example.asus.medic_schedule.R;
import com.example.asus.medic_schedule.RowItem_bp;

import java.util.ArrayList;
import java.util.List;

public class Listdata_bp extends ActionBarActivity implements AdapterView.OnItemClickListener {

    ListView list;
    Button btn_add;

    private final String DB_NAME = "MEDICDB";
    private final String TABLE_NAME = "BP_DB";

    ArrayList<String> results = new ArrayList<String>();

    SQLiteDatabase db = null;


    // public static final Integer[] images = {R.drawable.heart1};
    // public static final Integer[] sys={};
    //public static final Integer[] dys={};
    //public static final Integer[] pul={};
    // public static final Integer[] time={};

    ListView listView;
    List<RowItem_bp> rowItems;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listdata_bp);
        list = (ListView) findViewById(R.id.list);
        btn_add = (Button) findViewById(R.id.btn_add);

        try {

            db = this.openOrCreateDatabase(DB_NAME, MODE_PRIVATE, null);
            Cursor c = db.rawQuery("SELECT * FROM " + TABLE_NAME + ";", null);

            if (c != null) {
                if (c.moveToFirst()) {
                    do {

                        String sys = c.getString(c.getColumnIndex("systol"));
                        String dys = c.getString(c.getColumnIndex("dystol"));
                        String pul = c.getString(c.getColumnIndex("pulse"));

                        listView = (ListView) findViewById(R.id.list);
                        rowItems = new ArrayList<RowItem_bp>();
                        for (int i = 1; i <= sys.length(); i++) {
                            RowItem_bp item = new RowItem_bp(sys, dys, pul);
                            rowItems.add(item);
                        }


                        CustomListViewAdapter adapter = new CustomListViewAdapter(this,
                                R.layout.listdata_bp, rowItems);
                        list.setAdapter(adapter);
                        list.setOnItemClickListener(this);

                    } while (c.moveToNext());
                }
            }
            Log.e("Blood Pressure", "could not create or open database");
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, results);
            list.setAdapter(adapter);

        } catch (SQLiteException se) {
            Log.e("Blood Pressure", "could not open or create database");

        }
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getBaseContext(), BloodPressure.class);
                startActivity(in);
            }
        });

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
                            long id) {
    }
}





