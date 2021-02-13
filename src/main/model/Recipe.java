package model;

import java.util.HashMap;

public abstract class Recipe implements Ingredients {

    protected double ivalex;
    protected double enfamil;
    protected double proPhree;
    protected double glycine;
    protected double breastMilk;
    protected double totalVolume;
    protected HashMap<String, Double> recipe;

    //EFFECT: returns list of recipe ingredients and amounts of each
    public HashMap<String, Double> viewRecipe() {
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
