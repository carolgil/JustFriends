package com.example.justfriends;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class FeedActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener,View.OnClickListener {

    private BottomNavigationView mMainNav;
    private FrameLayout mMainFrame;


    TextView View_Feed_Name, View_Feed_Date, View_Feed_Time,View_Feed_Location,
            View_Feed_Att, View_Event_Filter;
    Button Event_Button_Favourite,Event_Details;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);
        mMainNav = (BottomNavigationView) findViewById(R.id.main_nav);
        View_Feed_Att = findViewById(R.id.View_Feed_Att);
        View_Feed_Name = findViewById(R.id.View_Feed_Name);
        View_Feed_Date = findViewById(R.id.View_Feed_Date);
        View_Feed_Time = findViewById(R.id.View_Feed_Time);
        View_Feed_Location = findViewById(R.id.View_Feed_Location);
        Event_Button_Favourite = findViewById(R.id.Event_Button_Favourite);
        Event_Details = findViewById(R.id.Event_Details);
        View_Event_Filter = findViewById(R.id.View_Event_Filter);


        Event_Button_Favourite.setOnClickListener(this);
        Event_Details.setOnClickListener(this);


        mMainNav.setOnNavigationItemSelectedListener(this);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        if (menuItem.getItemId() == R.id.home_nav) {

            Intent landingsIntent = new Intent(FeedActivity.this, FeedActivity.class);
            startActivity(landingsIntent);
            return true;

        } else if (menuItem.getItemId() == R.id.profile_nav) {

            Intent profileIntent = new Intent(FeedActivity.this, ProfileInfoActivity.class);
            startActivity(profileIntent);
            return true;

        } else if (menuItem.getItemId() == R.id.create_nav) {

            Intent chatIntent = new Intent(FeedActivity.this, CreateEventActivity.class);
            startActivity(chatIntent);
            return true;
        }
        return true;
    }

    @Override
    public void onClick(View view) {
        if (Event_Details == view){
            Intent chatIntent = new Intent(FeedActivity.this, Event_DetailActivity.class);
            startActivity(chatIntent);
        }

    }
}
