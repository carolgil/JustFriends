package com.example.justfriends;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class CreateProfileActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    EditText editTextName, editTextAge, editTextEducation, editTextHometown, editTextOccupation;
    Spinner spinnerGender, spinnerInterest1, spinnerInterest2;
    Button buttonCreateProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_profile);

        editTextName = findViewById(R.id.editTextName);
        editTextAge = findViewById(R.id.editTextAge);
        editTextEducation = findViewById(R.id.editTextEducation);
        editTextHometown = findViewById(R.id.editTextHometown);
        editTextOccupation = findViewById(R.id.editTextOccupation);
        spinnerGender = findViewById(R.id.spinnerGender);
        spinnerInterest1 = findViewById(R.id.spinnerInterest1);
        spinnerInterest2 = findViewById(R.id.spinnerInterest2);
        buttonCreateProfile = findViewById(R.id.buttonCreateProfile);

        buttonCreateProfile.setOnClickListener(this);
        spinnerGender.setOnItemSelectedListener(this);
        spinnerInterest1.setOnItemSelectedListener(this);
        spinnerInterest2.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.gender_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerGender.setAdapter(adapter);

        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                R.array.interests_array, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerInterest1.setAdapter(adapter1);

        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.interests_array, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerInterest2.setAdapter(adapter2);
    }

    @Override
    public void onClick(View view) {

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Users");

        if (buttonCreateProfile == view) {
            String email = FirebaseAuth.getInstance().getCurrentUser().getEmail();
            String name = editTextName.getText().toString();
            int age = Integer.parseInt(editTextAge.getText().toString());
            String education = editTextEducation.getText().toString();
            String hometown = editTextHometown.getText().toString();
            String occupation = editTextOccupation.getText().toString();
            String gender = spinnerGender.getSelectedItem().toString();
            String interest1 = spinnerInterest1.getSelectedItem().toString();
            String interest2 = spinnerInterest2.getSelectedItem().toString();


            User myUser = new User(email, name, age, education, hometown, occupation, gender, interest1, interest2);
            myRef.push().setValue(myUser);

            Intent feedIntent = new Intent(CreateProfileActivity.this, FeedActivity.class);
            startActivity(feedIntent);
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
