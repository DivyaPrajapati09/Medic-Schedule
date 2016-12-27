package com.example.asus.medic_schedule.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.asus.medic_schedule.R;
import com.example.asus.medic_schedule.model.BloodPressureDBModel;

import java.util.List;

public class BloodPressureListAdapter extends RecyclerView.Adapter<BloodPressureListAdapter.ViewHolder> {

    private Context mContext;
    private List<BloodPressureDBModel> mListOfMedicine;


    public BloodPressureListAdapter(Context context, List<BloodPressureDBModel> listOfMedicine) {
        mContext = context;
        mListOfMedicine = listOfMedicine;
    }

    @Override
    public BloodPressureListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(mContext, R.layout.row_item_blood_pressure, null);
        return new BloodPressureListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BloodPressureListAdapter.ViewHolder holder, int position) {
        holder.mSystol.setText(String.valueOf(mListOfMedicine.get(position).getSystol()));
        holder.mDystol.setText(String.valueOf(mListOfMedicine.get(position).getDystol()));
        holder.mPulse.setText(String.valueOf(mListOfMedicine.get(position).getPulse()));
        holder.mDate.setText(String.valueOf(mListOfMedicine.get(position).getDate().getDate()));
    }

    @Override
    public int getItemCount() {
        return mListOfMedicine.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mSystol;
        private TextView mDystol;
        private TextView mPulse;
        private TextView mDate;

        ViewHolder(View itemView) {
            super(itemView);
            mSystol = (TextView) itemView.findViewById(R.id.Sys);
            mDystol = (TextView) itemView.findViewById(R.id.Dys);
            mPulse = (TextView) itemView.findViewById(R.id.Pul);
            mDate = (TextView) itemView.findViewById(R.id.Time);
        }
    }
}
