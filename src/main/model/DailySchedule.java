package model;

import ui.FeedingApp;
import java.util.HashMap;

public class DailySchedule {

    private HashMap<Feed, Caregiver> dailySchedule;

    //REQUIRES: start time listed in 24hr format (ie. 2200) and feed interval is time between feeds (ie. 3)
    //EFFECT: constructor for DailySchedule
    public DailySchedule(int startTime, int feedInterval) {

        this.dailySchedule = new HashMap<>();

        int numberOfFeeds = 24 / feedInterval;

        RegularRecipe currentRecipe = FeedingApp.currentRecipe;
        int nextTime = startTime;

        double feedAmount = currentRecipe.getVolume() / numberOfFeeds;

        for (int i = numberOfFeeds; i > 0; i--) {
            this.dailySchedule.put(new Feed(nextTime, feedAmount), null);
            nextTime = nextTime + feedInterval;
        }
    }

    //REQUIRES: An existing time in the schedule. time in 24hr format
    //Modifies: this
    //EFFECT: Assigns a feeding time to the caregiver responsible for that feed
    public void assignFeeds(int time, Caregiver caregiver) {
        for (Feed f : this.dailySchedule.keySet()) {
            if (f.getTime() == time) {
                this.dailySchedule.put(f, caregiver);
            }
        }

    }

    //REQUIRES: time in 24hr format and type is one of Regular or Sick
    //Modifies: this
    //EFFECT: Adds a new feed to the daily schedule
    //public void addFeed(int time, String type) {
        //TODO
        //Aspirational method. Only complete if enough time.
    //}
}
