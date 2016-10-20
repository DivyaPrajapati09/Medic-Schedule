package com.example.asus.medic_schedule.activity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.asus.medic_schedule.R;

import java.util.Date;

import static android.content.Context.MODE_PRIVATE;

public class BloodPressure extends Fragment {

    EditText systol, dystol, pulse;
    Integer sys, dys, pul, tim;
    SQLiteDatabase db = null;

    private final String DB_NAME = "MEDICDB";
    private final String TABLE_NAME = "BldP_DB";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.bloodpressure, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        systol = (EditText)getView().findViewById(R.id.systol);
        dystol = (EditText)getView().findViewById(R.id.dystol);
        pulse = (EditText)getView().findViewById(R.id.pulse);

        try {
            db = getActivity().openOrCreateDatabase(DB_NAME, MODE_PRIVATE, null);
            db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " ( systol INTEGER  ,dystol INTEGER, pulse INTEGER,date Date();");
        } catch (SQLiteException se) {
            se.printStackTrace();
        }
    }

    private void datetime() {
        Date date = new Date();
        int year = date.getYear();
        int month = date.getMonth();
        int day = date.getDay();
        int hours = date.getHours();
        int min = date.getMinutes();
    }

    public void onSaveBloodPressureButtonClicked(View view) {
        sys = Integer.parseInt(systol.getText().toString());
        dys = Integer.parseInt(dystol.getText().toString());
        pul = Integer.parseInt(pulse.getText().toString());

        try {
            db.execSQL("INSERT INTO " + TABLE_NAME + " (systol,dystol,pulse,time) Values (" + sys + "," + dys + " ," + pul + " );");
        } catch (SQLiteException se) {
            se.printStackTrace();
        }
    }

    public void onViewBloodPressureListClicked(View view) {
        Intent in = new Intent(getContext(), DataList_bp.class);
        startActivity(in);
    }
}
