package com.example.justfriends;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ProfileInfoActivity extends AppCompatActivity implements View.OnClickListener, BottomNavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView mMainNav;

    TextView textViewInterestPI, textViewEducationPI, textViewOccupationPI, textViewGenderPI, textViewEducationPIOutput, textViewOccupationPIOutput, textViewAgePIOutput, textViewNamePIOutput, textViewGenderPIOutput;
    Button buttonEventsPI, buttonEditProfilePI, buttonInfoPI, buttonSignoutPI;
    ImageView imageViewProfilePI;
    ImageButton imageButtonFavoritesPI;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_info);

        mMainNav = (BottomNavigationView) findViewById(R.id.main_nav);


        mMainNav.setOnNavigationItemSelectedListener(this);

        textViewEducationPIOutput = findViewById(R.id.textViewEducationPIOutput);
        textViewOccupationPIOutput = findViewById(R.id.textViewOccupationPIOutput);
        textViewAgePIOutput = findViewById(R.id.textViewAgePIOutput);
        textViewNamePIOutput = findViewById(R.id.textViewNamePIOutput);
        textViewGenderPIOutput = findViewById(R.id.textViewGenderPIOutput);

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
            return true;

        } else if (menuItem.getItemId() == R.id.profile_nav) {

            Intent profileIntent = new Intent(ProfileInfoActivity.this, ProfileInfoActivity.class);
            startActivity(profileIntent);
            return true;

        } else if (menuItem.getItemId() == R.id.create_nav) {
            Intent chatIntent = new Intent(ProfileInfoActivity.this, CreateEventActivity.class);
            startActivity(chatIntent);
            return true;

        }
        return true;
    }

    @Override
    public void onClick(View view) {

        //Making the buttons work

        if (view == buttonSignoutPI) {
            Intent logoutIntent = new Intent(this, MainActivity.class);
            startActivity(logoutIntent);
        }

        if (view == buttonEventsPI) {
            Intent eventIntent = new Intent(this, ProfileEventsActivity.class);
            startActivity(eventIntent);
        }

        if (view == buttonInfoPI) {
            Toast.makeText(this, "You are already on the info page!", Toast.LENGTH_SHORT).show();

        }





    }
}
