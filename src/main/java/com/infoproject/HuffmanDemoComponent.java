/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infoproject;

import static com.infoproject.Constants.*;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;

/**
 *
 * @author Matthew Flesher
 */
public class HuffmanDemoComponent
{
    private final HuffmanNode root;
    private final String[] ensemble;
    private HuffmanCell[][] cells;
    private JButton next;
    private static final int W = 40;
    private static final int X = TEXT_AREA_X;
    private static final int Y = DISPLAY_Y + W *3;
    
    Color blue;
    Color maize;
    
    public HuffmanDemoComponent(HuffmanNode root, String[] ensemble){
        this.root = root;
        this.ensemble = ensemble;
        initCells();
        initButton();
    }
    
    public List<JLabel> createDemoLabels(){
        List<JLabel> labels = new ArrayList<>();
        addLabels(labels);
        return labels;
    }
    
    private void initButton(){
        next = new JButton("next");
        blue = new Color(0,39,76);
        maize = new Color(255, 203, 5);
        next.setForeground(blue);
        next.setBackground(maize);
        next.setContentAreaFilled(true);
        next.setOpaque(true);
        next.setBounds(X, Y + (cells.length * W), BUTTON_WIDTH / 3, W);
        next.addActionListener(null);
    }
    
    private void initCells(){
        //top left cell is empty node and label but sets label size
        //the furthest left column is the characters in the ensemble
        //the top column is reserved to indicate steps required, always 1 less 
        // than characters in ensemble
        cells = new HuffmanCell[ensemble.length + 1][ensemble.length + 1];
        cells[0][0] = new HuffmanCell();
        JLabel topLeftCorner = new JLabel("");
        topLeftCorner.setBounds(X, Y, W, W); //width and height same for box
        cells[0][0].setLabel(topLeftCorner);
        fillStartingCells();
        traverseTreeAndFillCells();
    }
    
    private void traverseTreeAndFillCells(){
        PriorityQueue pq = new PriorityQueue<>();
//        for()
    }
    
    private void fillStartingCells(){
        for(int i = 0; i < cells.length - 1; i++){
            cells[i+1][0] = new HuffmanCell();
            JLabel temp = new JLabel(ensemble[i]);
            temp.setBounds(X, Y + (W * (i+1)), W, W); //width and height same for box
            cells[i+1][0].setLabel(temp);
        }
        for(int i = 0; i < cells[0].length - 2; i++){
            cells[0][i+1] = new HuffmanCell();
            JLabel temp = new JLabel("step " + (i+1));
            temp.setBounds(X + (W * (i+1)), Y, W, W); //width and height same for box
            cells[0][i+1].setLabel(temp);
        }
    }
    
    private void addLabels(List<JLabel> labels){
        for (int row=0; row < cells.length; row++){
            for (int col=0; col < cells[row].length; col++){
                if(cells[row][col] != null){
                    JLabel label = cells[row][col].getLabel();
                    if(label != null){
                        labels.add(label);
                    }
                }
            }
        }
    }
    
    public List<Line> createLineList(){
        return null;
    }

    /**
     * @return the next
     */
    public JButton getNextButton()
    {
        return next;
    }
}
