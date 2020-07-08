package com.example.mad_assignment.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.mad_assignment.R;
import com.example.mad_assignment.controller.EventDateComparator;
import com.example.mad_assignment.controller.FloatingActionButtonListener;
import com.example.mad_assignment.model.EventImpl;
import com.example.mad_assignment.model.EventModelImpl;
import com.example.mad_assignment.view.viewmodel.EventListAdapter;
import com.example.mad_assignment.view.viewmodel.ItemEventListViewModel;

import java.util.HashMap;
import java.util.List;

public class EventListSummary extends AppCompatActivity {
    private EventModelImpl eventModelImpl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_list_summary);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setTitle("Event List Summary");

        ItemEventListViewModel myViewModel = ViewModelProviders.of(this).get(ItemEventListViewModel.class);

        myViewModel.getEventArrayList().observe(this, new Observer<List<EventImpl>>() {
            @Override
            public void onChanged(List<EventImpl> eventList) {
                EventListAdapter eventListAdapter = new EventListAdapter(EventListSummary.this, eventList, new EventDateComparator());
                ListView listView = findViewById(R.id.eventListSummaryListView);
                listView.setAdapter(eventListAdapter);
            }
        });

        eventModelImpl = (EventModelImpl) EventModelImpl.getSingletonInstance(this);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new FloatingActionButtonListener(this));
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        else if (id == R.id.action_movie_list){
            startActivity(new Intent(this, MovieList.class));
        }
        else if (id == R.id.sort_ascending){
            eventModelImpl.sorting(new EventDateComparator());

            finish();
            startActivity(getIntent());
        }
        else if (id == R.id.sort_descending){
            eventModelImpl.sorting(new EventDateComparator(EventDateComparator.REVERSE_ORDER));

            finish();
            startActivity(getIntent());
        }

        return super.onOptionsItemSelected(item);
    }
}
