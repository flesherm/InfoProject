/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infoproject;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.time.DayOfWeek;
import java.time.LocalTime;
import javax.swing.JFrame;

/**
 *
 * @author matthewflesher
 */
public final class Display extends JFrame{
    
    public Display(){
        initializeComponents();
    }
    
    
    public void initializeComponents() { 
        setTitle("M. Flesher Info Engineering.");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        setSize(new Dimension(840, 680));
        setLocationRelativeTo(null);
    }
}
