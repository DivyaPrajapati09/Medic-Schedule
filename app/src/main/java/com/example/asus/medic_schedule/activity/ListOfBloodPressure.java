package com.example.asus.medic_schedule.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.asus.medic_schedule.R;
import com.example.asus.medic_schedule.adapter.BloodPressureListAdapter;
import com.example.asus.medic_schedule.core.MedicScheduleApp;
import com.example.asus.medic_schedule.fragment.AddBloodPressureFragment;
import com.example.asus.medic_schedule.model.BloodPressureDBModel;
import com.example.asus.medic_schedule.model.BloodPressureDBModelDao;

import java.util.List;

public class ListOfBloodPressure extends ActionBarActivity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.datalist_bp);

        List<BloodPressureDBModel> mListOfMedicine = MedicScheduleApp.daoSession.getBloodPressureDBModelDao()
                .queryBuilder().orderDesc(BloodPressureDBModelDao.Properties.Date).list();
        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.blood_pressure_list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        BloodPressureListAdapter mListAdapter = new BloodPressureListAdapter(this, mListOfMedicine);
        mRecyclerView.setAdapter(mListAdapter);
        mListAdapter.notifyDataSetChanged();
    }

    public void onAddBloodPressureClickListener(View view) {
        Intent intent = new Intent(ListOfBloodPressure.this, AddBloodPressureFragment.class);
        startActivity(intent);
    }
}



