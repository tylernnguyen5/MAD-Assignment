package com.example.mad_assignment.view.viewmodel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.mad_assignment.R;
import com.example.mad_assignment.model.MovieImpl;

import java.util.List;

public class MovieSpinnerAdapter extends ArrayAdapter<MovieImpl> {

    public MovieSpinnerAdapter(Context context, List<MovieImpl> movieArrayList) {
        super(context, 0, movieArrayList);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    private View initView(int position, View convertView, ViewGroup parent){
        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.movie_spinner_item, parent, false);
        }

        TextView title = convertView.findViewById(R.id.movieTitleTextViewSpinner);
        TextView year = convertView.findViewById(R.id.movieYearTextViewSpinner);

        MovieImpl movieImpl = getItem(position);

        if (movieImpl != null){
            title.setText(movieImpl.getTitle());
            year.setText(String.valueOf(movieImpl.getYear()));
        }

        return convertView;
    }
}
