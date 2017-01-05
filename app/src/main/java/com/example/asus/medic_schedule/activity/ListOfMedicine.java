package com.example.asus.medic_schedule.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

import com.example.asus.medic_schedule.R;

public class ListOfMedicine extends ActionBarActivity {
    FloatingActionButton add;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.datalist_m);

        add = (FloatingActionButton) findViewById(R.id.add_medicine);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent c = new Intent(getBaseContext(), AddMedicineActivity.class);
                startActivity(c);
            }
        });
    }
}
