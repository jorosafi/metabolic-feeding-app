package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class RegularRecipe implements Recipe {
    private double ivalex;
    private double enfamil;
    private double proPhree;
    private double glycine;
    private double breastMilk;
    private double totalVolume;
    private HashMap<String, Double> recipe;

    //REQUIRES: date in mmdd format (Jan 28 = 0128); ivalex, enfamil, pro phree and glycine in gr; breast milk and
    //          volume in ml
    //EFFECT: constructor for RegularRecipe
    public RegularRecipe(double ivalex, double enfamil, double proPhree, double glycine, double breastMilk, double volume) {
        this.ivalex = ivalex;
        this.enfamil = enfamil;
        this.proPhree = proPhree;
        this.glycine = glycine;
        this.breastMilk = breastMilk;
        this.totalVolume = volume;

        recipe = new HashMap<String, Double>();

        //TODO finish constructor
    }

    @Override
    //REQUIRES:
    //Modifies: this
    //EFFECT: Changes specific recipe ingredients in given recipe
    public void changeRecipe(String ingredient, double amount) {
        //TODO
    }

    //EFFECT: returns list of recipe ingredients and amounts of each
    public HashMap<String, Double> viewRecipe() {
        //TODO
        return recipe;
    }

    @Override
    public double getIvalex() {
        return ivalex;
    }

    @Override
    public double getProPhree() {
        return proPhree;
    }

    @Override
    public double getGlycine() {
        return glycine;
    }

    @Override
    public double getEnfamil() {
        return enfamil;
    }

    @Override
    public double getBreastMilk() {
        return breastMilk;
    }

    @Override
    public double getVolume() {
        return totalVolume;
    }
}
