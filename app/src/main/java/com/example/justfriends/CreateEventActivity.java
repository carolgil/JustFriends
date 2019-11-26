package com.example.justfriends;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CreateEventActivity extends AppCompatActivity implements View.OnClickListener{
    EditText editTextCreateEventName, editTextCreateEventLocation, editTextCreateEventDate, editTextCreateEventTime,
            editTextCreateEventDescription, editTextCreateEventCap;
    Button buttonCreateEventCreate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);


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


    }

    @Override
    public void onClick(View view) {

    }
}
