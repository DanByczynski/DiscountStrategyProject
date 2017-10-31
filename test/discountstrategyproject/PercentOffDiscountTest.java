/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package discountstrategyproject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author danielbyczynski
 */
public class PercentOffDiscountTest {
    private PercentOffDiscountTest pODT;
    
    public PercentOffDiscountTest() {
    }
    
    @Before
    public void setUp() {
        pODT = new PercentOffDiscountTest();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getDiscountAmount method, of class PercentOffDiscount.
     */
    @Test
    public void TestInputPercentMatchesOutputWhenValid() {
        System.out.println("Test to make sure the input percent matches the "
                + "dollar amount that is returned when valid.");
        
        double percentDiscount = .2;
        double productUnitCost = 10.0;
        int quantity = 1;
        
        PercentOffDiscount instance = new PercentOffDiscount(percentDiscount);
        
        double expResult = 8.0;
        double result = instance.getDiscountAmount(productUnitCost, quantity);
        assertEquals(expResult, result, 0.0);
    }
    
    /**
     * Test of getDiscountAmount method, of class PercentOffDiscount.
     */
    @Test(expected = IllegalArgumentException.class)
    public void TestInputPercentFailsWhenInvalid() {
        System.out.println("Test to make sure the input percent matches the "
                + "dollar amount that is returned when valid.");
        
        double percentDiscount = -.2;
        
        PercentOffDiscount instance = new PercentOffDiscount(percentDiscount);
        
    }
    
}
