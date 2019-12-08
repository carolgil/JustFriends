package com.example.justfriends;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
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

public class ProfileEventsActivity extends AppCompatActivity {

    Button buttonEventsPE, buttonInfoPE, buttonEditProfilePE, buttonSignoutPE;
    TextView textViewNamePEOutput;

    private ArrayList<Event> Events;
    private RecyclerView recycler_view; //recycler view variable
    private RecyclerView.LayoutManager layoutManager; //layout manager for recycler view, need this for a recyclerview

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_events);

        buttonEventsPE = findViewById(R.id.buttonEventsPE);
        buttonInfoPE = findViewById(R.id.buttonInfoPE);
        buttonEditProfilePE = findViewById(R.id.buttonSignoutPE);
        textViewNamePEOutput = findViewById(R.id.textViewNamePEOutput);

        Events = new ArrayList<Event>();
        Event e = new Event("name", "location", "Dec 12", "time", "descr", "email", 26);
        Events.add(e);

//        FirebaseDatabase database = FirebaseDatabase.getInstance();
//        final DatabaseReference myRef = database.getReference("Events");
//
//        //YK: Pulling user email
//        String userEmail = FirebaseAuth.getInstance().getCurrentUser().getEmail();
//
//        //YK: Read from the database
//
//        myRef.orderByChild("email").equalTo(userEmail).addChildEventListener(new ChildEventListener() {
//
//            @Override
//            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//
//                Event findEvent = dataSnapshot.getValue(Event.class);
//                String userGender = findUser.gender;
//                String userName = findUser.name;
//                Integer userAge = findUser.age;
//                String userEducation = findUser.education;
//                String userHometown = findUser.hometown;
//                String userOccupation = findUser.occupation;
//                String userInterest1 = findUser.interest1;
//                String userInterest2 = findUser.interest2;
//                Event e =
//                Events.add(Event())
//
//
//            }
//
//            @Override
//            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//
//            }
//
//            @Override
//            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
//
//            }
//
//            @Override
//            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//
//
//        });



//        String eventName, String eventLocation, String eventDate, String eventTime, String eventDescription, String eventCreator, int eventCap
        recycler_view = findViewById(R.id.recycler_view); //Link recyclerview variable to xml
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(Events, this); //Linking the adapter to recyclerView,
        //check out the RecyclerViewAdapter (this is the hard part)
        recycler_view.setAdapter(adapter);
        recycler_view.setLayoutManager(new LinearLayoutManager(this)); //Setting the layout manager, commonly used is linear
    }
}