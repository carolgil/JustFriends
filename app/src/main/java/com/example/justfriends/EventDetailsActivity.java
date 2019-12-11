package com.example.justfriends;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Switch;
import android.widget.TextView;

public class EventDetailsActivity extends AppCompatActivity implements View.OnClickListener{

    TextView textViewEDEventName, textViewEDDate, textViewEDTime, textViewEDLocation, textViewEDDetails, textViewEDDetailsBox, textViewEDInterest1, textViewEDEventCreator, textViewEDInterest3;
    Switch switchEDGoing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);



        //Initializing TextView
        textViewEDEventName = findViewById(R.id.textViewEDEventName);
        textViewEDDate = findViewById(R.id.textViewEDDate);
        textViewEDTime = findViewById(R.id.textViewEDTime);
        textViewEDLocation = findViewById(R.id.textViewEDLocation);
        textViewEDDetails = findViewById(R.id.textViewEDDetails);
        textViewEDDetailsBox = findViewById(R.id.textViewEDDetailsBox);
        textViewEDInterest1 = findViewById(R.id.textViewEDInterest1);
        textViewEDInterest3 = findViewById(R.id.textViewEDInterest3);
        textViewEDEventCreator = findViewById(R.id.textViewEDEventCreator);

        textViewEDEventCreator.setText(getIntent().getExtras().getString ("event creator"));
        textViewEDEventName.setText(getIntent().getExtras().getString("event name"));
        textViewEDDate.setText(getIntent().getExtras().getString("event date"));
        textViewEDInterest1.setText(getIntent().getExtras().getString("event tag"));
        textViewEDLocation.setText(getIntent().getExtras().getString("event location"));
        textViewEDTime.setText(getIntent().getExtras().getString("event time"));
        textViewEDDetailsBox.setText(getIntent().getExtras().getString("event details"));

        //Initializing Check Box
        textViewEDEventCreator.setOnClickListener(this);

    }
    //event created by + should be clickable


    @Override
    public void onClick(View view) {
        if (view == textViewEDEventCreator) {
            //Context context = view.getContext();
            //String eventName = events.get(position).eventName;
            //String eventTime = events.get(position).eventTime;
            //String eventLocation = events.get(position).eventLocation;
            //String eventTag = events.get(position).eventInterest;
            //String eventDate = events.get(position).eventDate;
            //String eventDetails = events.get(position).eventDescription;


            //Intent intent = new Intent(context, EventDetailsActivity.class);
            //intent.putExtra("event name",eventName);
            // intent.putExtra("event time",eventTime);
//            intent.putExtra("event date",eventDate);
//            intent.putExtra("event location",eventLocation);
//            intent.putExtra("event tag",eventTag);
//            intent.putExtra("event details", eventDetails);
//            context.startActivity(intent);
        }
    }

    }



