package com.example.mad_assignment.model;

import java.util.Date;

public interface Event {
    int getId();

    String getTitle();

    Date getStartDate();

    Date getEndDate();

    String getVenue();

    String getLocation();

    int getAttendeesNum();

    MovieImpl getMovie();

    void addMovie(MovieImpl movie);

}
