package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RecipeTest {
    public Recipe testRecipe;

    @Test
    public void recipeConstructorTest(){
        testRecipe = new Recipe(40, 20,
                15, 1.5,350, 920);

        assertEquals(40, testRecipe.getIvalex());
        assertEquals(20, testRecipe.getEnfamil());
        assertEquals(15, testRecipe.getProPhree());
        assertEquals(1.5, testRecipe.getGlycine());
        assertEquals(350, testRecipe.getBreastMilk());
        assertEquals(920, testRecipe.getVolume());

        testRecipe = new Recipe(50, 10,
                20, 1.8,400, 960);

        assertEquals(50, testRecipe.getIvalex());
        assertEquals(10, testRecipe.getEnfamil());
        assertEquals(20, testRecipe.getProPhree());
        assertEquals(1.8, testRecipe.getGlycine());
        assertEquals(400, testRecipe.getBreastMilk());
        assertEquals(960, testRecipe.getVolume());

    }

}
