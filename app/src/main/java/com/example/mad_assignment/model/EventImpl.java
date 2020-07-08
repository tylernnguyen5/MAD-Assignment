package com.example.mad_assignment.model;


public class EventImpl extends AbstractEvent {
    public EventImpl(int id, String title, String startDate, String endDate, String venue, String location) {
        super(id, title, startDate, endDate, venue, location);
    }

    public EventImpl(int id, String title, String startDate, String endDate, String venue, String location, int attendeesNum, MovieImpl movie) {
        super(id, title, startDate, endDate, venue, location, attendeesNum, movie);
    }
}
