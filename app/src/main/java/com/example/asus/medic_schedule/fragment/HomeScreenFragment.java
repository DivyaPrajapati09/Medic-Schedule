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

import java.util.ArrayList;

public class HomeScreenFragment extends Fragment {
    private ArrayList<String> medicineList = new ArrayList<>();

    public HomeScreenFragment() {
    }

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home_screen, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        RecyclerView mRecyclerView = (RecyclerView) getView().findViewById(R.id.medicine_list);
        medicineList.add("Zetamet");
        medicineList.add("Crocin");
        medicineList.add("Deplat");
        medicineList.add("metafin");
        medicineList.add("Disprin");
        MedicineListAdapter mMedicineListAdapter = new MedicineListAdapter(getActivity(), medicineList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(mMedicineListAdapter);
    }
}
