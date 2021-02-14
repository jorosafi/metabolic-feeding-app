package model;

import java.util.ArrayList;

public class LogList {

    private ArrayList<Log> logList;


    //EFFECTS: Constructor for FeedLog
    public LogList() {
        this.logList = new ArrayList<>();
        //TODO finish constructor
    }

    //REQUIRES: amount left in a feed measured in ml. Assume DailySchedule is not empty
    //MODIFIES: this
    //EFFECTS: Removes next feed in Daily Schedule, creates a new Log  with amount of feed leftover
    //          and inserts it into LogList.
    public void logFeed(int amountLeft) {
        //TODO finish logFeed method
    }

    //REQUIRES: timeOfFeed must be a string in format YY.MM.dd - HH
    //EFFECTS: Getter for date
    public Log getLogByFeed(String timeOfFeed) {
        return null;
        //TODO
    }

    //EFFECTS: returns the size of the logList
    public int logListSize() {
        return 0;
    }

    //EFFECTS: returns Log in logList by index
    public Log getLogByIndex(int index) {
        return null;
    }

}
