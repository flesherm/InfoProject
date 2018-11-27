/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infoproject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 *
 * @author Matthew Flesher
 */
public class HuffmanEncoder
{
    private double[] p;
    private PriorityQueue pq;
    
    public HuffmanEncoder(double[] p){
        this.p = p;
    }
    
    public String[] encodeHuffman(){
        String[] binaryEncodings = new String[p.length];
        return binaryEncodings;
    }
    
    public void createQ(double[] p){
        List<Double> probs = new ArrayList(Arrays.asList(p));
        pq = new PriorityQueue(p.length, new HuffmanComparator());
        pq.addAll(probs);
    }
    
    public double[] createNewArray(double[] probs){
        return null;
    }

    /**
     * @return the pq
     */
    public PriorityQueue getPq()
    {
        return pq;
    }
}
