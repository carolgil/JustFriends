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

public class ProfileEventsActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    private BottomNavigationView mMainNav;

    EditText editTextNamePE;

    TextView textViewUpcomingEventsPE, textViewPastEventsPE;

    Button buttonEventsPE, buttonInfoPE, buttonSignoutPE;

    ImageButton imageButtonFavoritesPE;

    ImageView imageViewProfilePE;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_events);
        mMainNav = (BottomNavigationView) findViewById(R.id.main_nav);

        editTextNamePE = findViewById(R.id.editTextNamePE);

        textViewPastEventsPE = findViewById(R.id.textViewPastEventsPE);
        textViewUpcomingEventsPE = findViewById(R.id.textViewUpcomingEventsPE);

        buttonEventsPE = findViewById(R.id.buttonEventsPE);
        buttonInfoPE = findViewById(R.id.buttonInfoPE);
        buttonSignoutPE = findViewById(R.id.buttonSignoutPE);

        imageButtonFavoritesPE = findViewById(R.id.imageButtonFavoritesPE);

        imageViewProfilePE = findViewById(R.id.imageViewProfilePE);



    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.home_nav) {
            Intent landingsIntent = new Intent(ProfileEventsActivity.this, FeedActivity.class);
            startActivity(landingsIntent);
        } else if (menuItem.getItemId() == R.id.profile_nav) {

            Toast.makeText(this, "Profile", Toast.LENGTH_SHORT).show();
            Intent profileIntent = new Intent(ProfileEventsActivity.this, ProfileInfoActivity.class);
            startActivity(profileIntent);
        } else if (menuItem.getItemId() == R.id.create_nav) {
            Toast.makeText(this, "Chat", Toast.LENGTH_SHORT).show();
            Intent chatIntent = new Intent(ProfileEventsActivity.this, ChatActivity.class);
            startActivity(chatIntent);
        }
        return false;
    }
}
