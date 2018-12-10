/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infoproject;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author matthewflesher
 */
public class CellDisplayCleaner {
    
    private CellDisplayCleaner(){}
    
    public static void removeDuplicateParentLabels(HuffmanCell[][] cells){
        for(int c = 1; c < cells[c].length; c++){
            Set<HuffmanNode> temp = new HashSet<>();
            for(int r = 1; r < cells.length; r++){
                if(!temp.contains(cells[r][c].getNode())){
                    temp.add(cells[r][c].getNode());
                }
                else{
                    cells[r][c].getLabel().setText("");
//                    if(!cells[r][c].getNode().isLeaf()){
//                        cells[r][c].getLabel().setText("");
//                    }
                }
            }
        }
    }
    
}
