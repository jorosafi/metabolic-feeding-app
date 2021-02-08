package model;

public class Feed {

    private int amount;
    private int caregiverResponsible;
    private int leftover;

    //REQUIRES: amount in ml
    //EFFECT: constructor for Feed
    public void feed(int amount) {
        this.amount = amount;
    }

    //REQUIRES:
    //Modifies:
    //EFFECT: Creates a log of each feed after it has happened
    public void logFeed() {
        //TODO
    }
}
