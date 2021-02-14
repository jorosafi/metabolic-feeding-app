package model;

import ui.FeedingApp;

import java.util.ArrayList;
import java.util.List;

public class DailySchedule {

    public static final int FEEDS_PER_DAY = 6;
    private ArrayList<Feed> dailySchedule;

    //EFFECT: constructor for DailySchedule
    public DailySchedule() {

        this.dailySchedule = new ArrayList<>();

        //TODO come back to this and redo the constructor past this point

        int numberOfFeeds = 24 / feedInterval;

        Recipe currentRecipe = FeedingApp.currentRecipe;
        int nextTime = startTime;

        double feedAmount = currentRecipe.getVolume() / numberOfFeeds;

        for (int i = numberOfFeeds; i > 0; i--) {
            this.dailySchedule.add(new Feed(nextTime, feedAmount));
            nextTime = nextTime + feedInterval;
        }
    }


    //getter for dailySchedule
    public List getDailySchedule() {
        return this.dailySchedule;
    }
}
