package model;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Comparator;

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

    //MODIFIES: This
    //EFFECTS: Sorts LogList in ascending order by date/time
    public LogList sortLogList() {
        this.logList.sort(Comparator.comparing(Log::getFeed));
        return this;
    }

    //EFFECTS: returns log list as a JSONObject to save in Notebook
    public JSONObject toJson() {
        JSONObject json = new JSONObject();

        for (Log log : this.logList) {
            String feedTime = log.getFeed().getTime();
            Double feedAmount = log.getFeed().getAmount();
            int feedLeftOver = log.getAmount();

            JSONArray feedAmountAndLeft = new JSONArray();
            feedAmountAndLeft.put(feedAmount);
            feedAmountAndLeft.put(feedLeftOver);

            json.put(feedTime, feedAmountAndLeft);
        }

        return json;
    }
}
