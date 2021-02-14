package model;

import java.util.Date;
import java.util.HashMap;

//TODO if time permits, create abstract Ingredients class for Recipe and Supplies
public class IngredientSupply {
    private int ivalex;
    private int proPhree;
    private int glycine;
    private HashMap<String, Integer> supplyList;

    //REQUIRES: Ingredient supplies measures in gr
    //EFFECT: constructor for Supplies
    public IngredientSupply(int ivalex, int proPhree, int glycine) {
        this.ivalex = ivalex;
        this.proPhree = proPhree;
        this.glycine = glycine;

        this.supplyList = new HashMap<String, Integer>();

        supplyList.put("I-Valex", ivalex);
        supplyList.put("Pro Phree", proPhree);
        supplyList.put("Glycine", glycine);
    }

    //REQUIRES: amount in gr
    //Modifies: this
    //EFFECT: Adds Ivalex stock to the supply list
    public void addIvalex(int amount) {
        //TODO
    }

    //REQUIRES: amount in gr
    //Modifies: this
    //EFFECT: Adds Pro Phree stock to the supply list
    public void addProPhree(int amount) {
        //TODO
    }

    //REQUIRES: amount gr
    //Modifies: this
    //EFFECT: Adds Glycine stock to the supply list
    public void addGlycine(int amount) {
        //TODO
    }

    //Getters for supplies
    public int getIvalex() {
        return ivalex;
    }
    public int getProPhree() {
        return proPhree;
    }
    public int getGlycine() {
        return glycine;
    }

    //EFFECT: Estimates how long supply of medical ingredients will last under current recipe
    public HashMap<String, Double> estimateIngredientSupply() {
        return null;
        //TODO
    }

}
