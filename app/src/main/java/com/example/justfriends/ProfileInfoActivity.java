package com.example.justfriends;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ProfileInfoActivity extends AppCompatActivity implements View.OnClickListener, BottomNavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView mMainNav;


    EditText editTextEducationPI, editTextOccupationPI, editTextAgePI,editTextNamePI, editTextGenderPI;
    TextView textViewInterestPI, textViewEducationPI, textViewOccupationPI, textViewGenderPI;
    Button buttonEventsPI, buttonEditProfilePI, buttonInfoPI, buttonSignoutPI;
    ImageView imageViewProfilePI;
    ImageButton imageButtonFavoritesPI;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_info);
        mMainNav = (BottomNavigationView) findViewById(R.id.main_nav);


        mMainNav.setOnNavigationItemSelectedListener(this);

        editTextEducationPI = findViewById(R.id.editTextEducationPI);
        editTextOccupationPI = findViewById(R.id.editTextOccupationPI);
        editTextAgePI = findViewById(R.id.editTextAgePI);
        editTextNamePI = findViewById(R.id.editTextNamePI);
        editTextGenderPI = findViewById(R.id.editTextGenderPI);

        textViewInterestPI = findViewById(R.id.textViewInterestsPI);
        textViewEducationPI = findViewById(R.id.textViewEducationPI);
        textViewOccupationPI = findViewById(R.id.textViewOccupationPI);
        textViewGenderPI = findViewById(R.id.textViewGenderPI);

        buttonEventsPI = findViewById(R.id.buttonEventsPI);
        buttonEditProfilePI = findViewById(R.id.buttonEditProfilePI);
        buttonInfoPI = findViewById(R.id.buttonInfoPI);
        buttonSignoutPI = findViewById(R.id.buttonSignoutPI);

        // buttonEventsPI.setOnClickListener();
        // buttonEditProfilePI.setOnClickListener();
        // buttonInfoPI.setOnClickListener();
        // buttonSignoutPI.setOnClickListener();

        imageViewProfilePI = findViewById(R.id.imageViewProfilePI);

        imageButtonFavoritesPI = findViewById(R.id.imageButtonFavoritesPI);


        //Set Listener
        buttonEventsPI.setOnClickListener(this);
        buttonEditProfilePI.setOnClickListener(this);
        buttonInfoPI.setOnClickListener(this);
        buttonSignoutPI.setOnClickListener(this);


    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.home_nav) {
            Intent landingsIntent = new Intent(ProfileInfoActivity.this, FeedActivity.class);
            startActivity(landingsIntent);
        } else if (menuItem.getItemId() == R.id.profile_nav) {

            Toast.makeText(this, "Profile", Toast.LENGTH_SHORT).show();
            Intent profileIntent = new Intent(ProfileInfoActivity.this, ProfileEventsActivity.class);
            startActivity(profileIntent);
        } else if (menuItem.getItemId() == R.id.chat_nav) {
            Toast.makeText(this, "Chat", Toast.LENGTH_SHORT).show();
            Intent chatIntent = new Intent(ProfileInfoActivity.this, ChatActivity.class);
            startActivity(chatIntent);
        }
        return false;
    }

    @Override
    public void onClick(View view) {

    }
}
