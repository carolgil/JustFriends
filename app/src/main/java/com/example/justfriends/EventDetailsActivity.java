package com.example.justfriends;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.Switch;
import android.widget.TextView;

public class EventDetailsActivity extends AppCompatActivity {

    TextView textViewEDEventName, textViewEDDate, textViewEDTime, textViewEDLocation, textViewEDDetails, textViewEDDetailsBox, textViewEDNumGoing, textViewEDInterests, textViewEDInterest1, textViewEDInterest2, textViewEDInterest3;
    CheckBox checkBoxEDFavorite;
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
        textViewEDNumGoing = findViewById(R.id.textViewEDNumGoing);
        textViewEDInterest1 = findViewById(R.id.textViewEDInterest1);
        textViewEDInterest3 = findViewById(R.id.textViewEDInterest3);

        textViewEDEventName.setText(getIntent().getExtras().getString("event name"));
        textViewEDDate.setText(getIntent().getExtras().getString("event date"));
        textViewEDInterest1.setText(getIntent().getExtras().getString("event tag"));
        textViewEDLocation.setText(getIntent().getExtras().getString("event location"));
        textViewEDTime.setText(getIntent().getExtras().getString("event time"));

        //Initializing Check Box
        checkBoxEDFavorite = findViewById(R.id.checkBoxEDFavorite);


    }
    

}
