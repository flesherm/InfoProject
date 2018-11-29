/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

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
}
