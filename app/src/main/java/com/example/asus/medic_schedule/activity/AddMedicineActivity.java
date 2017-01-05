package com.example.asus.medic_schedule.activity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import com.example.asus.medic_schedule.R;
import com.example.asus.medic_schedule.core.MedicScheduleApp;
import com.example.asus.medic_schedule.model.MedicineDBModel;

public class AddMedicineActivity extends ActionBarActivity {

    private EditText mMedicineName, mMedicineDosage, mMedicineReminderTime, mMedicineExpiryDate, mMedicineQuantity;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_medicine_activity);

        mMedicineName = (EditText) findViewById(R.id.medicine_name);
        mMedicineReminderTime = (EditText) findViewById(R.id.reminder_time);
        mMedicineExpiryDate = (EditText) findViewById(R.id.expiry_date);
        mMedicineDosage = (EditText) findViewById(R.id.dosage);
        mMedicineQuantity = (EditText) findViewById(R.id.quantity);
        mMedicineReminderTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTimeSelectionDialog();
            }
        });
        mMedicineExpiryDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });

    }

    private void showDatePickerDialog() {

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                mMedicineExpiryDate.setText(String.format("%s/%s/%s", String.valueOf(dayOfMonth),
                        String.valueOf(month),
                        String.valueOf(year)));
            }
        }, Calendar.YEAR, Calendar.MONTH, Calendar.DAY_OF_MONTH);
        datePickerDialog.show();
    }

    private void showTimeSelectionDialog() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                String AM_PM = "AM";
                if (hourOfDay > 12) {
                    hourOfDay = hourOfDay - 12;
                    AM_PM = "PM";
                }
                mMedicineReminderTime.setText(String.format("%d:%d %s", hourOfDay, minute, AM_PM));
            }
        }, Calendar.HOUR_OF_DAY, Calendar.MINUTE, false);
        timePickerDialog.show();
    }


    public void onSaveMedicineButtonClick(View view) {
        MedicineDBModel medicineDBModel = new MedicineDBModel();
        medicineDBModel.setMedicineName(mMedicineName.getText().toString());
        medicineDBModel.setExpiryDate(mMedicineExpiryDate.getText().toString());
        medicineDBModel.setQuantity(Integer.parseInt(mMedicineQuantity.getText().toString()));
        medicineDBModel.setTimeToTakeMedicine(mMedicineReminderTime.getText().toString());
        MedicScheduleApp.daoSession.getMedicineDBModelDao().insertOrReplace(medicineDBModel);
    }
}





