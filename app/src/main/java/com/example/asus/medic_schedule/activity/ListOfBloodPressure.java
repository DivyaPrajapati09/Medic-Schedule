package com.example.asus.medic_schedule.activity;

import android.app.ListActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.Button;
import android.widget.SimpleAdapter;

import com.example.asus.medic_schedule.R;

import java.util.ArrayList;
import java.util.HashMap;

public class ListOfBloodPressure extends ActionBarActivity {

    private static final ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
    private final String DB_NAME = "MEDICDB";
    private final String TABLE_NAME = "BldP_DB";

    private Button add;
    private SQLiteDatabase db = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.datalist_bp);

        add = (Button) findViewById(R.id.add);

        try {
            db = this.openOrCreateDatabase(DB_NAME, MODE_PRIVATE, null);
            Cursor c = db.rawQuery("SELECT * FROM " + TABLE_NAME + ";", null);
            if (c != null) {
                if (c.moveToFirst()) {
                    do {
                        HashMap<String, String> map = new HashMap<String, String>();

                        String sys = c.getString(c.getColumnIndex("systol"));
                        String dys = c.getString(c.getColumnIndex("dystol"));
                        String pul = c.getString(c.getColumnIndex("pulse"));
                        String tim = c.getString(c.getColumnIndex("time"));

                        map.put("sys", sys);
                        map.put("dys", dys);
                        map.put("pul", pul);
                        map.put("time", tim);

                        list.add(map);
                    } while (c.moveToNext());
                    SimpleAdapter ada = new SimpleAdapter(this, list, R.layout.rowdata_bp, new String[]{"sys", "dys", "pul", "tim"}, new int[]{R.id.Sys, R.id.Dys, R.id.Pul, R.id.Time});
                    //setListAdapter(ada);

                }
            }
        } catch (SQLiteException se) {
            se.printStackTrace();
        }


        //SimpleAdapter adapter = new SimpleAdapter(this, list, R.layout.rowdata_bp, new String[]{"sys", "dys", "pul","time"}, new int[]{R.id.Sys, R.id.Dys, R.id.Pul,R.id.Time});
        //setListAdapter(adapter);

//        add.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent x = new Intent(getBaseContext(), AddBloodPressureFragment.class);
//                startActivity(x);
//            }
//        });


    }


}



