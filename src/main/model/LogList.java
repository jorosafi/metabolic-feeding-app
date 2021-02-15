package model;

import java.util.ArrayList;

//Creates data representation for LogList, consisting of an ArrayList of Logs
public class LogList {

    private ArrayList<Log> logList;


    //EFFECTS: Constructor for FeedLog
    public LogList() {
        this.logList = new ArrayList<>();
    }

    //MODIFIES: this
    //EFFECTS: Adds log to the log list.
    public void addLog(Log log) {
        this.logList.add(log);
    }

    //REQUIRES: timeOfFeed must be a string in format YY.MM.dd - HH
    //EFFECTS: Returns the Log of a feed by its date
    public Log getLogByFeed(String timeToSearchBy) {
        Log log = null;

        for (Log l : logList) {
            Feed feed = l.getFeed();
            String timeOfFeed = feed.getTime();
            if (timeToSearchBy.equals(timeOfFeed)) {
                log = l;
            }
        }
        return log;
    }

    //EFFECTS: Add up amount left in a day
    public int addAmountLeftInDay() {
        int amountLeft = 0;

        for (Log l : logList) {
            amountLeft = amountLeft + l.getAmount();
        }
        return amountLeft;
    }

    //EFFECTS: Returns Log in logList by index
    public Log getLogByIndex(int index) {
        return logList.get(index);
    }

    //EFFECTS: Returns the size of the logList
    public int logListSize() {
        return logList.size();
    }

    //EFFECTS: Getter for logList
    public ArrayList<Log> getLogList() {
        return logList;
    }

}
