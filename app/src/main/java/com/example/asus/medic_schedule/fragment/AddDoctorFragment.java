package com.example.asus.medic_schedule.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.asus.medic_schedule.R;

public class AddDoctorFragment extends Fragment {

    private EditText d_name, txt_mail, txt_phn;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.doctor, container, false);
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        txt_mail = (EditText) getView().findViewById(R.id.txt_mail);
        d_name = (EditText) getView().findViewById(R.id.d_name);
        txt_phn = (EditText) getView().findViewById(R.id.txt_phn);
    }

}

