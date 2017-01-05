package com.example.asus.medic_schedule.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.asus.medic_schedule.R;

public class SettingsActivity extends Fragment implements View.OnClickListener {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.settingsactivity, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Button addPatientButton = (Button) getView().findViewById(R.id.btn_patn);
        Button addDoctorButton = (Button) getView().findViewById(R.id.btn_doc);
        Button addMedicineButton = (Button) getView().findViewById(R.id.btn_med);

        addDoctorButton.setOnClickListener(this);
        addPatientButton.setOnClickListener(this);
        addMedicineButton.setOnClickListener(this);

    }

//    public void onAddPatientButtonClick(View view) {
//        Intent a = new Intent(getBaseContext(), ListOfPatients.class);
//        startActivity(a);
//    }
//
//    public void onAddDoctorButtonClick(View view) {
//        Intent b = new Intent(getBaseContext(), ListOfDoctor.class);
//        startActivity(b);
//    }
//
//    public void onAddMedicineButtonClick(View view) {
//        Intent c = new Intent(getBaseContext(), ListOfMedicine.class);
//        startActivity(c);
//    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_doc:

                break;
            case R.id.btn_patn:
                break;
            case R.id.btn_med:
                break;
        }
    }
}
