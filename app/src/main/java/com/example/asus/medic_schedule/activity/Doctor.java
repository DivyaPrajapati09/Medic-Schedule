package com.example.asus.medic_schedule.activity;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.asus.medic_schedule.R;

public class Doctor extends ActionBarActivity {

    EditText d_name, txt_mail, txt_phn;
    Button b11;

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
        b11 = (Button) findViewById(R.id.b11);
        //b22=(Button)findViewById(R.id.b22);

        try {
            db = this.openOrCreateDatabase(DB_NAME, MODE_PRIVATE, null);
            db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (d_id INTEGER PRIMARY KEY AUTOINCREMENT,d_name VARCHAR,d_mail VARCHAR,d_phn INTEGER);");

        } catch (SQLiteException se) {
            Log.e("", "Could not create or Open the database");

        }

        b11.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                // id=d_id.getText().toString();
                name = d_name.getText().toString();

                mail = txt_mail.getText().toString();
                phn = txt_phn.getText().toString();


                try {
                    db.execSQL("INSERT INTO " + TABLE_NAME + " (d_name,d_mail,d_phn) VALUES ('" + name + "','" + mail + "','" + phn + "');");

                } catch (SQLiteException se) {
                    Log.e("Medic_Schedule", "Error in insert query");


                }

            }
        });

      /*  b22.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View view){
                Intent in1 =new Intent(getBaseContext(),Listdata_d.class);
                startActivity(in1);
            }
        });*/
    }


}

