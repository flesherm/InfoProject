/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import org.apache.commons.math3.util.Precision;

/**
 *
 * @author matthewflesher
 */
public class ArrayParserUtils {
    
    private ArrayParserUtils(){};
    
    public static String[] parseCommaSeparatedStrings(String ens){
        String[] ensemble = ens.split(",");
        trimEach(ensemble);
        return ensemble;
    }
    
    public static double[] parseIntoArrayOfDoubles(String[] trimmedArray){
        double[] probs = new double[trimmedArray.length];
        for(int i = 0; i < trimmedArray.length; i++){
            probs[i] = Double.parseDouble(trimmedArray[i]);
        }
        return probs;
    }
    
    public static boolean sumIsOne(double[] probs){
        double sum = 0;
        for(int i = 0; i < probs.length; i++){
            sum = sum + probs[i];
        }
        sum = round(sum, 1);
        return sum == 1.0;
    }
    
    private static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
}
    
    public static boolean areAllPositive(double[] probs){
        for(int i = 0; i < probs.length; i++){
            if(probs[i] < 0){
                return false;
            }
        }
        return true;
    }
    
    public static boolean arraysAreSameLength(String[] one, String[] two){
        return one.length == two.length;
    }
    
    public static void printDoubleArray(double[] dubs){
        for(double d : dubs){
            System.out.println(Precision.round(d, 1));
        }
    }
    
    public static void printArray(String[] st){
        for(String s : st){
            System.out.println(s);
        }
    }
    
    private static void trimEach(String[] stringArray){
        for(int i = 0; i < stringArray.length; i++){
            stringArray[i] = stringArray[i].trim();
        }
    }
}
