package com.example.justfriends;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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

public class ProfileEventsActivity extends AppCompatActivity {


    TextView textViewUpcomingEventsPE, textViewPastEventsPE,textViewNamePEOutput;

    Button buttonEventsPE, buttonInfoPE, buttonSignoutPE;

    ImageButton imageButtonFavoritesPE;

    ImageView imageViewProfilePE;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_events);

        textViewNamePEOutput = findViewById(R.id.textViewNamePEOutput);

        textViewPastEventsPE = findViewById(R.id.textViewPastEventsPE);
        textViewUpcomingEventsPE = findViewById(R.id.textViewUpcomingEventsPE);

        buttonEventsPE = findViewById(R.id.buttonEventsPE);
        buttonInfoPE = findViewById(R.id.buttonInfoPE);
        buttonSignoutPE = findViewById(R.id.buttonSignoutPE);

        imageButtonFavoritesPE = findViewById(R.id.imageButtonFavoritesPE);
        

    }
}