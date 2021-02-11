package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SuppliesTest {

    private Supplies testSupplyList;

    @BeforeEach
    public void setUp() {
        testSupplyList = new Supplies(6, 8, 200);
    }

    @Test
    public void addIvalexTest(){
        int ivalexAmount = testSupplyList.getIvalex();

        assertEquals(6, ivalexAmount);

        testSupplyList.addIvalex(5);

        ivalexAmount = testSupplyList.getIvalex();

        assertEquals(11, ivalexAmount);
    }

    @Test
    public void addProPhreeTest(){
        int proPhreeAmount = testSupplyList.getProPhree();

        assertEquals(8, proPhreeAmount);

        testSupplyList.addProPhree(4);

        proPhreeAmount = testSupplyList.getProPhree();

        assertEquals(12, proPhreeAmount);
    }

    @Test
    public void addGlycine(){
        int glycineAmount = testSupplyList.getGlycine();

        assertEquals(200, glycineAmount);

        testSupplyList.addGlycine(500);

        glycineAmount = testSupplyList.getGlycine();

        assertEquals(700, glycineAmount);
    }

    @Test
    public void estimateSupplyTest() {
        RegularRecipe testRecipe = new RegularRecipe(10,10,10,1,10,900);

        double ivalexEstimate = testSupplyList.getIvalex()*400/testRecipe.getIvalex();
        double proPhreeEstimate = testSupplyList.getProPhree()*400/testRecipe.getProPhree();
        double glycineEstimate = testSupplyList.getGlycine()/testRecipe.getGlycine();

        HashMap<String, Double> totalEstimate = new HashMap<String, Double>();

        totalEstimate.put("Ivalex", ivalexEstimate);
        totalEstimate.put("Pro Phree", proPhreeEstimate);
        totalEstimate.put("Glycine", ivalexEstimate);

    }

    @Test
    public void estimateSupplyTestAfterFiveDays(){
        //TODO create test for estimate supply after x number of days
    }
}
