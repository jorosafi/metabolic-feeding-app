package model;

import java.util.ArrayList;
import java.util.List;

public class LogList {

    private List<FeedLog> logList;

    //EFFECTS: constructor for LogList
    private LogList() {
        this.logList = new ArrayList<FeedLog>();
    }

    //MODIFIES: this
    //EFFECTS: Adds new FeedLog to the Log list
    private void addFeedLog(FeedLog log) {
        this.logList.add(log);
    }

    //EFFECTS: Returns the full log list
    private List<FeedLog> viewLogList() {
        return this.logList;
    }

}
