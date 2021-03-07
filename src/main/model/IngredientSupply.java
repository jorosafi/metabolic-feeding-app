package model;

import org.json.JSONObject;
import persistence.Writable;

import java.util.HashMap;

//TODO if time permits, create abstract Ingredients class for Recipe and Supplies

//Creates data representation for the supply of medical ingredients. Creates HashMap that stores the name of the
//  ingredient and the amount in stock.
public class IngredientSupply implements Writable {

    //Fields
    private double ivalex;
    private double proPhree;
    private double glycine;
    private HashMap<String, Double> supplyList;

    //REQUIRES: Ingredient supplies measures in gr
    //EFFECT: constructor for IngredientSupply
    public IngredientSupply(double ivalex, double proPhree, double glycine) {
        this.ivalex = ivalex;
        this.proPhree = proPhree;
        this.glycine = glycine;

        this.supplyList = new HashMap<>();

        supplyList.put("I-Valex", this.ivalex);
        supplyList.put("Pro Phree", this.proPhree);
        supplyList.put("Glycine", this.glycine);
    }

    //REQUIRES: amount in gr
    //Modifies: this
    //EFFECT: subtracts Ivalex amount from supplyList
    public void takeIvalex(double amount) {
        this.ivalex = this.ivalex - amount;

        supplyList.put("I-Valex", this.ivalex);
    }

    //REQUIRES: amount in gr
    //Modifies: this
    //EFFECT: subtracts proPhree amount from supplyList
    public void takeProPhree(double amount) {
        this.proPhree = this.proPhree - amount;

        supplyList.put("Pro Phree", this.proPhree);
    }

    //REQUIRES: amount in gr
    //Modifies: this
    //EFFECT: subtracts Glycine amount from supplyList
    public void takeGlycine(double amount) {
        this.glycine = this.glycine - amount;

        supplyList.put("Glycine", this.glycine);
    }

    //REQUIRES: amount in gr
    //Modifies: this
    //EFFECT: Adds Ivalex stock to the supply list
    public void addIvalex(double amount) {
        this.ivalex = this.ivalex + amount;

        this.supplyList.put("I-Valex", this.ivalex);
    }

    //REQUIRES: amount in gr
    //Modifies: this
    //EFFECT: Adds Pro Phree stock to the supply list
    public void addProPhree(double amount) {
        this.proPhree = this.proPhree + amount;

        this.supplyList.put("Pro Phree", this.proPhree);
    }

    //REQUIRES: amount gr
    //Modifies: this
    //EFFECT: Adds Glycine stock to the supply list
    public void addGlycine(double amount) {
        this.glycine = this.glycine + amount;

        this.supplyList.put("Glycine", this.glycine);
    }

    //Getters for supplies
    public double getIvalex() {
        return ivalex;
    }

    public double getProPhree() {
        return proPhree;
    }

    public double getGlycine() {
        return glycine;
    }

    //EFFECT: Estimates how long supply of medical ingredients will last under current recipe
    public HashMap<String, Double> estimateIngredientSupply(Recipe recipe) {
        double ivalexEstimate = this.ivalex / recipe.getIvalex();
        double proPhreeEstimate = this.proPhree / recipe.getProPhree();
        double glycineEstimate = this.glycine / recipe.getGlycine();

        HashMap<String, Double> totalEstimate = new HashMap<>();

        totalEstimate.put("Ivalex", ivalexEstimate);
        totalEstimate.put("Pro Phree", proPhreeEstimate);
        totalEstimate.put("Glycine", glycineEstimate);

        return totalEstimate;
    }

    //EFFECTS: Returns ingredient supply in JSON format
    public JSONObject toJson() {
        JSONObject json = new JSONObject();

        json.put("ivalex", ivalex);
        json.put("proPhree", proPhree);
        json.put("glycine", glycine);

        return json;
    }
}
