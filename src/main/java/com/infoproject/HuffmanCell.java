/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infoproject;

import javax.swing.JLabel;

/**
 *
 * @author Matthew Flesher
 */
public class HuffmanCell
{
    private JLabel label;
    private HuffmanNode node;

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
    
}
