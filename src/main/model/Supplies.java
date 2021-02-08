package model;

import java.util.ArrayList;
import java.util.List;

public class Supplies {
    private int ivalex;
    private int proPhree;
    private int glycine;
    private ArrayList<String> supplyList;

    //REQUIRES: parameter values given in number of cans.
    //EFFECT: constructor for Supplies
    public void supplyList(int ivalex, int proPhree, int glycine) {
        this.supplyList = new ArrayList<>();
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

    //EFFECT: Estimates how long current supply will last when using current regular recipe
    public List estimateSupply() {
        return supplyList;
    }

}
