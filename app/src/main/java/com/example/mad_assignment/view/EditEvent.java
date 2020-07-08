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
import com.example.mad_assignment.controller.EditEventRemoveButtonListener;
import com.example.mad_assignment.controller.EditEventSaveButtonListener;
import com.example.mad_assignment.controller.TimeTextViewListener;
import com.example.mad_assignment.model.EventImpl;
import com.example.mad_assignment.model.EventModelImpl;
import com.example.mad_assignment.model.MovieImpl;
import com.example.mad_assignment.model.MovieModelImpl;
import com.example.mad_assignment.view.viewmodel.MovieSpinnerAdapter;

import java.text.SimpleDateFormat;

public class EditEvent extends AppCompatActivity {
    private String eventID;
    private EventModelImpl eventModelImpl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_event);

        setTitle("Edit event");

        SimpleDateFormat dateformat = new SimpleDateFormat("dd/mm/yyyy hh:mm:ss a");

        Intent intent = getIntent();
        eventID = (String) intent.getExtras().get(Intent.EXTRA_TEXT);

        eventModelImpl = (EventModelImpl) EventModelImpl.getSingletonInstance(this);
        MovieModelImpl movieModelImpl = (MovieModelImpl) MovieModelImpl.getSingletonInstance(this);

        EventImpl eventImpl = eventModelImpl.getEventByID(eventID);

        // Fill fields
        EditText title = findViewById(R.id.titleEditEventEditText);
        EditText venue = findViewById(R.id.venueEditEventEditText);
        EditText location = findViewById(R.id.locationEditEventEditText);

        title.setText(eventImpl.getTitle());
        venue.setText(eventImpl.getVenue());
        location.setText(eventImpl.getLocation());

        TextView startDate = findViewById(R.id.startDateEditEventTextView);
        startDate.setText(dateformat.format(eventImpl.getStartDate()).substring(0, 10));
        startDate.setOnClickListener(new DateTextViewListener(this, startDate));

        TextView startTime = findViewById(R.id.startTimeEditEventTextView);
        startTime.setText(dateformat.format(eventImpl.getStartDate()).substring(10));
        startTime.setOnClickListener(new TimeTextViewListener(this, startTime));

        TextView endDate = findViewById(R.id.endDateEditEventTextView);
        endDate.setText(dateformat.format(eventImpl.getEndDate()).substring(0, 10));
        endDate.setOnClickListener(new DateTextViewListener(this, endDate));

        TextView endTime = findViewById(R.id.endTimeEditEventTextView);
        endTime.setText(dateformat.format(eventImpl.getEndDate()).substring(10));
        endTime.setOnClickListener(new TimeTextViewListener(this, endTime));

        Spinner movieSpinner = findViewById(R.id.movieEditEventSpinner);
        MovieSpinnerAdapter spinnerAdapter = new MovieSpinnerAdapter(this, movieModelImpl.getMovieList());
        movieSpinner.setAdapter(spinnerAdapter);

        Button attendees = findViewById(R.id.showAttendeesEditEventButton);
        attendees.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EditEvent.this, Attendees.class));
            }
        });

        // Pre-select movie for event
        MovieImpl movieImpl = eventImpl.getMovie();
        if (movieImpl != null){
            int spinnerPosition = spinnerAdapter.getPosition(movieImpl);
            movieSpinner.setSelection(spinnerPosition);
        }


        Button saveButton = findViewById(R.id.editEventSaveButton);
        Button removeButton = findViewById(R.id.removeButton);
        Button cancelButton = findViewById(R.id.cancelButton);

        // Save button functionality
        saveButton.setOnClickListener(new EditEventSaveButtonListener(this, eventID,title, venue, location, startDate, startTime, endDate, endTime, movieSpinner));

        // Remove button functionality
        removeButton.setOnClickListener(new EditEventRemoveButtonListener(EditEvent.this, eventID));

        // Cancel button functionality
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
