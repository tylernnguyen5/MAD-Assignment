package com.example.mad_assignment.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class AbstractEvent implements Event{
    private int id;
    private String title;
    private Date startDate;
    private Date endDate;
    private String venue;
    private String location;
    private int attendeesNum;
    private MovieImpl movie;

    private SimpleDateFormat dateformat = new SimpleDateFormat("dd/mm/yyyy hh:mm:ss a");

    // Constructor for initiating (reading events.txt file and display event list summary)
    public AbstractEvent(int id, String title, String startDate, String endDate, String venue, String location) {
        this.id = id;
        this.title = title;

        try {
            this.startDate = dateformat.parse(startDate);
            this.endDate = dateformat.parse(endDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        this.venue = venue;
        this.location = location;
    }

    // Constructor for editing a event
    public AbstractEvent(int id, String title, String startDate, String endDate, String venue, String location, int attendeesNum, MovieImpl movie) {
        this.id = id;
        this.title = title;

        try {
            this.startDate = dateformat.parse(startDate);
            this.endDate = dateformat.parse(endDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        this.venue = venue;
        this.location = location;
        this.attendeesNum = attendeesNum;
        this.movie = movie;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public Date getStartDate() {
        return startDate;
    }

    @Override
    public Date getEndDate() {
        return endDate;
    }

    @Override
    public String getVenue() {
        return venue;
    }

    @Override
    public String getLocation() {
        return location;
    }

    @Override
    public int getAttendeesNum() {
        return attendeesNum;
    }

    @Override
    public MovieImpl getMovie() {
        return movie;
    }

    @Override
    public void addMovie(MovieImpl movie) {
        this.movie = movie;
    }

}
