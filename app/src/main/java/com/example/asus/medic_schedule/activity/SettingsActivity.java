package com.example.asus.medic_schedule.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.asus.medic_schedule.R;

public class SettingsActivity extends AppCompatActivity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settingsactivity);
    }

    public void onAddPatientButtonClick(View view) {
        Intent a = new Intent(getBaseContext(), Datalist_p.class);
        startActivity(a);
    }

    public void onAddDoctorButtonClick(View view) {
        Intent b = new Intent(getBaseContext(), Datalist_d.class);
        startActivity(b);
    }

    public void onAddMedicineButtonClick(View view) {
        Intent c = new Intent(getBaseContext(), Datalist_m.class);
        startActivity(c);
    }
}
