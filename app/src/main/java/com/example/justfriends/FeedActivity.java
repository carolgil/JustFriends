package com.example.justfriends;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class FeedActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView mMainNav;
    private ArrayList<Event> events;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;


    Button Event_Button_Favourite,Event_Details;

    @Override

        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);
        mMainNav = (BottomNavigationView) findViewById(R.id.main_nav);


        events = new ArrayList<Event>();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference("Events");

//how intents pass data n pass event id.
        //YK: Read from the database
        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                Event findEvent = dataSnapshot.getValue(Event.class);
                String EventName = findEvent.eventName;
                String EventLocation = findEvent.eventLocation;
                String EventDate = findEvent.eventDate;
                String EventTime = findEvent.eventTime;
                String EventDescription = findEvent.eventDescription;
                String EventCreator = findEvent.eventCreator;
                Integer EventCap = findEvent.eventCap;
                String EventTag = findEvent.eventInterest;

                recyclerView = findViewById(R.id.Feed_RecyclerView); //Link recyclerview variable to xml
                FeedRecyclerViewAdapter adapter = new FeedRecyclerViewAdapter(events, FeedActivity.this); //Linking the adapter to recyclerView,
                //check out the RecyclerViewAdapter (this is the hard part)
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(FeedActivity.this)); //Setting the layout manager, commonly used is linear


                Event e = new Event(EventName, EventLocation, EventDate, EventTime, EventDescription, EventCreator, EventCap, EventTag);

                events.add(e);
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });







        mMainNav.setOnNavigationItemSelectedListener(this);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        if (menuItem.getItemId() == R.id.home_nav) {

            Intent landingsIntent = new Intent(FeedActivity.this, FeedActivity.class);
            startActivity(landingsIntent);
            return true;

        } else if (menuItem.getItemId() == R.id.profile_nav) {

            Intent profileIntent = new Intent(FeedActivity.this, ProfileInfoActivity.class);
            startActivity(profileIntent);
            return true;

        } else if (menuItem.getItemId() == R.id.create_nav) {

            Intent chatIntent = new Intent(FeedActivity.this, CreateEventActivity.class);
            startActivity(chatIntent);
            return true;
        }
        return true;
    }
}
