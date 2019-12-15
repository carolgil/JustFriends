package com.example.justfriends;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class EditProfileActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    TextView textViewEPName, textViewEPAge, textViewEPGender, textViewEPHometown, textViewEPOccupation, textViewEPInterests;
    EditText editTextEPName, editTextEPAge, editTextEPEducation, editTextEPHometown, editTextEPOccupation;
    Button buttonUpdateProfile;
    Spinner spinnerEPInterest1, spinnerEPInterest2, spinnerEPGender;
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
        spinnerEPGender = findViewById(R.id.spinnerEPGender);
        spinnerEPInterest1 = findViewById(R.id.spinnerEPInterest1);
        spinnerEPInterest2 = findViewById(R.id.spinnerEPInterest2);

        buttonUpdateProfile.setOnClickListener(this);
        spinnerEPGender.setOnItemSelectedListener(this);
        spinnerEPInterest1.setOnItemSelectedListener(this);
        spinnerEPInterest2.setOnItemSelectedListener(this);


        ArrayAdapter<CharSequence> gender_adapter = ArrayAdapter.createFromResource(this,
                R.array.gender_array, android.R.layout.simple_spinner_item);
        gender_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerEPGender.setAdapter(gender_adapter);

        ArrayAdapter<CharSequence> interest_adapter1 = ArrayAdapter.createFromResource(this,
                R.array.interests_array, android.R.layout.simple_spinner_item);
        interest_adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerEPInterest1.setAdapter(interest_adapter1);

        ArrayAdapter<CharSequence> interest_adapter2 = ArrayAdapter.createFromResource(this,
                R.array.interests_array, android.R.layout.simple_spinner_item);
        interest_adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerEPInterest2.setAdapter(interest_adapter2);


        user = mAuth.getCurrentUser();
        String userID = user.getEmail().toString();

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Users");

        myRef.orderByChild("email").equalTo(userID).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                User foundUser = dataSnapshot.getValue(User.class);
                String user_name = foundUser.name;
                int user_age = foundUser.age;
//                String user_gender = foundUser.gender;
                String user_education = foundUser.education;
                String user_hometown = foundUser.hometown;
                String user_occupation = foundUser.occupation;
//                String user_interest1 = foundUser.interest1;
//                String user_interest2 = foundUser.interest2;

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

            FirebaseUser user_info = mAuth.getCurrentUser();
            String current_user = user_info.getEmail();

            myRef.orderByChild("email").equalTo(current_user).addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                    String edit_key = dataSnapshot.getKey();
                    String user_name = editTextEPName.getText().toString();
                    int user_age = Integer.parseInt(editTextEPAge.getText().toString());
                    String user_gender = spinnerEPGender.getSelectedItem().toString();
                    String user_education = editTextEPEducation.getText().toString();
                    String user_hometown = editTextEPHometown.getText().toString();
                    String user_occupation = editTextEPOccupation.getText().toString();
                    String user_interest1 = spinnerEPInterest1.getSelectedItem().toString();
                    String user_interest2 = spinnerEPInterest2.getSelectedItem().toString();

                    Toast.makeText(EditProfileActivity.this, "Profile Updated", Toast.LENGTH_SHORT).show();

                    myRef.child(edit_key).child("name").setValue(user_name);
                    myRef.child(edit_key).child("age").setValue(user_age);
                    myRef.child(edit_key).child("gender").setValue(user_gender);
                    myRef.child(edit_key).child("education").setValue(user_education);
                    myRef.child(edit_key).child("hometown").setValue(user_hometown);
                    myRef.child(edit_key).child("occupation").setValue(user_occupation);
                    myRef.child(edit_key).child("interest1").setValue(user_interest1);
                    myRef.child(edit_key).child("interest2").setValue(user_interest2);

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

            Intent profile_info_intent = new Intent(this, ProfileInfoActivity.class);
            startActivity(profile_info_intent);



        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
