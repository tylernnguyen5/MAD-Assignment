package com.example.mad_assignment.view.viewmodel;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mad_assignment.R;
import com.example.mad_assignment.model.MovieImpl;

import java.util.List;

public class MovieListAdapter extends ArrayAdapter<MovieImpl> {
    private Context context;
    private List<MovieImpl> movieArrayList;

    public MovieListAdapter(Context context, List<MovieImpl> movieArrayList) {
        super(context, 0, movieArrayList);
        this.context = context;
        this.movieArrayList = movieArrayList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.movie_list_item, parent, false);
        }

        TextView title = convertView.findViewById(R.id.movieTitleTextView);
        TextView year = convertView.findViewById(R.id.movieYearTextView);
        ImageView poster = convertView.findViewById(R.id.moviePosterImageView);

        MovieImpl movie = movieArrayList.get(position);

        title.setText(movie.getTitle());
        year.setText(String.valueOf(movie.getYear()));

        String filename = movie.getFilename().toLowerCase();
        filename = filename.substring(0, filename.length()-4); // get rid of ".jpg"

        Resources resources = context.getResources();
        int resourceId = resources.getIdentifier(filename, "drawable", context.getPackageName());
        poster.setImageDrawable(resources.getDrawable(resourceId));


        Button editButton = convertView.findViewById(R.id.movieEditButton);

        return convertView;
    }
}
