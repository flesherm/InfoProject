/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infoproject;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 *
 * @author Matthew Flesher
 */
public class HuffmanEncoder
{
    private final double[] p;
    private final String[] ensemble;
    
    public HuffmanEncoder(double[] p, String[] ensemble){
        this.p = p;
        this.ensemble = ensemble;
    }
    
    public String[] encodeHuffman(){
        String[] binaryEncodings = new String[p.length];
        return binaryEncodings;
    }
    
    public void createTree(){
        //TODO: implement tree
        // 1. fill priority queue
        Queue pq = createPriorityQ(p);
        // 3. while queue length > 1
        //       take lowest and assign second lowest left
        //       setNode bit
        //       setNode left
        //       setNode right
    }
    
    public PriorityQueue createPriorityQ(double[] p){
        PriorityQueue pq = new PriorityQueue(p.length, new HuffmanComparator());
        for(int i = 0; i < p.length; i++){
            HuffmanNode node = new HuffmanNode(p[i], ensemble[i]);
            pq.add(node);
        }
        return pq;
    }
    
    public void sort(double[] p){
        Arrays.sort(p);
    }
    
    public double[] createNewArray(double[] sortedP){
        if(sortedP.length > 1){
            double[] newP = new double[sortedP.length - 1];
            //set 0 index to the sum of the two lowest values
            newP[0] = sortedP[0] + sortedP[1];
            //add the rest
            for(int i = 2; i < sortedP.length; i++){
                newP[i-1] = sortedP[i];
            }
            sort(newP);
            return newP;
        }else{
            return sortedP;
        }
    }
}
