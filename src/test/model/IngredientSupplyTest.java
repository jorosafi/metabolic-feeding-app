package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IngredientSupplyTest {

    private IngredientSupply testSupplyList;
    private Recipe testRecipe;

    @BeforeEach
    public void setUp() {
        testSupplyList = new IngredientSupply(600, 800, 200);
        testRecipe = new Recipe(40,35,
                15,1.8, 350,960);
    }

    @Test
    public void addIvalexTest(){
        double ivalexAmount = testSupplyList.getIvalex();

        assertEquals(600, ivalexAmount);

        testSupplyList.addIvalex(200);

        ivalexAmount = testSupplyList.getIvalex();

        assertEquals(800, ivalexAmount);
    }

    @Test
    public void addProPhreeTest(){
        double proPhreeAmount = testSupplyList.getProPhree();

        assertEquals(800, proPhreeAmount);

        testSupplyList.addProPhree(400);

        proPhreeAmount = testSupplyList.getProPhree();

        assertEquals(1200, proPhreeAmount);
    }

    @Test
    public void addGlycine(){
        double glycineAmount = testSupplyList.getGlycine();

        assertEquals(200, glycineAmount);

        testSupplyList.addGlycine(500);

        glycineAmount = testSupplyList.getGlycine();

        assertEquals(700, glycineAmount);
    }

    @Test
    public void takeIvalexTest() {
        double ivalexAmount = testSupplyList.getIvalex();

        assertEquals(600, ivalexAmount);

        testSupplyList.takeIvalex(500);

        ivalexAmount = testSupplyList.getIvalex();

        assertEquals(100, ivalexAmount);
    }

    @Test
    public void takeProPhreeTest() {
        double proPhreeAmount = testSupplyList.getProPhree();

        assertEquals(800, proPhreeAmount);

        testSupplyList.takeProPhree(500);

        proPhreeAmount = testSupplyList.getProPhree();

        assertEquals(300, proPhreeAmount);
    }

    @Test
    public void takeGlycineTest() {
        double glycineAmount = testSupplyList.getGlycine();

        assertEquals(200, glycineAmount);

        testSupplyList.takeGlycine(100);

        glycineAmount = testSupplyList.getGlycine();

        assertEquals(100, glycineAmount);
    }

    @Test
    public void estimateIngredientSupplyTest() {


        double ivalexEstimate = testSupplyList.getIvalex()/testRecipe.getIvalex();
        double proPhreeEstimate = testSupplyList.getProPhree()/testRecipe.getProPhree();
        double glycineEstimate = testSupplyList.getGlycine()/testRecipe.getGlycine();

        HashMap<String, Double> totalEstimate = new HashMap<String, Double>();

        totalEstimate.put("Ivalex", ivalexEstimate);
        totalEstimate.put("Pro Phree", proPhreeEstimate);
        totalEstimate.put("Glycine", glycineEstimate);

        assertEquals(totalEstimate, testSupplyList.estimateIngredientSupply(testRecipe));

    }
}
