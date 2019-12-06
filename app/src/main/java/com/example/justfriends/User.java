package com.example.justfriends;

import android.widget.Spinner;

public class User {

    public String email;
    public String name;
    public int age;
    public String gender;
    public String education;
    public String hometown;
    public String occupation;
    public String interest1;
    public String interest2;

    public User() {

    }

    public User(String email, String name, int age, String gender, String education, String hometown, String occupation, String interest1, String interest2) {
        this.email = email;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.education = education;
        this.hometown = hometown;
        this.occupation = occupation;
        this.interest1 = interest1;
        this.interest2 = interest2;
    }

}




