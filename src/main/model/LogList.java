package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class LogList {

    private ArrayList<Log> logList;


    //EFFECTS: Constructor for FeedLog
    public LogList() {
        this.logList = new ArrayList<>();
        //TODO finish constructor
    }

    //REQUIRES: amount left in a feed measured in ml
    //MODIFIES: this
    //EFFECTS: Removes next feed in Daily Schedule, creates a new Log  with amount of feed leftover
    //          and inserts it into LogList.
    public void logFeed(int amountLeft) {
        //TODO finish logFeed method
    }

    //REQUIRES: timeOfFeed must be a string in format YY.MM.dd - HH
    //EFFECTS: Getter for date
    public Log getLog(String timeOfFeed) {
        return null;
        //TODO
    }

}
