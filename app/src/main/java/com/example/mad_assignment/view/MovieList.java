package com.example.mad_assignment.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.mad_assignment.R;
import com.example.mad_assignment.model.MovieImpl;
import com.example.mad_assignment.model.MovieModel;
import com.example.mad_assignment.model.MovieModelImpl;
import com.example.mad_assignment.view.viewmodel.ItemMovieListViewModel;
import com.example.mad_assignment.view.viewmodel.MovieListAdapter;

import java.util.List;

public class MovieList extends AppCompatActivity {
    private MovieModelImpl movieModelImpl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);

        setTitle("Movie List");

        ItemMovieListViewModel myViewModel = ViewModelProviders.of(this).get(ItemMovieListViewModel.class);

        myViewModel.getMovieArrayList().observe(this, new Observer<List<MovieImpl>>() {
            @Override
            public void onChanged(List<MovieImpl> movieList) {
                MovieListAdapter movieListAdapter = new MovieListAdapter(MovieList.this, movieList);
                ListView listView = findViewById(R.id.MovieListListView);
                listView.setAdapter(movieListAdapter);
            }
        });

        movieModelImpl = (MovieModelImpl) MovieModelImpl.getSingletonInstance(this);

    }
}
