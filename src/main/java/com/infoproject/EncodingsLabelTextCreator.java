/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infoproject;

import java.util.PriorityQueue;

/**
 *
 * @author Matthew Flesher
 */
public class EncodingsLabelTextCreator
{
    private String labelText = "{ ";
    private final PriorityQueue leafQ = new PriorityQueue(new AlphComparator());
    HuffmanNode root;
    
    public EncodingsLabelTextCreator(HuffmanNode root){
        this.root = root;
        createLeavesBitStrings(root);
        alphabetizeLeafs(root);
        createLabelText();
    }
    
    private void createLabelText(){
        while(!leafQ.isEmpty()){
            HuffmanNode hn = (HuffmanNode) leafQ.poll();
            labelText = getLabelText() + hn.character + ": " + hn.getBitString() + ", ";
        }
        labelText = getLabelText().substring(0, getLabelText().length() - 2) + " }";
    }
    
    private void alphabetizeLeafs(HuffmanNode rootNode){
        if(rootNode.isLeaf()){
            leafQ.add(rootNode);
        }
        if(rootNode.getLeft() != null){
            alphabetizeLeafs(rootNode.getLeft());
        }
        
        if(rootNode.getRight() != null){
            alphabetizeLeafs(rootNode.getRight());
        }
    }
    
    private void createLeavesBitStrings(HuffmanNode rootNode){
        if(rootNode.isLeaf()){
            String bitString = rootNode.getBitString();
            HuffmanNode parent = rootNode.getParent();
            while(parent.getBitString() != null){
                bitString = parent.getBitString() + bitString;
                parent = parent.getParent();
            }
            rootNode.setBitString(bitString);
        }
        if(rootNode.getLeft() != null){
            createLeavesBitStrings(rootNode.getLeft());
        }
        
        if(rootNode.getRight() != null){
            createLeavesBitStrings(rootNode.getRight());
        }
    }

    /**
     * @return the labelText
     */
    public String getLabelText()
    {
        return labelText;
    }
}
