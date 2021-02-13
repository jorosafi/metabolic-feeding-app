package model;

import java.util.HashMap;

public class SickDayRecipe extends Recipe {

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

        recipe.put("I-Valex", ivalex);
        recipe.put("Enfamil", enfamil);
        recipe.put("Pro Phree", proPhree);
        recipe.put("Glycine", glycine);
        recipe.put("Breast Milk", breastMilk);
        recipe.put("Water to total volume of:", volume);
    }
}
