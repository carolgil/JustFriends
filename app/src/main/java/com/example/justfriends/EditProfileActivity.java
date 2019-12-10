package com.example.justfriends;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class EditProfileActivity extends AppCompatActivity implements View.OnClickListener {

    TextView textViewEPName, textViewEPAge, textViewEPGender, textViewEPHometown, textViewEPOccupation, textViewEPInterests;
    EditText editTextEPName, editTextEPAge, editTextEPEducation, editTextEPHometown, editTextEPOccupation;
    Button buttonUpdateProfile;
    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        textViewEPName = findViewById(R.id.textViewEPName);
        textViewEPAge = findViewById(R.id.textViewEPAge);
        textViewEPGender = findViewById(R.id.textViewEPGender);
        textViewEPHometown = findViewById(R.id.textViewEPHometown);
        textViewEPOccupation = findViewById(R.id.textViewEPOccupation);
        textViewEPInterests = findViewById(R.id.textViewEPInterests);

        editTextEPName = findViewById(R.id.editTextEPName);
        editTextEPAge = findViewById(R.id.editTextEPAge);
        editTextEPEducation = findViewById(R.id.editTextEPEducation);
        editTextEPHometown = findViewById(R.id.editTextEPHometown);
        editTextEPOccupation = findViewById(R.id.editTextEPOccupation);
        buttonUpdateProfile = findViewById(R.id.buttonUpdateProfile);

        user = mAuth.getCurrentUser();
        String userID = user.getEmail().toString();


        buttonUpdateProfile.setOnClickListener(this);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Users");



        myRef.orderByChild("email").equalTo(userID).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                String findkey = dataSnapshot.getKey();
                User foundUser = dataSnapshot.getValue(User.class);
                String user_name = foundUser.name;
                int user_age = foundUser.age;
                String user_education = foundUser.education;
                String user_hometown = foundUser.hometown;
                String user_occupation = foundUser.occupation;

                editTextEPName.setText(user_name);
                editTextEPAge.setText(String.valueOf(user_age));
                editTextEPEducation.setText(user_education);
                editTextEPHometown.setText(user_hometown);
                editTextEPOccupation.setText(user_occupation);


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

    @Override
    public void onClick(View v) {

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference("Users");

        if(v == buttonUpdateProfile){

            final FirebaseUser user_info = mAuth.getCurrentUser();
            String current_user = user_info.getEmail().toString();

            myRef.orderByChild("email").equalTo(current_user).addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                    String edit_key = dataSnapshot.getKey();
                    User foundUser = dataSnapshot.getValue(User.class);
                    String user_name = editTextEPName.getText().toString();
                    int user_age = Integer.parseInt(editTextEPAge.getText().toString());
                    String user_education = editTextEPEducation.getText().toString();
                    String user_hometown = editTextEPHometown.getText().toString();
                    String user_occupation = editTextEPOccupation.getText().toString();

                    myRef.child(edit_key).child("email").setValue(user_name);
                    myRef.child(edit_key).child("age").setValue(String.valueOf(user_age));
                    myRef.child(edit_key).child("education").setValue(user_education);
                    myRef.child(edit_key).child("hometown").setValue(user_hometown);
                    myRef.child(edit_key).child("occupation").setValue(user_occupation);

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
}
