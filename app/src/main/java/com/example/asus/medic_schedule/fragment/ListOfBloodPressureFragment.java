package com.example.asus.medic_schedule.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asus.medic_schedule.R;
import com.example.asus.medic_schedule.adapter.BloodPressureListAdapter;
import com.example.asus.medic_schedule.core.MedicScheduleApp;
import com.example.asus.medic_schedule.model.BloodPressureDBModel;
import com.example.asus.medic_schedule.model.BloodPressureDBModelDao;

import java.util.List;

public class ListOfBloodPressureFragment extends Fragment implements View.OnClickListener {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.datalist_bp, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        List<BloodPressureDBModel> mListOfMedicine = MedicScheduleApp.daoSession.getBloodPressureDBModelDao()
                .queryBuilder().orderDesc(BloodPressureDBModelDao.Properties.Date).list();

        RecyclerView mRecyclerView = (RecyclerView) getView().findViewById(R.id.blood_pressure_list);
        FloatingActionButton addBloodPressureButton = (FloatingActionButton) getView().findViewById(R.id.add_blood_pressure);
        addBloodPressureButton.setOnClickListener(this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        BloodPressureListAdapter mListAdapter = new BloodPressureListAdapter(getActivity(), mListOfMedicine);
        mRecyclerView.setAdapter(mListAdapter);
        mListAdapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View v) {
        Fragment fragment = new AddBloodPressureFragment();
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.container, fragment).commit();
    }
}



