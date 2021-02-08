package model;

import java.util.ArrayList;

public interface Recipe {

    //EFFECT: Changes an existing recipe
    public void changeRecipe();

    //EFFECT: Returns an existing recipe
    public ArrayList viewRecipe();

}
