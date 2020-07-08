package com.example.mad_assignment.controller;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mad_assignment.model.EventImpl;
import com.example.mad_assignment.model.EventModelImpl;
import com.example.mad_assignment.model.MovieImpl;
import com.example.mad_assignment.view.EventListSummary;

public class EditEventSaveButtonListener implements View.OnClickListener {
    private Context context;
    private String eventID;
    private EditText title;
    private EditText venue;
    private EditText location;
    private TextView startDate;
    private TextView startTime;
    private TextView endDate;
    private TextView endTime;
    private Spinner movieSpinner;

    public EditEventSaveButtonListener(Context context, String eventID, EditText title, EditText venue, EditText location, TextView startDate, TextView startTime, TextView endDate, TextView endTime, Spinner movieSpinner) {
        this.context = context;
        this.eventID = eventID;
        this.title = title;
        this.venue = venue;
        this.location = location;
        this.startDate = startDate;
        this.startTime = startTime;
        this.endDate = endDate;
        this.endTime = endTime;
        this.movieSpinner = movieSpinner;
    }

    @Override
    public void onClick(View v) {
        EventModelImpl eventModelImpl = (EventModelImpl) EventModelImpl.getSingletonInstance(context);

        EventImpl eventImpl = new EventImpl(Integer.parseInt(eventID),
                title.getText().toString(),
                String.format("%s %s", startDate.getText().toString(), startTime.getText().toString()),
                String.format("%s %s", endDate.getText().toString(), endTime.getText().toString()),
                venue.getText().toString(),
                location.getText().toString());

        eventImpl.addMovie((MovieImpl) movieSpinner.getSelectedItem());

        eventModelImpl.saveNewDetail(eventID, eventImpl);

        Toast.makeText(context, "Saved event", Toast.LENGTH_LONG).show();
        context.startActivity(new Intent(context, EventListSummary.class));
    }
}
