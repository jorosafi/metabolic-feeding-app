package model;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

//Creates data representation for a day-schedule of feeds consisting of an ArrayList of Feeds
public class DailySchedule {

    public static final int START_TIME = 2;
    public static final int FEED_INTERVAL = 4;
    private Recipe currentRecipe;
    private ArrayList<Feed> dailySchedule;

    //EFFECT: Main constructor for DailySchedule. Generates 24hr feeding schedule based
    //       on the START_TIME, FEED_INTERVAL, and given recipe
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
            String timeString = todayFormatted + " - " + formatTime(nextTime);
            this.dailySchedule.add(new Feed(timeString, feedAmount));
            nextTime = nextTime + FEED_INTERVAL;
        }
    }

    private String formatTime(int time) {
        if (time < 10) {
            return "0" + time;
        } else {
            return Integer.toString(time);
        }
    }

    //EFFECTS: DailySchedule constructor that parses a saved DailySchedule in JSONObject format
    public DailySchedule(JSONObject savedSchedule) {
        this.dailySchedule = new ArrayList<>();
        Set<String> keySet = savedSchedule.keySet();

        for (String key : keySet) {
            double feedAmount = savedSchedule.getDouble(key);
            Feed feed = new Feed(key, feedAmount);
            this.dailySchedule.add(feed);
        }

        this.sortSchedule();
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

    //MODIFIES: This
    //EFFECTS: Sorts schedule in ascending time order.
    public void sortSchedule() {
        this.dailySchedule.sort(Comparator.comparing(Feed::getTime));
    }

    //EFFECT: Returns feeding schedule as a JSONObject
    public JSONObject toJson() {
        JSONObject json = new JSONObject();


        for (Feed feed : this.dailySchedule) {
            String feedTime = feed.getTime();
            Double feedAmount = feed.getAmount();

            json.put(feedTime, feedAmount);
        }

        return json;
    }
}
