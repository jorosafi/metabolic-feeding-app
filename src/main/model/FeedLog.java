package model;

import java.util.Date;

public class FeedLog {
    private int amountLeft;
    private Feed feed;
    private Date date;

    //EFFECTS: Constructor for FeedLog
    private FeedLog(Date date, Feed feed, int amountLeft) {
        this.date = date;
        this.feed = feed;
        this.amountLeft = amountLeft;
    }

    //EFFECTS: Getter for date
    private Date getDate() {
        return this.date;
    }

    //EFFECTS: Getter for feed
    private Feed getFeed() {
        return this.feed;
    }

    //EFFECTS: Getter for AmountLeft
    private int getAmountLeft() {
        return this.amountLeft;
    }
}
