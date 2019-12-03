package com.example.justfriends;

public class Event {

    public String eventName;
    public String eventLocation;
    public String eventDate;
    public String eventTime;
    public String eventDescription;
    public int eventCap;

    public Event(){

    }

    public Event(String eventName, String eventLocation, String eventDate, String eventTime, String eventDescription, int eventCap){
        this.eventName = eventName;
        this.eventLocation = eventLocation;
        this.eventDate = eventDate;
        this.eventTime = eventTime;
        this.eventDescription = eventDescription;
        this.eventCap = eventCap;
    }
    
}
