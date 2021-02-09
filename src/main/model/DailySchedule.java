package model;

import java.util.ArrayList;

public class DailySchedule {

    private int numberOfFeeds;
    private ArrayList<Feed> dailySchedule;

    //REQUIRES: start time listed in 24hr format (ie. 2200) and feed interval is time between feeds (ie. 3)
    //EFFECT: constructor for DailySchedule
    public void dailySchedule(int startTime, int feedInterval) {

        this.dailySchedule = new ArrayList<Feed>();

        //add feeds that will go into the schedule feed1 = new feed(time)
    }

    //REQUIRES: time in 24hr format
    //Modifies: this
    //EFFECT: Assigns a feeding time to the caregiver responsible for that feed
    public void assignFeeds(int time, String caregiver) {
        //TODO
    }

    //REQUIRES: time in 24hr format and type is one of Regular or Sick
    //Modifies: this
    //EFFECT: Adds a new feed to the daily schedule
    public void addFeed(int time, String type) {
        //TODO
    }
}
