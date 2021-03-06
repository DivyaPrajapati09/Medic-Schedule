package com.example.asus.medic_schedule.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.asus.medic_schedule.R;
import com.example.asus.medic_schedule.model.RowItem_bp;

import java.util.List;

public class CustomListViewAdapter extends ArrayAdapter<RowItem_bp> {
    Context context;

    public CustomListViewAdapter(Context context, int resourceId, List<RowItem_bp> items) {
        super(context, resourceId, items);
        this.context = context;
    }

    private class ViewHolder {
        TextView sys;
        TextView dys;
        TextView pul;
    }

    @NonNull
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder;
        RowItem_bp rowItem = getItem(position);

        LayoutInflater mInflater = (LayoutInflater) context
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.row_item_blood_pressure, null);
            holder = new ViewHolder();
            holder.sys = (TextView) convertView.findViewById(R.id.Sys);
            holder.dys = (TextView) convertView.findViewById(R.id.Dys);
            holder.pul = (TextView) convertView.findViewById(R.id.Pul);
            convertView.setTag(holder);
        } else

            holder = (ViewHolder) convertView.getTag();

        holder.sys.setText(rowItem.getSys());
        holder.dys.setText(rowItem.getDys());
        holder.pul.setText(rowItem.getPul());
        return convertView;
    }
}