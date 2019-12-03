package com.example.justfriends;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class FeedActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView mMainNav;
    private FrameLayout mMainFrame;
    TextView View_Feed_Name, View_Feed_Date, View_Feed_Time,View_Feed_Location,
            View_Feed_Att, View_Feed_Tag1, View_Feed_Tag2, View_Feed_Tag3;
    Button Feed_Favourite;

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

        mMainNav.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.home_nav) {
            Intent landingsIntent = new Intent(FeedActivity.this, FeedActivity.class);
            startActivity(landingsIntent);
        } else if (menuItem.getItemId() == R.id.profile_nav) {

            Toast.makeText(this, "Profile", Toast.LENGTH_SHORT).show();
            Intent profileIntent = new Intent(FeedActivity.this, ProfileEventsActivity.class);
            startActivity(profileIntent);
        } else if (menuItem.getItemId() == R.id.chat_nav) {
            Toast.makeText(this, "Chat", Toast.LENGTH_SHORT).show();
            Intent chatIntent = new Intent(FeedActivity.this, ChatActivity.class);
            startActivity(chatIntent);
        }
        return false;
    }
}
