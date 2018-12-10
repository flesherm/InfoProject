/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infoproject;

import java.util.Comparator;

/**
 *
 * @author matthewflesher
 */
public class AlphComparator implements Comparator<HuffmanNode>{

    public AlphComparator() {
    }

    @Override
    public int compare(HuffmanNode o1, HuffmanNode o2) {
        //returns positive if o1 > o2; negative if o2 > o1; 0 otherwise
        return o1.character.compareTo(o2.character);  
    }
    
}
