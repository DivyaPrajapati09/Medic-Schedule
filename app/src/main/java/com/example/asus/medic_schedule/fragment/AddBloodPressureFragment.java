package com.example.asus.medic_schedule.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.asus.medic_schedule.R;
import com.example.asus.medic_schedule.core.MedicScheduleApp;
import com.example.asus.medic_schedule.model.BloodPressureDBModel;

import java.util.Date;

public class AddBloodPressureFragment extends Fragment implements View.OnClickListener {

    private EditText systol, dystol, pulse;
    private Button add, view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.bloodpressure, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        systol = (EditText) getView().findViewById(R.id.systol);
        dystol = (EditText) getView().findViewById(R.id.dystol);
        pulse = (EditText) getView().findViewById(R.id.pulse);
        add = (Button) getView().findViewById(R.id.btn_add);
        view = (Button) getView().findViewById(R.id.btn_view);

        add.setOnClickListener(this);
        view.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_add:
                if (TextUtils.isEmpty(systol.getText())) {
                    systol.setError("Please add Systol.");
                }
                if (TextUtils.isEmpty(dystol.getText())) {
                    dystol.setError("Please add dystol.");
                }
                if (TextUtils.isEmpty(pulse.getText())) {
                    pulse.setError("Please add pulse.");
                }
                if (!TextUtils.isEmpty(systol.getText()) &&
                        !TextUtils.isEmpty(dystol.getText()) &&
                        !TextUtils.isEmpty(pulse.getText())) {
                    saveBloodPressure();
                }
                break;
            case R.id.btn_view:
                Intent in = new Intent(getContext(), ListOfBloodPressureFragment.class);
                startActivity(in);
                break;
        }
    }

    private void saveBloodPressure() {
        BloodPressureDBModel bloodPressureDBModel = new BloodPressureDBModel();
        bloodPressureDBModel.setSystol(Integer.parseInt(systol.getText().toString()));
        bloodPressureDBModel.setDystol(Integer.parseInt(dystol.getText().toString()));
        bloodPressureDBModel.setPulse(Integer.parseInt(pulse.getText().toString()));
        bloodPressureDBModel.setDate(new Date());
        MedicScheduleApp.daoSession.getBloodPressureDBModelDao().insertOrReplace(bloodPressureDBModel);
    }
}
