package com.example.mad_assignment.controller;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;

import com.example.mad_assignment.view.EditEvent;

public class EditEventButtonListener implements View.OnClickListener {
    private String TAG = getClass().getName();

    private Context context;
    private String eventID;

    public EditEventButtonListener(Context context, String eventID) {
        this.context = context;
        this.eventID = eventID;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(context, EditEvent.class);
        intent.putExtra(Intent.EXTRA_TEXT, eventID);
        intent.setType("text/plain");

        if (intent.resolveActivity(context.getPackageManager()) != null){
            context.startActivity(intent);
        }
        else{
            Log.i(TAG, "Cannot open this activity for this event");
        }


    }
}
