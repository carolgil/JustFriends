package com.example.justfriends;

public class Event {

    public String eventName;
    public String eventLocation;
    public String eventDate;
    public String eventTime;
    public String eventDescription;
    public String eventCreator;
    public int eventCap;
    public String eventInterest;

    public Event(){

    }

    public Event(String eventName, String eventLocation, String eventDate, String eventTime, String eventDescription, String eventCreator, int eventCap, String eventInterest){
        this.eventName = eventName;
        this.eventLocation = eventLocation;
        this.eventDate = eventDate;
        this.eventTime = eventTime;
        this.eventDescription = eventDescription;
        this.eventCreator = eventCreator;
        this.eventCap = eventCap;
        this.eventInterest = eventInterest;
    }

}
