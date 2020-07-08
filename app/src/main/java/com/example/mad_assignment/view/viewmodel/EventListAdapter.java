package com.example.mad_assignment.view.viewmodel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.mad_assignment.R;
import com.example.mad_assignment.controller.EditEventButtonListener;
import com.example.mad_assignment.controller.EventDateComparator;
import com.example.mad_assignment.model.EventImpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class EventListAdapter extends ArrayAdapter<EventImpl> {
    private Context context;
    private List<EventImpl> eventArrayList;

    public EventListAdapter(Context context, List<EventImpl> eventArrayList, EventDateComparator comparator) {
        super(context, 0, eventArrayList);
        this.context = context;
        this.eventArrayList = eventArrayList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.event_list_item, parent, false);
        }

        TextView title = convertView.findViewById(R.id.eventTitleTextView);
        TextView venue = convertView.findViewById(R.id.eventVenueTextView);
        TextView location = convertView.findViewById(R.id.eventLocationTextView);
        TextView startDate = convertView.findViewById(R.id.eventStartDateTextView);
        TextView attendees = convertView.findViewById(R.id.eventAttendeesNumberTextView);
        TextView movie = convertView.findViewById(R.id.eventMovieTextView);
        TextView id = convertView.findViewById(R.id.eventIdTextView);

        EventImpl event = eventArrayList.get(position);

        title.setText(event.getTitle());
        venue.setText(event.getVenue());
        location.setText(event.getLocation());

        SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss a");
        startDate.setText(dateformat.format(event.getStartDate()));

        attendees.setText("Attendees: To be implemented");

        if (event.getMovie() != null) movie.setText(event.getMovie().getTitle());
        else movie.setText("Movie: To be selected");


        Button editButton = convertView.findViewById(R.id.eventEditButton);
        editButton.setOnClickListener(new EditEventButtonListener(context, String.valueOf(event.getId())));

        return convertView;
    }
}
