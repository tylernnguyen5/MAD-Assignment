package com.example.mad_assignment.controller;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;

import com.example.mad_assignment.view.CreateEvent;

public class FloatingActionButtonListener implements View.OnClickListener {
    private String TAG = getClass().getName();

    private Context context;

    public FloatingActionButtonListener(Context context) {
        this.context = context;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(context, CreateEvent.class);

        if (intent.resolveActivity(context.getPackageManager()) != null){
            context.startActivity(intent);
        }
        else{
            Log.i(TAG, "Cannot open this activity for this event");
        }
    }
}
