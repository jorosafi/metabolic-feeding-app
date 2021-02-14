package model;

import java.util.HashMap;

public class Recipe {
    private double ivalex;
    private double enfamil;
    private double proPhree;
    private double glycine;
    private double breastMilk;
    private double totalVolume;
    private HashMap<String, Double> recipe;

    //REQUIRES: ivalex, enfamil, pro phree and glycine in gr; breast milk and volume in ml
    //EFFECT: constructor for RegularRecipe
    public Recipe(double ivalex, double enfamil, double proPhree,
                  double glycine, double breastMilk, double volume) {
        this.ivalex = ivalex;
        this.enfamil = enfamil;
        this.proPhree = proPhree;
        this.glycine = glycine;
        this.breastMilk = breastMilk;
        this.totalVolume = volume;

        recipe = new HashMap<>();

        recipe.put("I-Valex", ivalex);
        recipe.put("Enfamil", enfamil);
        recipe.put("Pro Phree", proPhree);
        recipe.put("Glycine", glycine);
        recipe.put("Breast Milk", breastMilk);
        recipe.put("Water to total volume of:", volume);
    }

    //Getters for Recipe ingredients
    public double getIvalex() {
        return ivalex;
    }
    public double getProPhree() {
        return proPhree;
    }
    public double getGlycine() {
        return glycine;
    }
    public double getEnfamil() {
        return enfamil;
    }
    public double getBreastMilk() {
        return breastMilk;
    }
    public double getVolume() {
        return totalVolume;
    }

}
