/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Matthew Flesher
 */
public class MapUtils
{
    public static void printMap(Map<String, String> map){
        for(String k : map.keySet()){
            if(map.get(k) != null){
                System.out.println(k + ": " + map.get(k));
            }
        }
    }
    
    public static String createMapString(Map<String, String> map){
        String m = "";
        for(String k : map.keySet()){
            if(map.get(k) != null){
                m = m + k + ": " + map.get(k) + "\n";
            }
        }
        return m;
    }
    
    public static Map<String, String> createMap(String[] ens, 
            String[] probs){
        Map<String, String> map = new HashMap<>();
        for(int i = 0; i < probs.length; i++){
            map.put(ens[i], probs[i]);
        }
        return map;
    }
}
