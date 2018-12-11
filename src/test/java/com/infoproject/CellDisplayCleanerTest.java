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
 * @author matthewflesher
 */
public class CellDisplayCleanerTest {
    
    String[] ensemble = {"a","b","c","d","e"};
    double[] p = {.25,.25,.2,.15,.15};
    double[] p2 = {.3,.1,.25,.1,.25};
    
    public CellDisplayCleanerTest() {
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
     * Test of removeDuplicateParentLabels method, of class CellDisplayCleaner.
     */
    @Test
    public void testRemoveDuplicateParentLabels() {
        System.out.println("removeDuplicateParentLabels");
        HuffmanEncoder huffman = new HuffmanEncoder(p, ensemble);
        HuffmanNode root = huffman.createTree();
        HuffmanDemoComponent comp = new HuffmanDemoComponent(root, ensemble);
        HuffmanCell[][] cells = comp.cells;
        CellDisplayCleaner.removeDuplicateParentLabels(cells);
        assertEquals(6, cells.length);
        assertEquals(5, cells[0].length);
        assertTrue(cells[0][0].getLabel().getText().isEmpty());
        assertEquals("step 1", cells[0][1].getLabel().getText());
        assertEquals("step 2", cells[0][2].getLabel().getText());
        assertEquals("step 3", cells[0][3].getLabel().getText());
        assertEquals("step 4", cells[0][4].getLabel().getText());
        assertEquals("a", cells[1][0].getLabel().getText());
        assertEquals("b", cells[2][0].getLabel().getText());
        assertEquals("c", cells[3][0].getLabel().getText());
        assertEquals("d", cells[4][0].getLabel().getText());
        assertEquals("e", cells[5][0].getLabel().getText());
        
        assertEquals("0.25", cells[1][1].getLabel().getText());
        assertEquals("0.25", cells[2][1].getLabel().getText());
        assertEquals("0.2", cells[3][1].getLabel().getText());
        assertEquals("0.15", cells[4][1].getLabel().getText());
        assertEquals("0.15", cells[5][1].getLabel().getText());
        
        assertEquals("0.25", cells[1][2].getLabel().getText());
        assertEquals("0.25", cells[2][2].getLabel().getText());
        assertEquals("0.2", cells[3][2].getLabel().getText());
        assertEquals("0.3", cells[4][2].getLabel().getText());
        assertEquals("", cells[5][2].getLabel().getText());
        
        assertEquals("0.25", cells[1][3].getLabel().getText());
        assertEquals("0.45", cells[2][3].getLabel().getText());
        assertEquals("", cells[3][3].getLabel().getText());
        assertEquals("0.3", cells[4][3].getLabel().getText());
        assertEquals("", cells[5][3].getLabel().getText());
        
        assertEquals("0.55", cells[1][4].getLabel().getText());
        assertEquals("0.45", cells[2][4].getLabel().getText());
        assertEquals("", cells[3][4].getLabel().getText());
        assertEquals("", cells[4][4].getLabel().getText());
        assertEquals("", cells[5][4].getLabel().getText());
    }
//    @Ignore
    @Test
    public void testRemoveDuplicateParentLabels2() {
        System.out.println("removeDuplicateParentLabels2");
        HuffmanEncoder huffman = new HuffmanEncoder(p2, ensemble);
        HuffmanNode root = huffman.createTree();
        HuffmanDemoComponent comp = new HuffmanDemoComponent(root, ensemble);
        HuffmanCell[][] cells = comp.cells;
        CellDisplayCleaner.removeDuplicateParentLabels(cells);
        assertEquals(6, cells.length);
        assertEquals(5, cells[0].length);
        assertTrue(cells[0][0].getLabel().getText().isEmpty());
        assertEquals("step 1", cells[0][1].getLabel().getText());
        assertEquals("step 2", cells[0][2].getLabel().getText());
        assertEquals("step 3", cells[0][3].getLabel().getText());
        assertEquals("step 4", cells[0][4].getLabel().getText());
        assertEquals("a", cells[1][0].getLabel().getText());
        assertEquals("b", cells[2][0].getLabel().getText());
        assertEquals("c", cells[3][0].getLabel().getText());
        assertEquals("d", cells[4][0].getLabel().getText());
        assertEquals("e", cells[5][0].getLabel().getText());
        
        assertEquals("0.3", cells[1][1].getLabel().getText());
        assertEquals("0.1", cells[2][1].getLabel().getText());
        assertEquals("0.25", cells[3][1].getLabel().getText());
        assertEquals("0.1", cells[4][1].getLabel().getText());
        assertEquals("0.25", cells[5][1].getLabel().getText());
        
        assertEquals("0.3", cells[1][2].getLabel().getText());
        assertEquals("0.2", cells[2][2].getLabel().getText());
        assertEquals("0.25", cells[3][2].getLabel().getText());
        assertEquals("", cells[4][2].getLabel().getText());
        assertEquals("0.25", cells[5][2].getLabel().getText());
        
        assertEquals("0.3", cells[1][3].getLabel().getText());
        assertEquals("0.45", cells[2][3].getLabel().getText());
        assertEquals("0.25", cells[3][3].getLabel().getText());
        assertEquals("", cells[4][3].getLabel().getText());
        assertEquals("", cells[5][3].getLabel().getText());
        
        assertEquals("0.55", cells[1][4].getLabel().getText());
        assertEquals("0.45", cells[2][4].getLabel().getText());
        assertEquals("", cells[3][4].getLabel().getText());
        assertEquals("", cells[4][4].getLabel().getText());
        assertEquals("", cells[5][4].getLabel().getText());
    }
    
}
