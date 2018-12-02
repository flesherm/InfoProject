/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infoproject;

import static com.infoproject.Constants.*;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

/**
 *
 * @author matthewflesher
 */
public final class Display extends JFrame{
    
    JLabel l1,l2,b1,b2,b3,b4;
    JTextArea ensembleTextArea;
    JTextArea probabilitiesTextArea;
    JButton button;
    
    public Display(){
        initializeComponents();
    }
    
    
    public void initializeComponents() { 
        setTitle("M. Flesher Info Engineering.");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
        setLocationRelativeTo(null);
    }
    
}
