package com.example.asus.medic_schedule.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asus.medic_schedule.R;
import com.example.asus.medic_schedule.adapter.MedicineListAdapter;
import com.example.asus.medic_schedule.core.MedicScheduleApp;
import com.example.asus.medic_schedule.model.MedicineDBModel;

import java.util.List;

public class HomeScreenFragment extends Fragment {

    public HomeScreenFragment() {
    }

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.list_medicine_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        RecyclerView mRecyclerView = (RecyclerView) getView().findViewById(R.id.medicine_list);
        List<MedicineDBModel> medicineList = MedicScheduleApp.daoSession.getMedicineDBModelDao().loadAll();
        MedicineListAdapter mMedicineListAdapter = new MedicineListAdapter(getActivity(), medicineList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(mMedicineListAdapter);
    }
}
