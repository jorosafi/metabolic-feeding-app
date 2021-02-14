package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RecipeTest {
    public Recipe testRecipe;

    @BeforeEach
    public void setUp(){
        testRecipe = new Recipe(40, 20,
                15, 1.5,350, 920);
    }

    @Test
    public void changeRecipeTest(){
        assertEquals(40, testRecipe.getIvalex());
        assertEquals(1.5, testRecipe.getGlycine());

        testRecipe.changeRecipe("ivalex", 20);

        assertEquals(20, testRecipe.getIvalex());

        testRecipe.changeRecipe("glycine", 2);

        assertEquals(2, testRecipe.getGlycine());

    }


}
