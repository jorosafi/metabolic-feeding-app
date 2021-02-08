package model;

import java.util.ArrayList;

public class RegularRecipe implements Recipe {
    private int ivalex;
    private int enfamil;
    private int proPhree;
    private int glycine;
    private int breastMilk;
    private int totalVolume;
    private ArrayList<String> recipe;

    //REQUIRES: date in mmdd format (Jan 28 = 0128); ivalex, enfamil, pro phree and glycine in gr; breast milk and
    //          volume in ml
    //EFFECT: constructor for RegularRecipe
    public void recipe(int date, int ivalex, int enfamil, int proPhree, int glycine, int breastMilk, int volume) {
        this.ivalex = ivalex;
        this.enfamil = enfamil;
        this.proPhree = proPhree;
        this.glycine = glycine;
        this.breastMilk = breastMilk;
        this.totalVolume = volume;

        recipe = new ArrayList<String>()
    }

    @Override
    //REQUIRES:
    //Modifies: this
    //EFFECT: Changes specific recipe ingredients in given recipe
    public void changeRecipe() {
        //TODO
    }

    //EFFECT: returns list of recipe ingredients and amounts of each
    public ArrayList<String> viewRecipe() {
        //TODO
        return recipe;
    }
}
