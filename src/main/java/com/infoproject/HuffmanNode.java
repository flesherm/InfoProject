/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infoproject;

/**
 *
 * @author Matthew Flesher
 */
public class HuffmanNode
{
    double prob;
    String e; // the character assigned from the ensemble
    
    private String bit; // the bits assigned
        
    private HuffmanNode left;
    private HuffmanNode right;
    
    public HuffmanNode(double prob, String e){
        this.prob = prob;
        this.e = e;
    }
    
    public boolean isLeaf(){
        assert ((getLeft() == null) && (getRight() == null)) || ((getLeft() != null) && (getRight() != null));
        return (getLeft() == null) && (getRight() == null);
    }
    
    /**
     * @return the bit
     */
    public String getBit() {
        return bit;
    }

    /**
     * @param bit the bit to set
     */
    public void setBit(String bit) {
        this.bit = bit;
    }

    /**
     * @return the left
     */
    public HuffmanNode getLeft() {
        return left;
    }

    /**
     * @param left the left to set
     */
    public void setLeft(HuffmanNode left) {
        this.left = left;
    }

    /**
     * @return the right
     */
    public HuffmanNode getRight() {
        return right;
    }

    /**
     * @param right the right to set
     */
    public void setRight(HuffmanNode right) {
        this.right = right;
    }
    
}
