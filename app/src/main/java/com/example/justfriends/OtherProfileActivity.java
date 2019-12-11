package com.example.justfriends;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class OtherProfileActivity extends AppCompatActivity {

    TextView textViewOPFillName, textViewOPFillAge, textViewOPFillGender, textViewOPFillEducation;
    TextView textViewOPFillHometown, textViewOPFillOccupation, textViewOPFillInterest1, textViewOPFillInterest2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_profile);

        textViewOPFillName = findViewById(R.id.textViewOPFillName);
        textViewOPFillAge = findViewById(R.id.textViewOPFillAge);
        textViewOPFillGender = findViewById(R.id.textViewOPFillGender);
        textViewOPFillEducation = findViewById(R.id.textViewOPFillEducation);
        textViewOPFillHometown = findViewById(R.id.textViewOPFillHometown);
        textViewOPFillOccupation = findViewById(R.id.textViewOPFillOccupation);
        textViewOPFillInterest1 = findViewById(R.id.textViewOPFillInterest1);
        textViewOPFillInterest2 = findViewById(R.id.textViewOPFillInterest2);

    }
}
