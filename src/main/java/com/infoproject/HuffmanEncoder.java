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

    /**
     * @return the pq
     */
    public PriorityQueue getPq()
    {
        return pq;
    }
}
