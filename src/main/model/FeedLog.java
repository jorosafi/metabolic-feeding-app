package model;

import java.time.LocalDate;
import java.util.Date;

public class FeedLog {
    private int amountLeft;
    private Feed feed;
    private LocalDate date;

    //EFFECTS: Constructor for FeedLog
    public FeedLog(LocalDate date, Feed feed, int amountLeft) {
        this.date = date;
        this.feed = feed;
        this.amountLeft = amountLeft;
    }

    //EFFECTS: Getter for date
    public Date getDate() {
        return this.date;
    }

    //EFFECTS: Getter for feed
    public Feed getFeed() {
        return this.feed;
    }

    //EFFECTS: Getter for AmountLeft
    public int getAmountLeft() {
        return this.amountLeft;
    }
}
