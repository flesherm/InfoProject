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
    String character; // the character assigned from the ensemble
    
    private String bitString; // the bits assigned
        
    private HuffmanNode left;
    private HuffmanNode right;
    private HuffmanNode parent;
    
    public HuffmanNode(double prob, String character){
        this.prob = prob;
        this.character = character;
    }
    
    public boolean isLeaf(){
        assert ((getLeft() == null) && (getRight() == null)) || ((getLeft() != null) && (getRight() != null));
        return (getLeft() == null) && (getRight() == null);
    }
    
    /**
     * @return the bitString
     */
    public String getBitString() {
        return bitString;
    }

    /**
     * @param bitString the bitString to set
     */
    public void setBitString(String bitString) {
        this.bitString = bitString;
    }

    /**
     * @return the left
     */
    public HuffmanNode getLeft() {
        if(left != null){
            return left;
        }
        return null;
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
        if(right != null){
            return right;
        }
        return null;
    }

    /**
     * @param right the right to set
     */
    public void setRight(HuffmanNode right) {
        this.right = right;
    }

    /**
     * @return the parent
     */
    public HuffmanNode getParent()
    {
        return parent;
    }

    /**
     * @param parent the parent to set
     */
    public void setParent(HuffmanNode parent)
    {
        this.parent = parent;
    }
    
}
