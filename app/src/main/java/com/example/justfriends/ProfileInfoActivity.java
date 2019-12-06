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

public class ProfileInfoActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    private BottomNavigationView mMainNav;


    TextView textViewInterestPI, textViewEducationPI, textViewOccupationPI,
            textViewGenderPI, textViewEducationPIOutput, textViewOccupationPIOutput,
            textViewAgePIOutput,textViewNamePIOutput, textViewGenderPIOutput;
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
        textViewNamePIOutput = findViewById(R.id.textViewNamePI);
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

        imageViewProfilePI = findViewById(R.id.imageViewProfilePI);

        imageButtonFavoritesPI = findViewById(R.id.imageButtonFavoritesPI);


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
}
