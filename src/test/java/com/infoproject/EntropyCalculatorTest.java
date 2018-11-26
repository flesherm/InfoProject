/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infoproject;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author matthewflesher
 */
public class EntropyCalculatorTest {
    
    double[] probs = {0.25,0.25,0.2,0.15,0.15};
    
    public EntropyCalculatorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of calculateEntropy method, of class EntropyCalculator.
     */
    @Test
    public void testCalculateEntropy() {
        System.out.println("testCalculateEntropy");
        double p = probs[0];
        double expResult = 2.0;
        double result = EntropyCalculator.calculateEntropy(p);
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testCalculateEntropyOfEnsemble() {
        System.out.println("testCalculateEntropyOfEnsemble");
        double expResult = 2.2855;
        double result = EntropyCalculator.calculateEntropyOfEnsemble(probs);
        assertEquals(expResult, result, 0.001);
    }
    
    @Test
    public void testRoundTo4decimalPoints() {
        System.out.println("testRoundTo4decimalPoints");
        double expResult = 2.2855;
        double result = EntropyCalculator.roundTo4decimalPoints(2.2854752972273342);
        assertEquals(expResult, result, 0.000);
    }
    
}
