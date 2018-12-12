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
import javax.swing.JLabel;

/**
 *
 * @author Matthew Flesher
 */
public class HuffmanDemoComponent
{
    private final HuffmanNode root;
    private final String[] ensemble;
    public HuffmanCell[][] cells;
    public final List<Line> lineList = new ArrayList<>();
    private final List<JLabel> bitList = new ArrayList<>();
//    public final List<JTextField> boxes = new ArrayList<>();
    private JButton next;
    private static final int W = 60;
    private static final int X = TEXT_AREA_X - 50;
    private static final int Y = DISPLAY_Y + W *2;
    
    Color blue;
    Color maize;
    
    PriorityQueue leafQ = new PriorityQueue(new AlphComparator());
    
    public HuffmanDemoComponent(HuffmanNode root, String[] ensemble){
        this.root = root;
        this.ensemble = ensemble;
        initCells();
        initButton();
    }
    
    public List<JLabel> createDemoLabels(){
        List<JLabel> labels = new ArrayList<>();
        addLabels(labels);
        createLines();
        addBitLabels(labels);
        addEncodingsLabel(labels);
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
        next.setBounds(X, Y + (cells.length * W), BUTTON_WIDTH / 3, BUTTON_HEIGHT);
        next.addActionListener(null);
    }
    
    private void initCells(){
        //top left cell is empty parent and label but sets label size
        //the furthest left column is the characters in the ensemble
        //the top column is reserved to indicate steps required, always 1 less 
        // than characters in ensemble
        cells = new HuffmanCell[ensemble.length + 1][ensemble.length];
        cells[0][0] = new HuffmanCell();
        JLabel topLeftCorner = new JLabel("");
        topLeftCorner.setBounds(X, Y, W, W); //width and height same for box
        cells[0][0].setLabel(topLeftCorner);
        fillStartingCells();
        alphabetizeLeaves(root);
        for(int i = 1; i < cells[0].length; i++){
            fillCol(i);
        }
        //TODO: add input boxes to HuffmanCell
    }
    
    private void fillCol(int col){
        if(col > 0){
            for(int i = 1; i < cells.length; i++){
                cells[i][col] = new HuffmanCell();
                if(col == 1){
                    cells[i][col].setNode((HuffmanNode) leafQ.poll());
                    JLabel temp = new JLabel(cells[i][col].getNode().prob + "");
                    temp.setBounds(X + W*col, Y + (W * (i)), W, W); //width and height same for box
                    cells[i][col].setLabel(temp);
                }else{
                    HuffmanNode child = cells[i][col-1].getNode();
                    if(child != null){
                        HuffmanNode parent = child.getParent();
                        if(parent != null){
                            JLabel temp = new JLabel();
                            if(isLowest(col-1, child)){
                                cells[i][col].setNode(parent);
                                cells[i][col].getNode().isParent = true;
                                temp.setText(cells[i][col].getNode().prob + "");
//                                createBitLabel(cells[i][col-1]);
                            }else if(isSecondLowest(col-1, child)){
                                cells[i][col].setNode(parent);
                                cells[i][col].getNode().isParent = true;
                                temp.setText(cells[i][col].getNode().prob + "");
//                                createBitLabel(cells[i][col-1]);
//                                temp.setText("");
                            }else{
                                cells[i][col].setNode(child);
                                temp.setText(cells[i][col].getNode().prob + "");                     
                            }
                            temp.setBounds(X + W*col, Y + (W * (i)), W, W); //width and height same for box
                            cells[i][col].setLabel(temp);
                        }
                    }
                }
            }
        }
    }
    
    public boolean isLowest(int col, HuffmanNode n){
        PriorityQueue q = new PriorityQueue(new HuffmanComparator());
        for(int i = 1; i < cells.length; i++){
            HuffmanCell c = cells[i][col];
            if(c != null){
                HuffmanNode node = c.getNode();
                if(node != null && !c.getLabel().getText().isEmpty()){
                    q.add(node);
                }
            }
        }
        HuffmanNode one = (HuffmanNode) q.poll();
//        System.out.println(one.prob + "");
        return n.equals(one);
    }
    
    public boolean isSecondLowest(int col, HuffmanNode n){
        PriorityQueue q = new PriorityQueue(new HuffmanComparator());
        for(int i = 1; i < cells.length; i++){
            HuffmanCell c = cells[i][col];
            if(c != null){
                HuffmanNode node = c.getNode();
                if(node != null && !c.getLabel().getText().isEmpty()){
                    q.add(node);
                }
            }
        }
        HuffmanNode one = (HuffmanNode) q.poll();
        HuffmanNode two = (HuffmanNode) q.poll();
        while(one.isParent && two.isParent && one.getLeft().equals(two.getLeft()) 
                && one.getRight().equals(two.getRight()) && !q.isEmpty()){
            two = (HuffmanNode) q.poll();
        }
        return n.equals(two);
    }
    
    private void alphabetizeLeaves(HuffmanNode rootNode){
        if(rootNode.isLeaf()){
            leafQ.add(rootNode);
        }
        if(rootNode.getLeft() != null){
            alphabetizeLeaves(rootNode.getLeft());
        }
        
        if(rootNode.getRight() != null){
            alphabetizeLeaves(rootNode.getRight());
        }
    }
    
//    private void changeTreeNodeBitString(HuffmanNode rootNode, HuffmanNode nodeToChange, 
//            String bitString){
//        if(rootNode.equals(nodeToChange)){
//            rootNode.setBitString(bitString);
//        }
//        if(rootNode.getLeft() != null){
//            changeTreeNodeBitString(rootNode.getLeft(), nodeToChange, bitString);
//        }
//        
//        if(rootNode.getRight() != null){
//            changeTreeNodeBitString(rootNode.getLeft(), nodeToChange, bitString);
//        }
//    }
    
    private void fillStartingCells(){
        for(int i = 1; i < cells.length; i++){
            cells[i][0] = new HuffmanCell();
            JLabel temp = new JLabel(ensemble[i-1]);
            temp.setBounds(X, Y + (W * (i)), W, W); //width and height same for box
            cells[i][0].setLabel(temp);
        }
        for(int i = 1; i < cells[0].length; i++){
            cells[0][i] = new HuffmanCell();
            JLabel temp = new JLabel("step " + (i));
            temp.setBounds(X + (W * (i)), Y, W, W); //width and height same for box
            cells[0][i].setLabel(temp);
        }
    }
    
    private void addLabels(List<JLabel> labels){
        for (int row=0; row < cells.length; row++){
            for (int col=0; col < cells[row].length; col++){
                if(cells[row][col] != null){
                    CellDisplayCleaner.removeDuplicateParentLabels(cells);
                    JLabel label = cells[row][col].getLabel();
                    if(label != null){
                        labels.add(label);
                    }
                }
            }
        }
        //add 1.0 label to top right
        JLabel topRightOne = new JLabel("1.0");
        topRightOne.setBounds(cells[1][cells[1].length - 1].getLabel()
                .getX()+ W,cells[1][cells[1].length - 1].getLabel()
                .getY(), W, W);
//        topRightOne.setForeground(maize);
        labels.add(topRightOne);
        // add encodings to display
//        EncodingsLabelTextCreator enc = new EncodingsLabelTextCreator(root);
//        JLabel encodings = new JLabel(enc.getLabelText());
//        encodings.setBounds(next.getX() + next.getWidth() + 40, next.getY() - next.getHeight() / 2,
//                W*10, W);
//        labels.add(encodings);
    }
    
    private void addEncodingsLabel(List<JLabel> labels){
        // add encodings to display
//        EncodingsLabelTextCreator enc = new EncodingsLabelTextCreator(root);
        EncodingsLabelCreator enc = new EncodingsLabelCreator(cells);
        JLabel encodings = new JLabel(enc.getLabelText());
        encodings.setBounds(next.getX() + next.getWidth() + 40, next.getY() - next.getHeight() / 2,
                W*10, W);
        labels.add(encodings);
    }
    
    private void createLines(){
        //At this point have clean cells and being painted. need to send to same parent
        for (int row=1; row < cells.length; row++){
            for (int col=2; col < cells[row].length; col++){
                //deal with all lines but last row to 1.0
               
                HuffmanCell current = cells[row][col];
                if(!current.getLabel().getText().isEmpty()){
                    HuffmanCell child = cells[row][col-1];
//                    //create Line for all back to previous child
                    createLine(child, current);
                    for(int r = 1; r < cells.length; r++){
                        HuffmanCell sec = cells[r][col-1];
                        if(!sec.getLabel().getText().isEmpty() 
                                && (isSecondLowest(col-1, sec.getNode()) 
                            || isLowest(col-1, sec.getNode()))){
                                if(isLowest(col-1, sec.getNode())){
                                    sec.getNode().setBitString("1");
//                                    changeTreeNodeBitString(root, sec.getNode(),"1");
                                    createBitLabel(sec, false);
                                }else if(isSecondLowest(col-1, sec.getNode())){
                                    sec.getNode().setBitString("0");
//                                    changeTreeNodeBitString(root, sec.getNode(),"0");
                                    createBitLabel(sec, false);
                                }
                                if(sec.getNode().getParent().equals(
                                    current.getNode()) && r != row 
                                        && !sec.getLabel().getText().isEmpty()){
                                    if(isLowest(col-1, sec.getNode()) 
                                            && sec.getNode().getBitString().isEmpty()){
                                        sec.getNode().setBitString("1");
//                                        changeTreeNodeBitString(root, sec.getNode(),"1");
                                        createBitLabel(sec, true);
                                    }else if(isSecondLowest(col-1, sec.getNode())
                                            && sec.getNode().getBitString().isEmpty()){
                                        sec.getNode().setBitString("0");
//                                        changeTreeNodeBitString(root, sec.getNode(),"0");
                                        createBitLabel(sec, true);
                                    }
                                    HuffmanCell parent = current;
                                    createLine(sec, parent);
                                }
                            }
                    }
                    if(col == cells[row].length-1){
                        //add lines at end of last row
                        //TODO: add last column textBox
                        JLabel l = current.getLabel();
                        int x1 = l.getX() + l.getWidth() / 2;
                        int y1 = l.getY() + l.getHeight() / 2;
                        int x2 = x1 + l.getWidth() / 2;
                        int y2 = cells[1][cells[1].length - 1].getLabel().getY() + W/2;
                        Line line = new Line(x1,y1,x2,y2);
//                        cells[1][col].getNode().setBitString("1");
////                        changeTreeNodeBitString(root, cells[1][cells[1].length - 1].getNode(),"1");
//                        createBitLabel(cells[1][cells[1].length - 1], false);
                        cells[row][col].getNode().setBitString("0");
//                        changeTreeNodeBitString(root, cells[2][cells[2].length - 1].getNode(),"0");
                        createBitLabel(cells[row][cells[2].length - 1], true);
                        lineList.add(line);
                    }
                }
            }
        }    
    }
    
    private void createLine(HuffmanCell child, HuffmanCell parent){
                int childX = child.getLabel().getX();
                int parentX = parent.getLabel().getX();
                int childY = child.getLabel().getY();
                int parentY = parent.getLabel().getY();
                int x1 = childX + child.getLabel().getWidth()/2;
                int y1 = childY + child.getLabel().getHeight() / 2;
                int x2 = parentX;
                int y2 = parentY + parent.getLabel().getHeight() / 2;
                Line line = new Line(x1,y1,x2,y2);
                lineList.add(line);
    }
    
    public void createBitLabel(HuffmanCell cell, boolean isDiagonal){
        String bitString = cell.getNode().getBitString();
        if(bitString != null && !bitString.isEmpty() 
                && (bitString.equals("1") || bitString.equals("0"))){
             JLabel cLabel = cell.getLabel();
            if(isDiagonal){
                JLabel l = new JLabel(bitString);
                l.setBounds(cLabel.getX()+W-W/2, 
                        cLabel.getY(), 
                        W, W);
                bitList.add(l); 
            }else{
                JLabel l = new JLabel(bitString);
                l.setBounds(cLabel.getX()+W/2, 
                        cLabel.getY()-5, 
                        W, W);
                bitList.add(l);
            }
        }
    }
    
    private void addBitLabels(List<JLabel> labels){
        for(JLabel bitLabel : bitList){
            labels.add(bitLabel);
        }
    }
    
    
    
//    public void createTextBox(JLabel label, boolean isLowest){
//        //if not isLowest means it is secondLowest
//        JTextField bitBox = new JTextField();
//    
//        if(isLowest){
//            //create bitBox on top of and in the middle of straight across line
//            bitBox.setBounds(label.getX() + label.getWidth()/2, 
//                    label.getY() - Constants.BIT_BOX_WIDTH - 10, 
//                Constants.BIT_BOX_WIDTH, Constants.BIT_BOX_WIDTH);
//        }else{
//            //create bitBox at bottom of diagonal line
//            bitBox.setBounds(label.getX() + label.getWidth()/2, 
//                    label.getY() + label.getHeight(), 
//                Constants.BIT_BOX_WIDTH, Constants.BIT_BOX_WIDTH);
//        }
//        bitBox.requestFocusInWindow();
////        bitBox.setCaretPosition(5);
//        bitBox.addKeyListener(new KeyAdapter() {
//            @Override
//            public void keyTyped(KeyEvent e) { 
//                if (bitBox.getText().length() >= 1 ){ // limit textfield to 3 characters
//                    e.consume();
//                    System.out.println(e.getKeyChar());
//                }
//            }  
//        });
//        boxes.add(bitBox);
//    }

    /**
     * @return the next
     */
    public JButton getNextButton()
    {
        return next;
    }
}
