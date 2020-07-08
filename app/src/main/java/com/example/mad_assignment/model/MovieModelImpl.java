package com.example.mad_assignment.model;

import android.content.Context;
import android.util.Log;

import com.example.mad_assignment.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MovieModelImpl implements MovieModel {
    private final String TAG = getClass().getName();
    private List<MovieImpl> movieArrayList = new ArrayList<>();
    private static Context applicationContext;
    private int idCounter = 3;

    private MovieModelImpl(){loadMovieList();}

    private static class LazyHolder {
        static final MovieModel INSTANCE = new MovieModelImpl();
    }

    public static MovieModel getSingletonInstance(Context appContext) {
        if(applicationContext == null) {
            applicationContext = appContext;
        }
        return LazyHolder.INSTANCE;
    }

    public void loadMovieList(){
        Scanner scanner = null;
        String line;
        String[] data;

        movieArrayList.clear();

        try{
            scanner = new Scanner(applicationContext.getResources().openRawResource(R.raw.movies));
            while (scanner.hasNextLine()){
                line = scanner.nextLine();
                if (!line.startsWith("//")) {
                    data = line.split(",");

                    for (int i = 0; i < data.length; i++){
                        data[i] = data[i].substring(1, data[i].length() - 1);
                    }

                    movieArrayList.add(new MovieImpl(Integer.parseInt(data[0]), data[1], Integer.parseInt(data[2]), data[3]));
                }
            }
        } catch (Exception e){
            Log.i(TAG, e.getMessage());
        } finally {
            if (scanner != null) scanner.close();
        }
    }

    @Override
    public List<MovieImpl> getMovieList() {
        return movieArrayList;
    }

    @Override
    public MovieImpl getMovieByID(String id) {
        for (MovieImpl movieImpl: movieArrayList) {
            if (String.valueOf(movieImpl.getId()).equals(id)){
                return movieImpl;
            }
        }
        return null;

    }

    @Override
    public void removeMovieByID(String id) {
        for (MovieImpl movieImpl: movieArrayList) {
            if (String.valueOf(movieImpl.getId()).equals(id)){
                movieArrayList.remove(movieImpl);
                break;
            }
        }
    }

    @Override
    public void addMovie(MovieImpl movieImpl) {
        movieArrayList.add(movieImpl);
    }

    @Override
    public int getNextMovieID() {
        return (idCounter++);
    }

    @Override
    public void saveNewDetail(String id, MovieImpl movieImpl) {
        removeMovieByID(id);

        addMovie(movieImpl);
    }
}
