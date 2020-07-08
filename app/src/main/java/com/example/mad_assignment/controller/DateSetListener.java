package com.example.mad_assignment.controller;

import android.app.DatePickerDialog;
import android.widget.DatePicker;
import android.widget.TextView;

public class DateSetListener implements DatePickerDialog.OnDateSetListener {
    private TextView textView;

    public DateSetListener(TextView textView){
        this.textView = textView;
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        month = month + 1;
        String date = String.format("%d/%d/%d", dayOfMonth, month, year);

        textView.setText(date);
    }
}
