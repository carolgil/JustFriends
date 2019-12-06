package com.example.justfriends;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CreateEventActivity extends AppCompatActivity implements View.OnClickListener, BottomNavigationView.OnNavigationItemSelectedListener, AdapterView.OnItemSelectedListener {
    EditText editTextCreateEventName, editTextCreateEventLocation, editTextCreateEventDate, editTextCreateEventTime,
            editTextCreateEventDescription, editTextCreateEventCap;
    Button buttonCreateEventCreate;
    Spinner spinnerEventTag;

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
        spinnerEventTag = findViewById(R.id.spinnerEventTag);

        //Read button + set listener
        buttonCreateEventCreate = findViewById(R.id.buttonCreateEventCreate);
        buttonCreateEventCreate.setOnClickListener(this);
        mMainNav.setOnNavigationItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.interests_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerEventTag.setAdapter(adapter);


    }

    @Override
    public void onClick(View view) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef2 = database.getReference("Events");

        if (view == buttonCreateEventCreate) {
            String creator = FirebaseAuth.getInstance().getCurrentUser().getEmail();
            String name = editTextCreateEventName.getText().toString();
            String location = editTextCreateEventLocation.getText().toString();
            String date = editTextCreateEventDate.getText().toString();
            String time = editTextCreateEventTime.getText().toString();
            String description = editTextCreateEventDescription.getText().toString();
            int cap = Integer.parseInt(editTextCreateEventCap.getText().toString());

            Event myEvent  = new Event(name, location, date, time, description, creator, cap);
            myRef2.push().setValue(myEvent);

            Intent feedIntent = new Intent(CreateEventActivity.this, FeedActivity.class);
            startActivity(feedIntent);
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.home_nav) {
            Intent landingsIntent = new Intent(CreateEventActivity.this, FeedActivity.class);
            startActivity(landingsIntent);
        } else if (menuItem.getItemId() == R.id.profile_nav) {

            Toast.makeText(this, "Profile", Toast.LENGTH_SHORT).show();
            Intent profileIntent = new Intent(CreateEventActivity.this, ProfileInfoActivity.class);
            startActivity(profileIntent);
        } else if (menuItem.getItemId() == R.id.create_nav) {
            Toast.makeText(this, "Create", Toast.LENGTH_SHORT).show();
            Intent chatIntent = new Intent(CreateEventActivity.this, CreateEventActivity.class);
            startActivity(chatIntent);
        }
        return false;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
