package com.example.mad_assignment.controller;

import android.app.TimePickerDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.TextView;

import java.util.Calendar;

public class TimeTextViewListener implements View.OnClickListener {
    private Context context;
    private TimeSetListener timeSetListener;

    public TimeTextViewListener(Context context, TextView textView) {
        this.context = context;
        timeSetListener = new TimeSetListener(textView);
    }

    @Override
    public void onClick(View v) {
        Calendar calendar = Calendar.getInstance();

        // Current time
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        // Create dialog
        TimePickerDialog dialog = new TimePickerDialog(
                context,
                timeSetListener,
                hour, minute, false
        );
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
    }
}
