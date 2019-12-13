package com.example.justfriends;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;


public class OtherProfileActivity extends AppCompatActivity {

    TextView textViewOPFillName, textViewOPFillAge, textViewOPFillGender, textViewOPFillEducation,
            textViewOPEmail;
    TextView textViewOPFillHometown, textViewOPFillOccupation, textViewOPFillInterest1,
            textViewOPFillInterest2, textViewEnterEmail;



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
        textViewEnterEmail = findViewById(R.id.textViewEnterEmail);

        textViewEnterEmail.setText(getIntent().getExtras().getString("name"));

        String userEmail = textViewEnterEmail.getText().toString();

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference("Users");

        myRef.orderByChild("email").equalTo(userEmail).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                User findUser = dataSnapshot.getValue(User.class);
                String userGender = findUser.gender;
                Integer userAge = findUser.age;
                String userEducation = findUser.education;
                String userHometown = findUser.hometown;
                String userOccupation = findUser.occupation;
                String userInterest1 = findUser.interest1;
                String userInterest2 = findUser.interest2;
                String username = findUser.name;

                textViewOPFillAge.setText(String.valueOf(userAge));
                textViewOPFillEducation.setText(userEducation);
                textViewOPFillGender.setText(userGender);
                textViewOPFillHometown.setText(userHometown);
                textViewOPFillInterest1.setText(userInterest1);
                textViewOPFillInterest2.setText(userInterest2);
                textViewOPFillOccupation.setText(userOccupation);
                textViewOPFillName.setText(username);

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



    }
}
