package com.example.mad_assignment.view.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.example.mad_assignment.model.EventImpl;
import com.example.mad_assignment.model.EventModel;
import com.example.mad_assignment.model.EventModelImpl;

import java.util.List;

public class ItemEventListViewModel extends AndroidViewModel {
    private MutableLiveData<List<EventImpl>> eventListLiveData;

    public ItemEventListViewModel(Application application) {
        super(application);
    }

    public LiveData<List<EventImpl>> getEventArrayList(){
        if (eventListLiveData == null){
            eventListLiveData = new MutableLiveData<>();
            EventModel eventModel = EventModelImpl.getSingletonInstance(getApplication());
            eventListLiveData.setValue(eventModel.getEventArrayList());
        }
        return eventListLiveData;
    }
}
