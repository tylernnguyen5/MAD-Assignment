package com.example.mad_assignment.model;

import android.content.Context;
import android.util.Log;

import com.example.mad_assignment.R;
import com.example.mad_assignment.controller.EventDateComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class EventModelImpl implements EventModel {

    private final String TAG = getClass().getName();
    private List<EventImpl> eventArrayList = new ArrayList<>();
    private static Context applicationContext;
//    private PropertyChangeSupport listeners = new PropertyChangeSupport(eventArrayList);
    private int idCounter = 3;

    private EventModelImpl(){loadEventList();}

    private static class LazyHolder {
        static final EventModel INSTANCE = new EventModelImpl();
    }

    public static EventModel getSingletonInstance(Context appContext) {
        if(applicationContext == null) {
            applicationContext = appContext;
        }
        return LazyHolder.INSTANCE;
    }


    public void loadEventList(){
        Scanner scanner = null;
        String line;
        String[] data;

//        eventHashMap.clear();
        eventArrayList.clear();

        try{
            scanner = new Scanner(applicationContext.getResources().openRawResource(R.raw.events));
            while (scanner.hasNextLine()){
                line = scanner.nextLine();
                if (!line.startsWith("//")) {
                    data = line.split(",", 6);

                    for (int i = 0; i < data.length; i++){
                        data[i] = data[i].substring(1, data[i].length() - 1);
                    }

//                    eventHashMap.put(data[0], new EventImpl(Integer.parseInt(data[0]), data[1], data[2], data[3], data[4], data[5]));
                    eventArrayList.add(new EventImpl(Integer.parseInt(data[0]), data[1], data[2], data[3], data[4], data[5]));
                }
            }
        } catch (Exception e){
            Log.i(TAG, e.getMessage());
        } finally {
            if (scanner != null) scanner.close();
        }

    }


    @Override
    public EventImpl getEventByID(String id) {
        for (EventImpl eventImpl: eventArrayList) {
           if (String.valueOf(eventImpl.getId()).equals(id)){
               return eventImpl;
           }
        }
        return null;
    }

    @Override
    public void removeEventByID(String id) {
        for (EventImpl eventImpl: eventArrayList) {
            if (String.valueOf(eventImpl.getId()).equals(id)){
                eventArrayList.remove(eventImpl);
                break;
            }
        }
    }

    @Override
    public void addEvent(EventImpl eventImpl) {
        eventArrayList.add(eventImpl);
    }

    @Override
    public int getNextEventID() {
        return (idCounter++);
    }

    @Override
    public void saveNewDetail(String id, EventImpl eventImpl) {
        removeEventByID(id);

        addEvent(eventImpl);
    }

    @Override
    public List<EventImpl> getEventArrayList() {
        return eventArrayList;
    }

    @Override
    public void sorting(EventDateComparator eventDateComparator) {
        Collections.sort(eventArrayList, eventDateComparator);
    }

}
