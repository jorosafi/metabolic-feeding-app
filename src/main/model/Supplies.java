package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Supplies {
    private int ivalex;
    private int proPhree;
    private int glycine;
    private HashMap<String, Integer> supplyList;

    //REQUIRES: parameter values given in number of cans.
    //EFFECT: constructor for Supplies
    public Supplies(int ivalex, int proPhree, int glycine) {
        this.ivalex = ivalex;
        this.proPhree = proPhree;
        this.glycine = glycine;

        this.supplyList = new HashMap<String, Integer>();

        //TODO finish constructor
    }

    //REQUIRES: amount in number of cans
    //Modifies: this
    //EFFECT: Adds Ivalex stock to the supply list
    public void addIvalex(int amount) {
        //TODO
    }

    //REQUIRES: amount in number of cans
    //Modifies: this
    //EFFECT: Adds Pro Phree stock to the supply list
    public void addProPhree(int amount) {
        //TODO
    }

    //REQUIRES: amount in number of cans
    //Modifies: this
    //EFFECT: Adds Glycine stock to the supply list
    public void addGlycine(int amount) {
        //TODO
    }

    public int getIvalex() {
        return ivalex;
    }

    public int getProPhree() {
        return proPhree;
    }

    public int getGlycine() {
        return glycine;
    }

    //EFFECT: Estimates how long current supply will last when using current regular recipe
    public HashMap<String, Integer> estimateSupply() {

        return supplyList;
    }

}
