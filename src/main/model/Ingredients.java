package model;

import java.util.ArrayList;
import java.util.HashMap;

public interface Ingredients {

    //EFFECT: Returns an existing recipe
    public HashMap<String, Double> viewRecipe();

    public double getIvalex();

    public double getProPhree();

    public double getGlycine();

    public double getEnfamil();

    public double getBreastMilk();

    public double getVolume();


}
