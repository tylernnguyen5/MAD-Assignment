package com.example.mad_assignment.view.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.example.mad_assignment.model.MovieImpl;
import com.example.mad_assignment.model.MovieModel;
import com.example.mad_assignment.model.MovieModelImpl;

import java.util.List;

public class ItemMovieListViewModel extends AndroidViewModel {
    private MutableLiveData<List<MovieImpl>> movieListLiveData;

    public ItemMovieListViewModel(Application application) {
        super(application);
    }

    public LiveData<List<MovieImpl>> getMovieArrayList(){
        if (movieListLiveData == null){
            movieListLiveData = new MutableLiveData<>();
            MovieModel movieModel = MovieModelImpl.getSingletonInstance(getApplication());
            movieListLiveData.setValue(movieModel.getMovieList());
        }
        return movieListLiveData;
    }
}
