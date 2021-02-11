package model;

public class Feed {

    private double amount;
    private int caregiverResponsible;
    private int leftover;
    private int time; //24hr

    //REQUIRES: amount in ml
    //EFFECT: constructor for Feed
    public Feed(int time, double amount) {

        this.amount = amount;
        this.time = time;
    }

    public void changeFeedAmount(double newAmount) {
        //TODO
    }

    //REQUIRES:
    //Modifies:
    //EFFECT: Creates a log of each feed after it has happened
    public void logFeed() {
        //TODO
    }

    public int getTime() {
        return time;
    }
}
