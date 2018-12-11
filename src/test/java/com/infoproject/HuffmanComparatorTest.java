/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infoproject;

import java.util.PriorityQueue;
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
public class HuffmanComparatorTest
{
    
    String[] ensemble = {"a","b","c","d","e"};
    double[] p = {.25,.25,.2,.15,.15};
    double[] p2 = {.3,.1,.25,.1,.25};
    
    public HuffmanComparatorTest()
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
     * Test of compare method, of class HuffmanComparator.
     */
    @Test
    public void testCompare()
    {
        System.out.println("compare");
        HuffmanEncoder huffman = new HuffmanEncoder(p2, ensemble);
        HuffmanNode root = huffman.createTree();
        HuffmanDemoComponent comp = new HuffmanDemoComponent(root, ensemble);
        HuffmanCell[][] cells = comp.cells;
        PriorityQueue pq = new PriorityQueue(new HuffmanComparator());
        for(int r = 1; r < cells.length; r++){
            pq.add(cells[r][1].getNode());
        }
        assertEquals(5, pq.size());
        HuffmanNode one = (HuffmanNode) pq.poll();
        HuffmanNode two = (HuffmanNode) pq.poll();
        HuffmanNode three = (HuffmanNode) pq.poll();
        HuffmanNode four = (HuffmanNode) pq.poll();
        assertTrue(pq.size() == 1);
        HuffmanNode five = (HuffmanNode) pq.poll();
        assertEquals(p2[1], one.prob, 0.00);
        assertEquals(p2[3], two.prob, 0.00);
        assertEquals(p2[2], three.prob, 0.00);
        assertEquals(p2[4], four.prob, 0.00);
        assertEquals(p2[0], five.prob, 0.00);
    }
    
    /**
     * Test of compare method, of class HuffmanComparator.
     */
    @Test
    public void testCompareP()
    {
        System.out.println("testCompareP");
        HuffmanEncoder huffman = new HuffmanEncoder(p, ensemble);
        HuffmanNode root = huffman.createTree();
        HuffmanDemoComponent comp = new HuffmanDemoComponent(root, ensemble);
        HuffmanCell[][] cells = comp.cells;
        PriorityQueue pq = new PriorityQueue(new HuffmanComparator());
        for(int r = 1; r < cells.length; r++){
            pq.add(cells[r][1].getNode());
        }
        assertEquals(5, pq.size());
        HuffmanNode one = (HuffmanNode) pq.poll();
        HuffmanNode two = (HuffmanNode) pq.poll();
        HuffmanNode three = (HuffmanNode) pq.poll();
        HuffmanNode four = (HuffmanNode) pq.poll();
        assertTrue(pq.size() == 1);
        HuffmanNode five = (HuffmanNode) pq.poll();
        assertEquals(p[4], one.prob, 0.00);
        assertEquals(p[3], two.prob, 0.00);
        assertEquals(p[2], three.prob, 0.00);
        assertEquals(p[1], four.prob, 0.00);
        assertEquals(p[0], five.prob, 0.00);
    }
    
}
