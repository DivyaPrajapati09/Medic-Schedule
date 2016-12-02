package com.example.asus.medic_schedule.activity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.asus.medic_schedule.R;
import com.example.asus.medic_schedule.adapter.CustomListViewAdapter;
import com.example.asus.medic_schedule.fragment.AddBloodPressureFragment;
import com.example.asus.medic_schedule.model.RowItem_bp;

import java.util.ArrayList;
import java.util.List;

public class Listdata_bp extends ActionBarActivity implements AdapterView.OnItemClickListener {

    private static final String DB_NAME = "MEDICDB";
    private static final String TABLE_NAME = "BP_DB";

    private ArrayList<String> results = new ArrayList<String>();
    private ListView listView;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listdata_bp);
        FloatingActionButton btn_add = (FloatingActionButton) findViewById(R.id.add_bp);
        try {
            SQLiteDatabase db = this.openOrCreateDatabase(DB_NAME, MODE_PRIVATE, null);
            Cursor c = db.rawQuery("SELECT * FROM " + TABLE_NAME + ";", null);
            if (c != null) {
                if (c.moveToFirst()) {
                    do {
                        String sys = c.getString(c.getColumnIndex("systol"));
                        String dys = c.getString(c.getColumnIndex("dystol"));
                        String pul = c.getString(c.getColumnIndex("pulse"));

                        listView = (ListView) findViewById(R.id.list);
                        List<RowItem_bp> rowItems = new ArrayList<>();
                        for (int i = 1; i <= sys.length(); i++) {
                            RowItem_bp item = new RowItem_bp(sys, dys, pul);
                            rowItems.add(item);
                        }
                        CustomListViewAdapter adapter = new CustomListViewAdapter(this,
                                R.layout.listdata_bp, rowItems);
                        listView.setAdapter(adapter);
                        listView.setOnItemClickListener(this);

                    } while (c.moveToNext());
                }
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, android.R.id.text1, results);
            listView.setAdapter(adapter);

        } catch (SQLiteException se) {
            se.printStackTrace();
        }
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getBaseContext(), AddBloodPressureFragment.class);
                startActivity(in);
            }
        });

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
                            long id) {
    }
}





