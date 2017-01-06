package com.example.asus.medic_schedule.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.asus.medic_schedule.R;

public class AddPatientFragment extends Fragment {

    private EditText p_name;
    private String name;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.patient, container, false);
    }


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        p_name = (EditText) getView().findViewById(R.id.p_name);

    }

    public void onSavePatientButtonClick(View view) {
        name = p_name.getText().toString();

    }
}

