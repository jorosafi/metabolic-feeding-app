package model;

import java.util.ArrayList;
import java.util.HashMap;

public class SickDayRecipe implements Recipe {
    private double ivalex;
    private double enfamil;
    private double proPhree;
    private double glycine;
    private double breastMilk;
    private double totalVolume;
    private HashMap<String, Double> recipe;

    //REQUIRES: date in mmdd format (Jan 28, 2020 = 200128); ivalex, enfamil, pro phree and glycine in gr;
    //          breast milk and volume in ml
    //EFFECT: constructor for RegularRecipe
    public SickDayRecipe(double ivalex, double enfamil, double proPhree, double glycine, double breastMilk, double volume) {
        this.ivalex = ivalex;
        this.enfamil = enfamil;
        this.proPhree = proPhree;
        this.glycine = glycine;
        this.breastMilk = breastMilk;
        this.totalVolume = volume;

        recipe = new HashMap<String, Double>();
    }

    @Override
    //Modifies: this
    //EFFECT: changes specific ingredients of given recipe
    public void changeRecipe(String ingredient, double amount) {
        //TODO
    }

    @Override
    //EFFECT: returns list of ingredients and amounts
    public HashMap<String, Double> viewRecipe() {
        return null;

        //TODO
    }

    @Override
    //getter for Ivalex
    public double getIvalex() {
        return ivalex;
    }

    @Override
    //getter for Pro Phree
    public double getProPhree() {
        return proPhree;
    }

    @Override
    //getter for Glycine
    public double getGlycine() {
        return glycine;
    }

    @Override
    //getter for Enfamil
    public double getEnfamil() {
        return enfamil;
    }

    @Override
    //getter for Breast Milk
    public double getBreastMilk() {
        return breastMilk;
    }

    @Override
    //getter for Total Volume
    public double getVolume() {
        return totalVolume;
    }
}
