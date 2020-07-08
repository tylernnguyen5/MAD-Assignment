package com.example.mad_assignment.controller;

import android.app.DatePickerDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.TextView;

import java.util.Calendar;

public class DateTextViewListener implements View.OnClickListener {
    private Context context;
    private DateSetListener dateSetListener;

    public DateTextViewListener(Context context, TextView textView){
        this.context = context;
        dateSetListener = new DateSetListener(textView);
    }

    @Override
    public void onClick(View v) {
        Calendar calendar = Calendar.getInstance();

        // Today date
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);

        // Create dialog
        DatePickerDialog dialog = new DatePickerDialog(
                context,
                android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                dateSetListener,
                year, month, day
        );
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
    }


}
