package com.infoproject;

import static com.infoproject.Constants.FRAME_HEIGHT;
import static com.infoproject.Constants.FRAME_WIDTH;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

public final class HuffmanFrame extends JFrame {
    
    public HuffmanFrame() {
        initializeComponents();
    }

    
    public void initializeComponents() { 
        setTitle("Matt Flesher Info Engineering.");
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        JPanel board = new HuffmanBoard();
        JPanel scrollPanel = new JPanel(new BorderLayout());
        scrollPanel.add(new JScrollPane(board));
        add(scrollPanel, BorderLayout.CENTER);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
        setLocationRelativeTo(null);
    }
    
}
