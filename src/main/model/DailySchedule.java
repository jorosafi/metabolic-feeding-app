package model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

//Creates data representation for a day-schedule of feeds consisting of an ArrayList of Feeds
public class DailySchedule {

    public static final int START_TIME = 2;
    public static final int FEED_INTERVAL = 4;
    private Recipe currentRecipe;
    private ArrayList<Feed> dailySchedule;

    //EFFECT: constructor for DailySchedule
    public DailySchedule(Recipe recipe) {

        Date currentTime = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yy.MM.dd");
        String todayFormatted = "" + dateFormat.format(currentTime) + "";

        this.dailySchedule = new ArrayList<>();

        int numberOfFeeds = 24 / FEED_INTERVAL;

        this.currentRecipe = recipe;

        double feedAmount = this.currentRecipe.getVolume() / numberOfFeeds;

        int nextTime = START_TIME;

        for (int i = numberOfFeeds; i > 0; i--) {
            String timeString = todayFormatted + " - " + nextTime;
            this.dailySchedule.add(new Feed(timeString, feedAmount));
            nextTime = nextTime + FEED_INTERVAL;
        }
    }

    //MODIFIES: this
    //EFFECTS: removes first feed from dailyFeed array list
    public void removeFirstFeed() {
        this.dailySchedule.remove(0);
    }


    //EFFECTS: getter for dailySchedule
    public ArrayList<Feed> getDailySchedule() {
        return this.dailySchedule;
    }

    //REQUIRES: index from 0 to (FEEDS_PER_DAY--)
    //EFFECT: gets the feed in the array at the given index
    public Feed getFeedByIndex(int index) {
        return this.dailySchedule.get(index);
    }

}
