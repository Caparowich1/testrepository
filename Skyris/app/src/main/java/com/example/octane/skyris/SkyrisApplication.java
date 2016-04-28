package com.example.octane.skyris;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

import object.Event;
import object.Friend;

public class SkyrisApplication extends Application {

    public static final boolean DEBUG_MODE = true;
    private static SkyrisApplication theApp;
    private List<Friend> listOfFriends;
    private List<Event> listOfEvents;

    public SkyrisApplication() {
        super();
        theApp = this;
        listOfFriends = new ArrayList<Friend>();
        listOfEvents = new ArrayList<Event>();

        if (DEBUG_MODE) {

            for(int i = 0; i < 5; i++) {

                Friend friend = new Friend();
                friend.setUserID(0);
                friend.setUsername("Friend Object");
                listOfFriends.add(friend);

                Event anEvent = new Event();
                anEvent.setName("New Event");
                listOfEvents.add(anEvent);

            }

        }


    }

    public static SkyrisApplication getContext() {
        return theApp;
    }

    public List<Friend> getFriends() {
        return listOfFriends;
    }


    public List<Event> getEvents() {
        return listOfEvents;
    }


}
