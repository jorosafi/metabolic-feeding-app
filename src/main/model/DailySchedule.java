package model;

import ui.FeedingApp;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DailySchedule {

    public static final int FEEDS_PER_DAY = 6;
    private ArrayList<Feed> dailySchedule;

    //EFFECT: constructor for DailySchedule
    public DailySchedule() {
        Date currentTime = new Date();
        SimpleDateFormat todayFormated = new SimpleDateFormat("yy.MM.dd");

        this.dailySchedule = new ArrayList<>();

        //TODO come back to this and redo the constructor past this point

/*        int numberOfFeeds = 24 / feedInterval;

        Recipe currentRecipe = FeedingApp.currentRecipe;
        int nextTime = startTime;

        double feedAmount = currentRecipe.getVolume() / numberOfFeeds;

        for (int i = numberOfFeeds; i > 0; i--) {
            this.dailySchedule.add(new Feed(nextTime, feedAmount));
            nextTime = nextTime + feedInterval;
        }*/
    }


    //getter for dailySchedule
    public List getDailySchedule() {
        return this.dailySchedule;
    }

    //REQUIRES: index from 0 to (FEEDS_PER_DAY--)
    //EFFECT: gets the feed in the array at the given index
    public Feed getFeedByIndex(int index) {
        //todo
        return null;
    }

    //EFFECTS: returns the number of feeds still to be completed
    public int feedsLeftInDay() {
        return 0;
        //TODO
    }
}
