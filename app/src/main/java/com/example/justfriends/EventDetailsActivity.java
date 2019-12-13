package com.example.justfriends;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Switch;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class EventDetailsActivity extends AppCompatActivity implements View.OnClickListener, BottomNavigationView.OnNavigationItemSelectedListener {

    TextView textViewEDEventCreator, textViewEDEventName, textViewEDDate, textViewEDTime, textViewEDLocation, textViewEDDetails, textViewEDDetailsBox, textViewEDInterest1;
    Switch switchEDGoing;
    private BottomNavigationView mMainNav;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);
        mMainNav = (BottomNavigationView) findViewById(R.id.main_nav);
        mMainNav.setOnNavigationItemSelectedListener(this);


        //Initializing TextView
        textViewEDEventName = findViewById(R.id.textViewEDEventName);
        textViewEDDate = findViewById(R.id.textViewEDDate);
        textViewEDTime = findViewById(R.id.textViewEDTime);
        textViewEDLocation = findViewById(R.id.textViewEDLocation);
        textViewEDDetails = findViewById(R.id.textViewEDDetails);
        textViewEDDetailsBox = findViewById(R.id.textViewEDDetailsBox);
        textViewEDInterest1 = findViewById(R.id.textViewEDInterest1);
        textViewEDEventCreator = findViewById(R.id.textViewEDEventCreator);

        textViewEDEventCreator.setOnClickListener(this);

        textViewEDEventName.setText(getIntent().getExtras().getString("event name"));
        textViewEDDate.setText(getIntent().getExtras().getString("event date"));
        textViewEDInterest1.setText(getIntent().getExtras().getString("event tag"));
        textViewEDLocation.setText(getIntent().getExtras().getString("event location"));
        textViewEDTime.setText(getIntent().getExtras().getString("event time"));
        textViewEDDetailsBox.setText(getIntent().getExtras().getString("event details"));
        textViewEDEventCreator.setText(getIntent().getExtras().getString("event creator"));

        //Initializing Check Box

        //event created by + should be clickable

    }



        @Override
    public void onClick(View view) {
        if (view == textViewEDEventCreator){
            String creatorName = textViewEDEventCreator.getText().toString();
            Context context = view.getContext();

            Intent otherIntent = new Intent(EventDetailsActivity.this, OtherProfileActivity.class);
            otherIntent.putExtra("name", creatorName);
            context.startActivity(otherIntent);
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.home_nav) {

            Intent landingsIntent = new Intent(EventDetailsActivity.this, FeedActivity.class);
            startActivity(landingsIntent);
            return true;

        } else if (menuItem.getItemId() == R.id.profile_nav) {

            Intent profileIntent = new Intent(EventDetailsActivity.this, ProfileInfoActivity.class);
            startActivity(profileIntent);
            return true;

        } else if (menuItem.getItemId() == R.id.create_nav) {

            Intent chatIntent = new Intent(EventDetailsActivity.this, CreateEventActivity.class);
            startActivity(chatIntent);
            return true;
        }
        return true;
    }
}
