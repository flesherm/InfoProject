/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infoproject;

import static com.infoproject.Constants.*;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author matthewflesher
 */
public final class Display extends JFrame{
    
    JLabel labelOne;
    JTextArea ensembleTextArea;
    JTextArea probabilitiesTextArea;
    JButton button;
    
    public Display(){
        initializeComponents();
    }
    
    
    public void initializeComponents() { 
        setTitle("M. Flesher Info Engineering.");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setInputBoxes();
        setLayout(null);
        setSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
        setLocationRelativeTo(null);
    }
    
    public void setInputBoxes(){
        ensembleTextArea = new JTextArea();
        ensembleTextArea.setBounds(TEXT_AREA_X, TEXT_AREA_ONE_Y, 
                TEXT_AREA_WIDTH, TEXT_AREA_HEIGHT);
        probabilitiesTextArea = new JTextArea();
        probabilitiesTextArea.setBounds(TEXT_AREA_X, TEXT_AREA_TWO_Y, 
                TEXT_AREA_WIDTH, TEXT_AREA_HEIGHT);
        button = new JButton("Click To Create Arrays");
        button.setBounds(TEXT_AREA_X, BUTTON_Y, BUTTON_WIDTH, BUTTON_HEIGHT);
        button.addActionListener(new CreateHuffmanDisplayAction(ensembleTextArea,
            probabilitiesTextArea, this)); 
        add(ensembleTextArea);
        add(probabilitiesTextArea);
        add(button);
    }
}
