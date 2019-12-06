package com.example.justfriends;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class CreateEventActivity extends AppCompatActivity implements View.OnClickListener, BottomNavigationView.OnNavigationItemSelectedListener {
    EditText editTextCreateEventName, editTextCreateEventLocation, editTextCreateEventDate, editTextCreateEventTime,
            editTextCreateEventDescription, editTextCreateEventCap;
    Button buttonCreateEventCreate;
    private BottomNavigationView mMainNav;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);

        mMainNav = (BottomNavigationView) findViewById(R.id.main_nav);

        // Read editText
        editTextCreateEventName = findViewById(R.id.editTextCreateEventName);
        editTextCreateEventLocation = findViewById(R.id.editTextCreateEventLocation);
        editTextCreateEventDate = findViewById(R.id.editTextCreateEventDate);
        editTextCreateEventTime = findViewById(R.id.editTextCreateEventTime);
        editTextCreateEventDescription = findViewById(R.id.editTextCreateEventDescription);
        editTextCreateEventCap = findViewById(R.id.editTextCreateEventCap);

        //Read button + set listener
        buttonCreateEventCreate = findViewById(R.id.buttonCreateEventCreate);

        buttonCreateEventCreate.setOnClickListener(this);

        mMainNav.setOnNavigationItemSelectedListener(this);


    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.home_nav) {
            Intent landingsIntent = new Intent(CreateEventActivity.this, FeedActivity.class);
            startActivity(landingsIntent);
        } else if (menuItem.getItemId() == R.id.profile_nav) {

            Toast.makeText(this, "Profile", Toast.LENGTH_SHORT).show();
            Intent profileIntent = new Intent(CreateEventActivity.this, ProfileEventsActivity.class);
            startActivity(profileIntent);
        } else if (menuItem.getItemId() == R.id.create_nav) {
            Toast.makeText(this, "Create", Toast.LENGTH_SHORT).show();
            Intent chatIntent = new Intent(CreateEventActivity.this, CreateEventActivity.class);
            startActivity(chatIntent);
        }
        return false;
    }
}
