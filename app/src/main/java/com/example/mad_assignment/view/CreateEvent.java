package com.example.mad_assignment.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.mad_assignment.R;
import com.example.mad_assignment.controller.DateTextViewListener;
import com.example.mad_assignment.controller.NewEventSaveButtonListener;
import com.example.mad_assignment.controller.TimeTextViewListener;
import com.example.mad_assignment.model.MovieModelImpl;
import com.example.mad_assignment.view.viewmodel.MovieSpinnerAdapter;

public class CreateEvent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);

        setTitle("Create event");

        MovieModelImpl movieModelImpl = (MovieModelImpl) MovieModelImpl.getSingletonInstance(this);

        EditText title = findViewById(R.id.titleCreateEventEditText);
        EditText venue = findViewById(R.id.venueCreateEventEditText);
        EditText location = findViewById(R.id.locationCreateEventEditText);

        TextView startDate = findViewById(R.id.startDateCreateEventTextView);
        startDate.setOnClickListener(new DateTextViewListener(this, startDate));

        TextView startTime = findViewById(R.id.startTimeCreateEventTextView);
        startTime.setOnClickListener(new TimeTextViewListener(this, startTime));

        TextView endDate = findViewById(R.id.endDateCreateEventTextView);
        endDate.setOnClickListener(new DateTextViewListener(this, endDate));

        TextView endTime = findViewById(R.id.endTimeCreateEventTextView);
        endTime.setOnClickListener(new TimeTextViewListener(this, endTime));

        Spinner movieSpinner = findViewById(R.id.movieCreateEventSpinner);
        MovieSpinnerAdapter spinnerAdapter = new MovieSpinnerAdapter(this, movieModelImpl.getMovieList());
        movieSpinner.setAdapter(spinnerAdapter);

        Button attendees = findViewById(R.id.showAttendeesCreateEventButton);
        attendees.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CreateEvent.this, Attendees.class));
            }
        });


        Button saveButton = findViewById(R.id.createEventSaveButton);
        Button cancelButton = findViewById(R.id.cancelButton);

        // Save button functionality
        saveButton.setOnClickListener(new NewEventSaveButtonListener(this, title, venue, location, startDate, startTime, endDate, endTime, movieSpinner));

        // Cancel button functionality
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
