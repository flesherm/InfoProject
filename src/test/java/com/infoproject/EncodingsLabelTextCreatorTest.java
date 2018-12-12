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
import org.junit.Ignore;

/**
 *
 * @author Matthew Flesher
 */
public class EncodingsLabelTextCreatorTest
{
    
    String[] ensemble = {"a","b","c","d","e"};
    double[] p = {.25,.25,.2,.15,.15};
    
    String[] ensemble2 = {"a","b","c"};
    double[] p2 = {.25,.25,.5};
    
    public EncodingsLabelTextCreatorTest()
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
     * Test of createEncodingsLabelBitString method, of class EncodingsLabel.
     */
    @Ignore
    @Test
    public void testCreateEncodingsLabelBitString()
    {
        System.out.println("createEncodingsLabelBitString");
        HuffmanEncoder huffman = new HuffmanEncoder(p, ensemble);
        HuffmanNode root = huffman.createTree();
        EncodingsLabelTextCreator enc = new EncodingsLabelTextCreator(root);
        String expResult = "{ a: 01, b: 10, c: 11, d: 001, e: 000 }";       
        String result = enc.getLabelText();
        System.out.println(result);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of createEncodingsLabelBitString method, of class EncodingsLabel.
     */
    @Test
    public void testCreateEncodingsLabelBitString2()
    {
        System.out.println("testCreateEncodingsLabelBitString2");
        HuffmanEncoder huffman = new HuffmanEncoder(p2, ensemble2);
        HuffmanNode root = huffman.createTree();
        EncodingsLabelTextCreator enc = new EncodingsLabelTextCreator(root);
        String expResult = "{ a: 01, b: 00, c: 0 }";       
        String result = enc.getLabelText();
        System.out.println(result);
        assertEquals(expResult, result);
    }
    
}
