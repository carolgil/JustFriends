package com.example.justfriends;

import java.util.ArrayList;

public class Event {

    public String eventName;
    public String eventLocation;
    public String eventDate;
    public String eventTime;
    public String eventDescription;
    public String eventCreator;
    public int eventCap;
    public String eventInterest;
    public ArrayList<String> going;

    public Event(){

    }

    public Event(String eventName, String eventLocation, String eventDate, String eventTime, String eventDescription, String eventCreator, int eventCap, String eventInterest, ArrayList<String> going){
        this.eventName = eventName;
        this.eventLocation = eventLocation;
        this.eventDate = eventDate;
        this.eventTime = eventTime;
        this.eventDescription = eventDescription;
        this.eventCreator = eventCreator;
        this.eventCap = eventCap;
        this.eventInterest = eventInterest;
        this.going = going;
    }

}
