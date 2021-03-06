/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infoproject;

/**
 *
 * @author matthewflesher
 */
public class Constants {
    public static final int FRAME_WIDTH = 840;
    public static final int FRAME_HEIGHT = 1000;
    public static final int TEXT_AREA_WIDTH = 300;
    public static final int TEXT_AREA_HEIGHT = 25;
    public static final int BUTTON_WIDTH = 300;
    public static final int BUTTON_HEIGHT = 30;
//    public static final int BIT_BOX_WIDTH = 25;
    
    public static final int MAX_CHAR = 6;
    
    public static final int M_WIDTH = 160;
    
    public static final int TEXT_AREA_X = (FRAME_WIDTH / 2) 
            - (TEXT_AREA_WIDTH / 2);
    
    public static final int TEXT_AREA_ONE_Y = (FRAME_HEIGHT / 2) / 2;
    public static final int TEXT_AREA_TWO_Y = TEXT_AREA_ONE_Y + 
            (TEXT_AREA_HEIGHT * 2);
    public static final int BUTTON_Y = TEXT_AREA_TWO_Y + 
            (TEXT_AREA_HEIGHT * 2);
    
    public static final String TEXT_AREA_ONE_HINT = "Enter ensemble here";
    public static final String TEXT_AREA_TWO_HINT = "Enter probabilities here";
    public static final int DISPLAY_Y = BUTTON_Y + 40;
}
