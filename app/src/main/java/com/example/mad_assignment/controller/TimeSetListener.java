package com.example.mad_assignment.controller;

import android.app.TimePickerDialog;
import android.widget.TextView;
import android.widget.TimePicker;

class TimeSetListener implements TimePickerDialog.OnTimeSetListener {
    private TextView textView;

    public TimeSetListener(TextView textView) {
        this.textView = textView;
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        // Obtain Am/Pm
        String amPm;
        if (hourOfDay < 12) amPm = "AM";
        else {
            hourOfDay -= 12;
            amPm = "PM";
        }

        String time = String.format("%d:%d:00 %s", hourOfDay, minute, amPm);
        textView.setText(time);
    }
}
