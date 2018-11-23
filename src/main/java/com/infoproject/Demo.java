/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infoproject;

import javax.swing.SwingUtilities;

/**
 *
 * @author matthewflesher
 */
public class Demo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Create an instance of the DateSelector
                Display demo = new Display();
                demo.setVisible(true);
            }
        });
    }
    
}
