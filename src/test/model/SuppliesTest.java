package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SuppliesTest {

    private Supplies testSupplyList;

    @BeforeEach
    public void setUp() {
        testSupplyList = new Supplies(6, 8, 2);
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

        assertEquals(2, glycineAmount);

        testSupplyList.addGlycine(5);

        glycineAmount = testSupplyList.getGlycine();

        assertEquals(7, glycineAmount);
    }
}
