package com.example.asus.medic_schedule.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.asus.medic_schedule.R;
import com.example.asus.medic_schedule.model.MedicineDBModel;

import java.util.ArrayList;
import java.util.List;

public class MedicineListAdapter extends RecyclerView.Adapter<MedicineListAdapter.ViewHolder> {

    private List<MedicineDBModel> mMedicineList = new ArrayList<>();
    private Context mContext;

    public MedicineListAdapter(Context context, List<MedicineDBModel> medicineList) {
        mContext = context;
        mMedicineList = medicineList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(mContext, R.layout.row_medicine, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
     //   holder.mMedicineName.setText(mMedicineList.get(position).getMedicineName());
    }

    @Override
    public int getItemCount() {
        return mMedicineList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView mMedicineName;

        public ViewHolder(View itemView) {
            super(itemView);
            mMedicineName = (TextView) itemView.findViewById(R.id.medicine_name);
        }
    }
}
