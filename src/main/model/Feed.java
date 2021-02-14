package model;

import java.util.Date;

public class Feed {

    private double amount;
    private int caregiverResponsible;
    private int leftover;
    private String time; //24hr

    //REQUIRES: Time format (YY.MM.dd - HH), amount in ml
    //EFFECT: constructor for Feed
    public Feed(String time, double amount) {
        this.amount = amount;
        this.time = time;
        //TODO finish constructor
    }


    //Getters for time and amount
    public String getTime() {
        return this.time;
    }
    public double getAmount() {
        return this.amount;
    }

}
