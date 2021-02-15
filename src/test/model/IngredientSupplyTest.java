package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

//Tests IngredientSupplyClass
public class IngredientSupplyTest {

    private IngredientSupply testSupplyList;
    private Recipe testRecipe;

    @BeforeEach
    public void setUp() {
        testSupplyList = new IngredientSupply(600, 800, 200);
        testRecipe = new Recipe(40, 35,
                15, 1.8, 350, 960);
    }

    @Test
    //EFFECTS: tests addIvalex method
    public void addIvalexTest() {
        double ivalexAmount = testSupplyList.getIvalex();

        assertEquals(600, ivalexAmount);

        testSupplyList.addIvalex(200);

        ivalexAmount = testSupplyList.getIvalex();

        assertEquals(800, ivalexAmount);
    }

    @Test
    //EFFECTS: Tests addProPhree method
    public void addProPhreeTest() {
        double proPhreeAmount = testSupplyList.getProPhree();

        assertEquals(800, proPhreeAmount);

        testSupplyList.addProPhree(400);

        proPhreeAmount = testSupplyList.getProPhree();

        assertEquals(1200, proPhreeAmount);
    }

    @Test
    //EFFECTS: Tests addGlycine method
    public void addGlycine() {
        double glycineAmount = testSupplyList.getGlycine();

        assertEquals(200, glycineAmount);

        testSupplyList.addGlycine(500);

        glycineAmount = testSupplyList.getGlycine();

        assertEquals(700, glycineAmount);
    }

    @Test
    //EFFECTS: Tests takeIvalex method
    public void takeIvalexTest() {
        double ivalexAmount = testSupplyList.getIvalex();

        assertEquals(600, ivalexAmount);

        testSupplyList.takeIvalex(500);

        ivalexAmount = testSupplyList.getIvalex();

        assertEquals(100, ivalexAmount);
    }

    @Test
    //EFFECTS: tests takeProPhree method
    public void takeProPhreeTest() {
        double proPhreeAmount = testSupplyList.getProPhree();

        assertEquals(800, proPhreeAmount);

        testSupplyList.takeProPhree(500);

        proPhreeAmount = testSupplyList.getProPhree();

        assertEquals(300, proPhreeAmount);
    }

    @Test
    //EFFECTS: tests takeGlycine method
    public void takeGlycineTest() {
        double glycineAmount = testSupplyList.getGlycine();

        assertEquals(200, glycineAmount);

        testSupplyList.takeGlycine(100);

        glycineAmount = testSupplyList.getGlycine();

        assertEquals(100, glycineAmount);
    }

    @Test
    //EFFECTS: tests estimateIngredientSupply method
    public void estimateIngredientSupplyTest() {


        double ivalexEstimate = testSupplyList.getIvalex() / testRecipe.getIvalex();
        double proPhreeEstimate = testSupplyList.getProPhree() / testRecipe.getProPhree();
        double glycineEstimate = testSupplyList.getGlycine() / testRecipe.getGlycine();

        HashMap<String, Double> totalEstimate = new HashMap<>();

        totalEstimate.put("Ivalex", ivalexEstimate);
        totalEstimate.put("Pro Phree", proPhreeEstimate);
        totalEstimate.put("Glycine", glycineEstimate);

        assertEquals(totalEstimate, testSupplyList.estimateIngredientSupply(testRecipe));

    }
}
