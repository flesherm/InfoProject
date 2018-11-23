/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infoproject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JTextArea;

/**
 *
 * @author matthewflesher
 */
public class CreateHuffmanDisplayAction implements ActionListener{
    
    private final JTextArea ensembleTextArea;
    private final JTextArea probabilitiesTextArea;

    public CreateHuffmanDisplayAction(JTextArea ensembleTextArea, 
            JTextArea probabilitiesTextArea){
        this.ensembleTextArea = ensembleTextArea;
        this.probabilitiesTextArea = probabilitiesTextArea;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String message = String.format("{'%s'}, {'%s'}",
                  ensembleTextArea.getText(), probabilitiesTextArea.getText());
              System.out.println(message);
    }
    
}
