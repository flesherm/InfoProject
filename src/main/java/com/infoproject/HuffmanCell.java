/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infoproject;

import javax.swing.JLabel;
import javax.swing.JTextArea;

/**
 *
 * @author Matthew Flesher
 */
public class HuffmanCell
{
    private JLabel label;
    private HuffmanNode node;
    private JTextArea bitTextArea;
    private JLabel bitLabel;

    /**
     * @return the label
     */
    public JLabel getLabel()
    {
        return label;
    }

    /**
     * @param label the label to set
     */
    public void setLabel(JLabel label)
    {
        this.label = label;
    }

    /**
     * @return the node
     */
    public HuffmanNode getNode()
    {
        return node;
    }

    /**
     * @param node the node to set
     */
    public void setNode(HuffmanNode node)
    {
        this.node = node;
    }

    /**
     * @return the bitTextArea
     */
    public JTextArea getBitTextArea()
    {
        return bitTextArea;
    }

    /**
     * @param bitTextArea the bitTextArea to set
     */
    public void setBitTextArea(JTextArea bitTextArea)
    {
        this.bitTextArea = bitTextArea;
    }

    /**
     * @return the bitLabel
     */
    public JLabel getBitLabel()
    {
        return bitLabel;
    }

    /**
     * @param bitLabel the bitLabel to set
     */
    public void setBitLabel(JLabel bitLabel)
    {
        this.bitLabel = bitLabel;
    }
    
}
