package com.example.mad_assignment.controller;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.example.mad_assignment.model.EventModelImpl;
import com.example.mad_assignment.view.EventListSummary;

public class EditEventRemoveButtonListener implements View.OnClickListener {
    private Context context;
    private EventModelImpl eventModelImpl;
    private String eventID;

    public EditEventRemoveButtonListener(Context context, String eventID) {
        this.context = context;
        this.eventID = eventID;
    }

    @Override
    public void onClick(View v) {
        eventModelImpl = (EventModelImpl) EventModelImpl.getSingletonInstance(context);
        eventModelImpl.removeEventByID(eventID);
        Toast.makeText(context, "Removed event", Toast.LENGTH_LONG).show();
        context.startActivity(new Intent(context, EventListSummary.class));
    }
}
