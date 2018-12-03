/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infoproject;

import static com.infoproject.Constants.BUTTON_HEIGHT;
import static com.infoproject.Constants.BUTTON_WIDTH;
import static com.infoproject.Constants.BUTTON_Y;
import static com.infoproject.Constants.TEXT_AREA_HEIGHT;
import static com.infoproject.Constants.TEXT_AREA_WIDTH;
import static com.infoproject.Constants.TEXT_AREA_X;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextArea;

/**
 *
 * @author Matthew Flesher
 */
public class HuffmanDemoComponent
{
    JLabel l1;
    JTextArea ta;
    JButton button;
    public List<JComponent> createDemoComponents(HuffmanNode root){
        List<JComponent> components = new ArrayList<>();
        l1 = new JLabel("Test Label:");
        l1.setForeground(Color.cyan);
        l1.setBounds(TEXT_AREA_X, BUTTON_Y + 400
                , TEXT_AREA_WIDTH, BUTTON_HEIGHT);
        button = new JButton("New Button");
        button.setBounds(TEXT_AREA_X, BUTTON_Y + 300, BUTTON_WIDTH, BUTTON_HEIGHT);
        ta = new JTextArea();
        ta.setBounds(TEXT_AREA_X, BUTTON_Y + 500, 
                TEXT_AREA_WIDTH, TEXT_AREA_HEIGHT);
        components.add(l1);
        components.add(button);
        components.add(ta);
        return components;
    }
    
    public List<Line> createLineList(){
        return null;
    }
}
