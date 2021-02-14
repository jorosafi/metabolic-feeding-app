package model;

public class Log {
    private Feed feed;
    private int amount;

    //Modifies: this
    //Effects: Constructor for Feed
    public Log(Feed feed, int amount) {
        this.feed = feed;
        this.amount = amount;
    }

    //Getters
    public Feed getFeed() {
        return this.feed;
    }

    public int getAmount() {
        return this.amount;
    }

}
