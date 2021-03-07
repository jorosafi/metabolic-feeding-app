package model;

//Creates data representation for an individual feed, consisting of Date/Time in YY.MM.dd - HH format and amount in ml
public class Feed implements Comparable<Feed> {

    private double amount;
    private String time; //24hr

    //REQUIRES: Time format (YY.MM.dd - HH), amount in ml
    //EFFECT: constructor for Feed
    public Feed(String time, double amount) {
        this.amount = amount;
        this.time = time;
    }


    //Getters for time and amount
    public String getTime() {
        return this.time;
    }

    public double getAmount() {
        return this.amount;
    }

    @Override
    public int compareTo(Feed feed) {
        return this.getTime().compareTo(feed.getTime());
    }
}
