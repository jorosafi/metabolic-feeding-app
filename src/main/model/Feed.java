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

    //REQUIRES: amount in ml
    //Modifies: this
    //EFFECT: changes the amount of a feed
    public void changeFeedAmount(double newAmount) {
        this.amount = newAmount;
    }

    //EFFECT: returns feed time
    public int getTime() {
        return this.time;
    }

    //EffectL returns feed amount
    public double getAmount() {
        return this.amount;
    }


}
