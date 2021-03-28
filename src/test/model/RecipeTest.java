package model;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

//Tests Recipe class
public class RecipeTest {
    public Recipe testRecipe;

    @Test
    //EFFECTS: Tests constructor for Recipe class
    public void recipeConstructorTest() {
        testRecipe = new Recipe(40, 20,
                15, 1.5, 350, 920);

        assertEquals(40, testRecipe.getIvalex());
        assertEquals(20, testRecipe.getEnfamil());
        assertEquals(15, testRecipe.getProPhree());
        assertEquals(1.5, testRecipe.getGlycine());
        assertEquals(350, testRecipe.getBreastMilk());
        assertEquals(920, testRecipe.getVolume());

        testRecipe = new Recipe(50, 10,
                20, 1.8, 400, 960);

        assertEquals(50, testRecipe.getIvalex());
        assertEquals(10, testRecipe.getEnfamil());
        assertEquals(20, testRecipe.getProPhree());
        assertEquals(1.8, testRecipe.getGlycine());
        assertEquals(400, testRecipe.getBreastMilk());
        assertEquals(960, testRecipe.getVolume());

    }

    @Test
    //EFFECTS: Checking toJson method
    public void testToJson() {
        testRecipe = new Recipe(40, 20,
                15, 1.5, 350, 920);
        JSONObject json = testRecipe.toJson();

        assertEquals(6, json.length());
    }

    @Test
    //EFFECTS: Tests setters working properly
    public void testSetters() {
        testRecipe = new Recipe(40, 20,
                15, 1.5, 350, 920);

        testRecipe.setTotalVolume(1000);
        testRecipe.setBreastMilk(500);
        testRecipe.setGlycine(5);
        testRecipe.setEnfamil(100);
        testRecipe.setProPhree(50);
        testRecipe.setIvalex(10);

        assertEquals(10, testRecipe.getIvalex());
        assertEquals(100, testRecipe.getEnfamil());
        assertEquals(50, testRecipe.getProPhree());
        assertEquals(5, testRecipe.getGlycine());
        assertEquals(500, testRecipe.getBreastMilk());
        assertEquals(1000, testRecipe.getVolume());
    }

}
