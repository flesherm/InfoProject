/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infoproject;

import org.apache.commons.math.stat.StatUtils;
import org.apache.commons.math3.util.Precision;

/**
 *
 * @author matthewflesher
 */
public class EntropyCalculator {
    
    private EntropyCalculator(){};
    
    public static double calculateEntropy(double p){
        return Math.log(1/p) / Math.log(2);
    }
    
    public static double[] calculateEntropyOfEach(double[] probs){
        double[] ent = new double[probs.length];
        for(int i = 0; i < probs.length; i++){
            ent[i] = calculateEntropy(probs[i]);
        }
        return ent;
    }
    
    public static double calculateEntropyOfEnsemble(double[] probs){
        double[] temp = calculateEntropyOfEach(probs);
        for(int i = 0; i < probs.length; i++){
            temp[i] = probs[i] * temp[i];
        }
        return StatUtils.sum(temp);
    }
    
    public static double roundTo4decimalPoints(double d){
        return Precision.round(d, 4);
    }
}
