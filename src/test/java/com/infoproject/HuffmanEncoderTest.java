/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infoproject;

import java.util.Arrays;
import java.util.PriorityQueue;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Matthew Flesher
 */
public class HuffmanEncoderTest
{    
    public HuffmanEncoderTest()
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
     * Test of encodeHuffman method, of class HuffmanEncoder.
     */
    @Ignore
    @Test
    public void testEncodeHuffman()
    {
        System.out.println("encodeHuffman");
        String[] ensemble = {"a","b","c","d","e"};
        double[] p = {.25,.25,.2,.15,.15};
        HuffmanEncoder huff = new HuffmanEncoder(p, ensemble);
        String[] expResult = {"00","10","11","010","011"};
        String[] result = huff.encodeHuffman();
        assertArrayEquals(expResult, result);
    }
    
    @Test
    public void testCreatePriorityQueue()
    {
        System.out.println("testCreatePriorityQueue");
        String[] ensemble = {"a","b","c","d","e"};
        double[] p = {.25,.25,.2,.15,.15};
        HuffmanEncoder huff = new HuffmanEncoder(p, ensemble);
        PriorityQueue pq = huff.createPriorityQ(p);
        huff.sort(p);
        for(int i = 0; i < p.length; i++){
            HuffmanNode next = (HuffmanNode) pq.poll();
            System.out.println(next.e + ": " + next.prob);
            assertEquals(next.prob, p[i], 0.0000);
        }
    }
    
    @Test
    public void testSort()
    {
        System.out.println("testSort");
        String[] ensemble = {"a","b","c","d","e"};
        double[] p = {.2,.15,.25,.25,.15};
        HuffmanEncoder huff = new HuffmanEncoder(p, ensemble);
        huff.sort(p);
//        for(int i = 0; i < p.length; i++){
//            System.out.println(p[i]);
//        }
        assertEquals(.15, p[0], 0.0000);
    }
    
    @Test
    public void testCreateNewArray()
    {
        System.out.println("testCreateNewArray");
        String[] ensemble = {"a","b","c","d","e"};
        double[] p = {.2,.15,.25,.25,.15};
        double[] expected = {.2,.25,.25,.3};
        HuffmanEncoder huff = new HuffmanEncoder(p, ensemble);
        huff.sort(p);
        double[] newP = huff.createNewArray(p);
        for(int i = 0; i < newP.length; i++){
            System.out.println(newP[i]);
        }
        assertTrue(Arrays.equals(expected, newP));
    }
    
}
