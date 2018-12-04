/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infoproject;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
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
    private final Map<String, String> encodings = new HashMap<>();;
    
    public HuffmanEncoder(double[] p, String[] ensemble){
        this.p = p;
        this.ensemble = ensemble;
    }
    
    public Map<String, String> encodeHuffman(HuffmanNode root){    
        traverseTree(root);
        return encodings;
    }
    
    
    public void traverseTree(HuffmanNode root){
        if(root.isLeaf()){
            String bitString = root.getBitString();
            HuffmanNode parent = root.getParent();
            while(parent.getBitString() != null){
                bitString = parent.getBitString() + bitString;
                parent = parent.getParent();
            }
            root.setBitString(bitString);
            //Add to existing String[] array of encodings
            encodings.put(root.character, root.getBitString());
//            System.out.println(root.character + " : " + bitString);
        }
        if(root.getLeft() != null){
            traverseTree(root.getLeft());
        }
        
        if(root.getRight() != null){
            traverseTree(root.getRight());
        }
    }
    
    public HuffmanNode createTree(){
        //Fill priority queue
        Queue pq = createPriorityQ(p);
        // |Ax| - 1 steps per pg. 99 of book
        while(pq.size() > 1){
        //create New HuffmanNode that probs equals sum of two lowest Nodes
            HuffmanNode lowestProbNode = (HuffmanNode) pq.poll();
            HuffmanNode secondLowestProbNode = (HuffmanNode) pq.poll();
            lowestProbNode.setBitString("1"); //right set to 1 by default
            secondLowestProbNode.setBitString("0"); //left set to 0 by default
            double newNodeProb = lowestProbNode.prob + secondLowestProbNode.prob;
            String newNodeChar = lowestProbNode.character + secondLowestProbNode.character;
            HuffmanNode newNode = new HuffmanNode(newNodeProb, newNodeChar);
        //setNode right to lowest
            newNode.setLeft(secondLowestProbNode);
        //setNode left to second lowest
            newNode.setRight(lowestProbNode);
            secondLowestProbNode.setParent(newNode);
            lowestProbNode.setParent(newNode);
            pq.add(newNode);
        }
        HuffmanNode root = (HuffmanNode) pq.poll();
        return root;
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
    
}
