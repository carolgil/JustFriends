package com.example.justfriends;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class ProfileEventsActivity extends AppCompatActivity implements View.OnClickListener {

    Button buttonEventsPE, buttonInfoPE, buttonEditProfilePE, buttonSignoutPE;

    private ArrayList<Event> Events;
    private RecyclerView recycler_view; //recycler view variable
    private RecyclerView.LayoutManager layoutManager; //layout manager for recycler view, need this for a recyclerview

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_events);

        buttonEventsPE = findViewById(R.id.buttonEventsPE);
        buttonInfoPE = findViewById(R.id.buttonInfoPE);
        buttonEditProfilePE = findViewById(R.id.buttonEditProfilePE);
        buttonSignoutPE = findViewById(R.id.buttonSignoutPE);

        buttonEventsPE.setOnClickListener(this);
        buttonInfoPE.setOnClickListener(this);
        buttonEditProfilePE.setOnClickListener(this);
        buttonSignoutPE.setOnClickListener(this);

        Events = new ArrayList<Event>();
//        Event e = new Event("name", "location", "Dec 12", "time", "descr", "email", 26);
//        Events.add(e);


        //YK: Pulling all the info + Reading from the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference("Events");

        //YK: Pulling user email
        String userEmail = FirebaseAuth.getInstance().getCurrentUser().getEmail();

        //YK: Read from the database
        myRef.orderByChild("eventCreator").equalTo(userEmail).addChildEventListener(new ChildEventListener() {

            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                Event findEvent = dataSnapshot.getValue(Event.class);
                String eventName = findEvent.eventName;
                Toast.makeText(ProfileEventsActivity.this, eventName, Toast.LENGTH_SHORT).show();
                String eventLocation = findEvent.eventLocation;
                String eventDate = findEvent.eventDate;
                String eventTime = findEvent.eventTime;
                String eventDescription = findEvent.eventDescription;
                String eventCreator = findEvent.eventCreator;
                Integer eventCap = findEvent.eventCap;

                Event e = new Event(eventName, eventLocation, eventDate, eventTime, eventDescription, eventCreator, eventCap);

                Events.add(e);
                Toast.makeText(ProfileEventsActivity.this, Events.get(0).eventName, Toast.LENGTH_SHORT).show();

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


        recycler_view = findViewById(R.id.recycler_view); //Link recyclerview variable to xml
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(Events, this); //Linking the adapter to recyclerView,
        //check out the RecyclerViewAdapter (this is the hard part)
        recycler_view.setAdapter(adapter);
        recycler_view.setLayoutManager(new LinearLayoutManager(this)); //Setting the layout manager, commonly used is linear
    }

    @Override
    public void onClick(View view) {
        //Making the buttons work

        if (view == buttonSignoutPE) {
            Intent logoutIntent = new Intent(this, MainActivity.class);
            startActivity(logoutIntent);
        }

        if (view == buttonInfoPE) {
            Intent infoIntent = new Intent(this, ProfileInfoActivity.class);
            startActivity(infoIntent);
        }

        if (view == buttonEventsPE) {
            Toast.makeText(this, "You are already on the events page!", Toast.LENGTH_SHORT).show();

        }
    }
}