/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infoproject;

import java.util.Comparator;

/**
 *
 * @author Matthew Flesher
 */
public class HuffmanComparator implements Comparator<HuffmanNode>
{
    @Override
    public int compare(HuffmanNode x, HuffmanNode y) 
    { 
        if((x.prob - y.prob) < 0){
            return -1;
        }else if((x.prob - y.prob) > 0){
            return 1;
        }else{
            return 0;
        }
    }
}
