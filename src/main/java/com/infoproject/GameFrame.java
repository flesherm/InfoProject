package com.infoproject;

import static com.infoproject.Constants.FRAME_HEIGHT;
import static com.infoproject.Constants.FRAME_WIDTH;
import java.awt.Dimension;
import javax.swing.JFrame;

public final class GameFrame extends JFrame {
    
    public GameFrame() {
        initializeComponents();
    }

    
    public void initializeComponents() { 
        setTitle("Matt Flesher Info Engineering.");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
        setLocationRelativeTo(null);
        add(new GameBoard());
    }
    
}
