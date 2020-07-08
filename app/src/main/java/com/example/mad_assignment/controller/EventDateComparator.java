package com.example.mad_assignment.controller;

import com.example.mad_assignment.model.EventImpl;

import java.util.Comparator;

public class EventDateComparator implements Comparator<EventImpl> {
    public static final int REVERSE_ORDER = 1;
    private int order;


    public EventDateComparator(int order) {
        this.order = order;
    }

    public EventDateComparator() {
        this(0);
    }


    @Override
    public int compare(EventImpl e1, EventImpl e2) {
        if(order == REVERSE_ORDER) {
            return e2.getStartDate().compareTo(e1.getStartDate());
        } else {
            return e1.getStartDate().compareTo(e2.getStartDate());
        }
    }
}
