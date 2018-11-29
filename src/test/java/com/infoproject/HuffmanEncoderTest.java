/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infoproject;

import java.util.HashMap;
import java.util.Map;
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
    String[] ensemble = {"a","b","c","d","e"};
    double[] p = {.25,.25,.2,.15,.15};
    
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
//    @Ignore
    @Test
    public void testEncodeHuffman()
    {
        System.out.println("encodeHuffman");
        HuffmanEncoder huff = new HuffmanEncoder(p, ensemble);
        Map<String, String> expMap = new HashMap<>();
        expMap.put("a", "01");
        expMap.put("b", "10");
        expMap.put("c", "11");
        expMap.put("d", "001");
        expMap.put("e", "000");
        Map<String, String> result = huff.encodeHuffman();
        assertTrue(expMap.equals(result));
    }
    
//    @Ignore
    @Test
    public void testTraverseTree()
    {
        System.out.println("testTraverseTree");
        HuffmanEncoder huff = new HuffmanEncoder(p, ensemble);
        HuffmanNode h = huff.createTree();
        huff.traverseTree(h);
        assertTrue(h.getLeft().getRight().character.equals("a"));
        assertTrue(h.getRight().getRight().character.equals("c"));
        assertTrue(h.getRight().getLeft().character.equals("b"));
        assertTrue(h.getLeft().getLeft().getRight().character.equals("d"));
        assertTrue(h.getLeft().getLeft().getLeft().character.equals("e"));
        
        assertEquals("01", h.getLeft().getRight().getBitString());
        assertTrue(h.getRight().getRight().getBitString().equals("11"));
        assertTrue(h.getRight().getLeft().getBitString().equals("10"));
        assertTrue(h.getLeft().getLeft().getRight().getBitString().equals("001"));
        assertTrue(h.getLeft().getLeft().getLeft().getBitString().equals("000"));
    }
    
//    @Ignore
    @Test
    public void testCreateTree()
    {
        System.out.println("testCreateTree");
        HuffmanEncoder huff = new HuffmanEncoder(p, ensemble);
        double expectedProb = 1.0;
        HuffmanNode root = huff.createTree();
        assertEquals(expectedProb, root.prob, 0.000);
        assertTrue(root.character.contains("a") && 
                root.character.contains("b") &&
                root.character.contains("c") &&
                root.character.contains("d") &&
                root.character.contains("e") &&
                root.character.length() == 5);
        assertEquals(root.getRight().prob, 0.45, 0.000);
        assertEquals(root.getLeft().prob, 0.55, 0.000);
        assertFalse(root.getLeft().isLeaf());
        assertFalse(root.getRight().isLeaf());
        assertTrue(root.getRight().getLeft().isLeaf());
        assertTrue(root.getRight().getRight().isLeaf());
        assertEquals(root.getRight().getRight().getLeft(), null);
        assertTrue(root.getLeft().getLeft().getLeft().isLeaf());
        assertTrue(root.getRight().getRight().isLeaf());
        assertTrue(root.getLeft().getRight().character.equals("a"));
        assertTrue(root.getRight().getRight().character.equals("c"));
        assertTrue(root.getRight().getLeft().character.equals("b"));
        assertTrue(root.getLeft().getLeft().getRight().character.equals("d"));
        assertTrue(root.getLeft().getLeft().getLeft().character.equals("e"));
        assertEquals(root.getLeft().getLeft().getLeft().prob, 0.15, 0.000);
        assertEquals(root.getLeft().getLeft().getRight().prob, 0.15, 0.000);
    }
    
    @Test
    public void testCreatePriorityQueue()
    {
        System.out.println("testCreatePriorityQueue");
        HuffmanEncoder huff = new HuffmanEncoder(p, ensemble);
        PriorityQueue pq = huff.createPriorityQ(p);
        huff.sort(p);
        for(int i = 0; i < p.length; i++){
            HuffmanNode next = (HuffmanNode) pq.poll();
//            System.out.println(next.character + ": " + next.prob);
            assertEquals(next.prob, p[i], 0.0000);
        }
    }
    
    @Test
    public void testSort()
    {
        System.out.println("testSort");
        HuffmanEncoder huff = new HuffmanEncoder(p, ensemble);
        huff.sort(p);
//        for(int i = 0; i < p.length; i++){
//            System.out.println(p[i]);
//        }
        assertEquals(.15, p[0], 0.0000);
    }
    
//    @Test
//    public void testCreateNewArray()
//    {
//        System.out.println("testCreateNewArray");
//        double[] expected = {.2,.25,.25,.3};
//        HuffmanEncoder huff = new HuffmanEncoder(p, ensemble);
//        huff.sort(p);
//        double[] newP = huff.createNewArray(p);
//        for(int i = 0; i < newP.length; i++){
//            System.out.println(newP[i]);
//        }
//        assertTrue(Arrays.equals(expected, newP));
//    }
    
}
