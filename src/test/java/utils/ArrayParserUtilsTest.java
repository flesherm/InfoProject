/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import utils.ArrayParserUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Matthew Flesher
 */
public class ArrayParserUtilsTest
{
    
    public ArrayParserUtilsTest()
    {
    }
    
    @BeforeClass
    public static void setUpClass()
    {
    }
    
    @AfterClass
    public static void tearDownClass()
    {
    }
    
    @Before
    public void setUp()
    {
    }
    
    @After
    public void tearDown()
    {
    }
    
    /**
     * Test of sumIsOne method, of class ArrayParserUtils.
     */
    @Test
    public void testSumIsOne()
    {
        System.out.println("sumIsOne");
        double[] probs = {1.0, 0.3};
        double[] probs2 = {0.7, 0.3};
        boolean expResult = false;
        boolean result = ArrayParserUtils.sumIsOne(probs);
        boolean expResult2 = true;
        boolean result2 = ArrayParserUtils.sumIsOne(probs2);
        assertEquals(expResult, result);
        assertEquals(expResult2, result2);
    }
    
    @Test
    public void testAllPositive()
    {
        System.out.println("sumIsOne");
        double[] probs = {1.0, -0.3};
        double[] probs2 = {0.7, 0.3};
        boolean expResult = false;
        boolean result = ArrayParserUtils.areAllPositive(probs);
        boolean expResult2 = true;
        boolean result2 = ArrayParserUtils.areAllPositive(probs2);
        assertEquals(expResult, result);
        assertEquals(expResult2, result2);
    }

}
