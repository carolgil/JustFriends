package com.example.justfriends;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.textclassifier.TextClassification;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Event_DetailActivity extends AppCompatActivity implements ValueEventListener {

    TextView Detail_Title, Detail_Name, Detail_Location, Detail_Date, Detail_Time,
            Detail_Description, Detail_Tag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event__detail);

        Detail_Date = findViewById(R.id.Detail_Date);
        Detail_Title = findViewById(R.id.Detail_Title);
        Detail_Name = findViewById(R.id.Detail_Name);
        Detail_Location = findViewById(R.id.Detail_Location);
        Detail_Time = findViewById(R.id.Detail_Time);
        Detail_Description = findViewById(R.id.Detail_Description);
        Detail_Tag = findViewById(R.id.Detail_Tag);


    }

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef2 = database.getReference("Events");

    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {

    }
}