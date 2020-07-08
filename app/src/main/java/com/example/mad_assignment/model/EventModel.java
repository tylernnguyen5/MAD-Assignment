package com.example.mad_assignment.model;

import com.example.mad_assignment.controller.EventDateComparator;

import java.util.List;

public interface EventModel {
    List<EventImpl> getEventArrayList();

    EventImpl getEventByID(String id);

    void removeEventByID(String id);

    void addEvent(EventImpl eventImpl);

    int getNextEventID();

    void saveNewDetail(String id, EventImpl eventImpl);

    void sorting(EventDateComparator eventDateComparator);
}
