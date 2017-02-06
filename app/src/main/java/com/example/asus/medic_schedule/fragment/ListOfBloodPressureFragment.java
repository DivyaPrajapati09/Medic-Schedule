package com.example.asus.medic_schedule.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
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
import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;

import java.util.List;

public class ListOfBloodPressureFragment extends Fragment implements View.OnClickListener {
    FloatingActionMenu floatingActionMenu;

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
        floatingActionMenu = (FloatingActionMenu) getView().findViewById(R.id.menu);
        FloatingActionButton addRecordButton = (FloatingActionButton) getView().findViewById(R.id.add_record);
        FloatingActionButton viewGraph = (FloatingActionButton) getView().findViewById(R.id.view_graph);
        addRecordButton.setOnClickListener(this);
        viewGraph.setOnClickListener(this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        BloodPressureListAdapter mListAdapter = new BloodPressureListAdapter(getActivity(), mListOfMedicine);
        mRecyclerView.setAdapter(mListAdapter);
        mListAdapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View v) {
        Fragment fragment;
        FragmentManager fragmentManager = getFragmentManager();
        switch (v.getId()) {
            case R.id.add_record:
                floatingActionMenu.close(true);
                fragment = new AddBloodPressureFragment();
                fragmentManager.beginTransaction().replace(R.id.container, fragment).commit();
                break;
            case R.id.view_graph:
                floatingActionMenu.close(true);
                fragment = new GraphFragment();
                fragmentManager.beginTransaction().replace(R.id.container, fragment).commit();
                break;
        }

    }
}



