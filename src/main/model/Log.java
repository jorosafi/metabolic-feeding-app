package model;

//Creates data representation for a log entry, consisting of a Feed and an Amount of feed left behind by baby
public class Log {
    private Feed feed;
    private int amount;

    //Modifies: this
    //Effects: Constructor for Feed
    public Log(Feed feed, int amount) {
        this.feed = feed;
        this.amount = amount;
    }

    //Getters for Log
    public Feed getFeed() {
        return this.feed;
    }

    public int getAmount() {
        return this.amount;
    }

}
