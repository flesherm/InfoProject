package com.infoproject;

import java.util.PriorityQueue;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Matthew Flesher
 */
public class EncodingsLabelCreator
{
    private String labelText = "{ ";
    private final PriorityQueue leafQ = new PriorityQueue(new AlphComparator());
    public HuffmanCell[][] cells;
    
    public EncodingsLabelCreator(HuffmanCell[][] cells){
        this.cells = cells;
        createLeavesBitStrings();
        alphabetizeLeafs();
        createLabelText();
    }
    
    private void createLabelText(){
        while(!leafQ.isEmpty()){
            HuffmanNode hn = (HuffmanNode) leafQ.poll();
            labelText = getLabelText() + hn.character + ": " + hn.getBitString() + ", ";
        }
        labelText = getLabelText().substring(0, getLabelText().length() - 2) + " }";
    }
    
    private void alphabetizeLeafs(){
        for(int r = 1; r < cells.length; r++){
            for(int c = 1; c < cells[r].length; c++){
                if(c==1){
                    leafQ.add(cells[r][c].getNode());
                }
            }
        }
    }
    
    private void createLeavesBitStrings(){
        for(int r = 1; r < cells.length; r++){
            for(int c = 1; c < cells[r].length; c++){
                if(c==1){
                    HuffmanNode hn = cells[r][c].getNode();
                    String bitString = hn.getBitString();
                    HuffmanNode parent = hn.getParent();
                    while(parent.getBitString() != null){
                        bitString = parent.getBitString() + bitString;
                        parent = parent.getParent();
                    }
                    hn.setBitString(bitString);
                    cells[r][c].setNode(hn);
                }
            }
        }
    }

    /**
     * @return the labelText
     */
    public String getLabelText(){
        return labelText;
    }
}
