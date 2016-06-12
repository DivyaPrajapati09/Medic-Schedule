package com.example.asus.medic_schedule;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.format.Time;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.DateFormat;
import java.util.Date;

/**
 * Created by ASUS on 1/31/2015.
 */
public class BloodPressure extends ActionBarActivity{

    EditText systol,dystol,pulse;
    Button btn_ent,btn_view;

    Integer sys,dys,pul,tim;


    SQLiteDatabase db=null;


    private final String DB_NAME="MEDICDB";
    private final String TABLE_NAME="BldP_DB";


    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bloodpressure);


        systol=(EditText)findViewById(R.id.systol);
        dystol=(EditText)findViewById(R.id.dystol);
        pulse=(EditText)findViewById(R.id.pulse);

        btn_ent=(Button)findViewById(R.id.btn_ent);
        btn_view=(Button)findViewById(R.id.btn_view);

        try{
            db=this.openOrCreateDatabase(DB_NAME,MODE_PRIVATE,null);
            db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " ( systol INTEGER  ,dystol INTEGER, pulse INTEGER,date Date();");

        }   catch (SQLiteException se){
            Log.e("database", "Could not create or Open the database");

        }

       btn_ent.setOnClickListener(new View.OnClickListener(){
            @Override

            public void onClick(View view){
               /* sys= systol.getText().toString();
                dys= dystol.getText().toString();
                pul=pulse.getText().toString();*/

                sys=Integer.parseInt(systol.getText().toString());
                dys=Integer.parseInt(dystol.getText().toString());
                pul=Integer.parseInt(pulse.getText().toString());







                try{
                    db.execSQL("INSERT INTO " + TABLE_NAME + " (systol,dystol,pulse,time) Values (" + sys + "," + dys + " ,"+ pul +" );");
                    Log.e("database","systol entered: "+ sys);
                    Log.e("database","dystol entered: "+ dys);
                    Log.e("database","pulse entered: "+ pul);
                   //Log.e("database","time entered:",datetime());
                } catch (SQLiteException se){
                    Log.e("database", "Error in insert query"+se);


                }

            }
        });

       btn_view.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View view){
                Intent in =new Intent(getBaseContext(),DataList_bp.class);
                startActivity(in);
            }
        });
    }

    private void datetime() {
        Date date=new Date();
        int year=date.getYear();
        int month=date.getMonth();
        int day=date.getDay();
        int hours=date.getHours();
        int min=date.getMinutes();
    }
}
