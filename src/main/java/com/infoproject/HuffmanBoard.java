/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infoproject;

import static com.infoproject.Constants.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.Timer;
import utils.ArrayParserUtils;

/**
 *
 * @author matthewflesher
 */
public class HuffmanBoard extends JPanel implements ActionListener{
    
    JLabel l1,l2,b1,b2,b3,b4;
    JTextArea ensembleTextArea;
    JTextArea probabilitiesTextArea;
    JButton button;
    JButton next;
    Color maize;
    Color blue;
    Image M;
    Image R2;
    List<JLabel> demoLabels;
    boolean demo = false;
    
    private String textDisplay = "";
    int fontSize = 18;
    
    Graphics g;
    private final int INITIAL_X = FRAME_WIDTH + 40;
    private final int INITIAL_Y = FRAME_HEIGHT - 500;
    private final int DELAY = 25;
    private List<Line> lineList;
//    private List<JTextField> boxList;

    private Timer timer;
    private int x, y;
    
    public HuffmanBoard(){
        setLayout(null);
        setPreferredSize(new Dimension(800, 1200));
        blue = new Color(0,39,76);
        maize = new Color(255, 203, 5);
        setBackground(blue);
        init();
        loadImage();
        setInputBoxes();
    }
    
    private void init(){
        x = INITIAL_X;
        y = INITIAL_Y;
        timer = new Timer(DELAY, this);
        timer.start();
    }
    
    
    @Override
    public void paintComponent(Graphics g) {
        this.g = g;
        super.paintComponent(g);
        g.drawImage(M, (FRAME_WIDTH / 2) - (M_WIDTH / 2), 20, null);
        g.drawImage(R2, x, y, null);
        drawText(textDisplay, TEXT_AREA_X, DISPLAY_Y);
        drawLines();
    }

    private void drawText(String text, int x, int y) {
        g.setColor(maize);
        g.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));
        for(String line: text.split("\n")){
            g.drawString(line, x, y += g.getFontMetrics().getHeight());
        }
    }
    
    private void drawLines(){
        if(demo && getLineList() != null){
            for(Line l : getLineList()){
                g.setColor(maize);
                g.drawLine(l.x1, l.y1, l.x2, l.y2);
            }
        }
    }
    
    private void setInputBoxes(){
        l1 = new JLabel("Enter a comma separated ensemble (max 5):");
        l1.setForeground(maize);
        l1.setBounds(TEXT_AREA_X, TEXT_AREA_ONE_Y - TEXT_AREA_HEIGHT
                , TEXT_AREA_WIDTH, BUTTON_HEIGHT); 
        l2 = new JLabel("Enter comma separated probabilities:");
        l2.setForeground(maize);
        l2.setBounds(TEXT_AREA_X, TEXT_AREA_TWO_Y - TEXT_AREA_HEIGHT, 
                TEXT_AREA_WIDTH, BUTTON_HEIGHT); 
        setBracketLabels();
        ensembleTextArea = new JTextArea();
        ensembleTextArea.setBounds(TEXT_AREA_X, TEXT_AREA_ONE_Y, 
                TEXT_AREA_WIDTH, TEXT_AREA_HEIGHT);
        probabilitiesTextArea = new JTextArea();
        probabilitiesTextArea.setBounds(TEXT_AREA_X, TEXT_AREA_TWO_Y, 
                TEXT_AREA_WIDTH, TEXT_AREA_HEIGHT);
        
        button = new JButton("Huffman Encode");
        
        button.setForeground(blue);
        button.setBackground(maize);
        button.setContentAreaFilled(true);
        button.setOpaque(true);
        button.setBounds(TEXT_AREA_X, BUTTON_Y, BUTTON_WIDTH, BUTTON_HEIGHT);
        button.addActionListener(new HuffmanActionListener());
        add(l1);
        add(l2);
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(ensembleTextArea);
        add(probabilitiesTextArea);
        add(button);
        
    }
    
    private void setBracketLabels(){
        b1 = new JLabel("{");
        b1.setForeground(maize);
        b1.setBounds(TEXT_AREA_X - 8, TEXT_AREA_ONE_Y, 5, TEXT_AREA_HEIGHT);
        
        b2 = new JLabel("}");
        b2.setForeground(maize);
        b2.setBounds(TEXT_AREA_X + TEXT_AREA_WIDTH + 5, TEXT_AREA_ONE_Y, 
                5, TEXT_AREA_HEIGHT);
        b3 = new JLabel("{");
        b3.setForeground(maize);
        b3.setBounds(TEXT_AREA_X - 8, TEXT_AREA_TWO_Y, 5, TEXT_AREA_HEIGHT);
        b4 = new JLabel("}");
        b4.setForeground(maize);
        b4.setBounds(TEXT_AREA_X + TEXT_AREA_WIDTH + 5, TEXT_AREA_TWO_Y, 
                5, TEXT_AREA_HEIGHT);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (x > (TEXT_AREA_X + TEXT_AREA_WIDTH)) {
            x=x-1; //moves R2 to the left 2 pixels
        }
        
        if(demo && next != null && demoLabels != null && demoLabels.size() > 0){
            for(JLabel l : demoLabels){
                l.setForeground(maize);
                add(l);
            }
            button.setText("clear");
            add(next);
            //TODO: add input bit boxes here
//            if(boxList != null && boxList.size() > 0){
//                for(JTextField box : boxList){
//                    add(box);
//                }
//            }
        }
        //TODO: display talking bubbles from R2 in this section
        //TODO: add C3P0 on the left to talk to R2 about Huffman
        repaint();
    }
    
    class HuffmanActionListener implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent e) {
            String ens = ensembleTextArea.getText();
            String prob = probabilitiesTextArea.getText();
            boolean areDoubles = true;
            if(ens != null && !ens.isEmpty() && prob != null && !prob.isEmpty()){
                //Parse into arrays
                String[] ensemble = ArrayParserUtils.parseCommaSeparatedStrings(ens);
                String[] probs = ArrayParserUtils.parseCommaSeparatedStrings(prob);
                //convert probs to array of doubles
                double[] p = new double[probs.length];
                try{
                    p = ArrayParserUtils.parseIntoArrayOfDoubles(probs);
                }catch(Exception ex){
                    System.out.println(ex);
                    areDoubles = false;
                }
                //Check the probabilities array is actually doubles
                if(areDoubles){
                //Check they are same size and the probs add up to 1.0
                
                //check ensemble less than 6 and put message on UI
                    if(ArrayParserUtils.arraysAreSameLength(ensemble, probs) &&
                            ArrayParserUtils.sumIsOne(p) && ArrayParserUtils.areAllPositive(p)
                            && p.length < Constants.MAX_CHAR){
                        demo = !demo;
                        HuffmanEncoder huffman = new HuffmanEncoder(p, ensemble);
                        HuffmanNode root = huffman.createTree();
                        //TODO: set Bits graphically
                        HuffmanDemoComponent huffDemo = new HuffmanDemoComponent(root, ensemble);
                        if(demoLabels != null && demoLabels.size() > 0){
                            for(JLabel l : demoLabels){
                                remove(l);
                                remove(next);
                                button.setText("Huffman Encode");
                            }
//                            for(JTextField b : boxList){
//                                remove(b);
//                            }
                        }
                        demoLabels = huffDemo.createDemoLabels();
                        next = huffDemo.getNextButton();
                        
                        //get list of Lines in Demo Component and paint them in paintComponent
                        setLineList(huffDemo.lineList);
//                        setBoxList(huffDemo.boxes);
                        
                        //Calculate Entropy
                        double[] ent = EntropyCalculator.calculateEntropyOfEach(p);
                        ArrayParserUtils.printDoubleArray(ent);
                        double entEns = EntropyCalculator.calculateEntropyOfEnsemble(p);
                        textDisplay = String.format("You entered: {'%s'}, {'%s'}\n"
                                    + "Entropy of ensemble: " + EntropyCalculator
                                    .roundTo4decimalPoints(entEns) + "\n" 
                                    + "Entropy of characters: " + makeString(ent), 
                                    ens, prob);
                        System.out.println(textDisplay);
                        System.out.println("Entropy of ensemble: " + EntropyCalculator
                                .roundTo4decimalPoints(entEns));
                    }else {
                        textDisplay = "The length of the arrays must be \n"
                                + "equal, the sum of the probabilities must add up to 1.0,\n"
                                + "all of the values must be positive, \n"
                                + "and the max characters in the ensemble is "
                                + Constants.MAX_CHAR + ".";
                        System.out.println(textDisplay);
                    }
                }else{
                    textDisplay = "The probabilities must be doubles";
                    System.out.println(textDisplay);
                }
            }else{
                textDisplay = "You must enter data in all fields.";
                System.out.println(textDisplay);
            }
            repaint();
        }
    }
   
    private void loadImage() {
        ImageIcon ii = new ImageIcon("src/main/resources/M.png");
        ImageIcon ii2 = new ImageIcon("src/main/resources/r2.png");
        M = ii.getImage();
        R2 = ii2.getImage();
    }
    
    private String makeString(double[] ent){
        String s = "{ ";
        for(int i = 0; i < ent.length; i++){
            s = String.format(s + "%.1f,", ent[i]);
        }
        s = s.substring(0, s.length() - 1) + " }";
        return s;
    }

    /**
     * @return the lineList
     */
    public List<Line> getLineList()
    {
        return lineList;
    }

    /**
     * @param lineList the lineList to set
     */
    public void setLineList(List<Line> lineList)
    {
        this.lineList = lineList;
    }

//    /**
//     * @return the boxList
//     */
//    public List<JTextField> getBoxList()
//    {
//        return boxList;
//    }
//
//    /**
//     * @param boxList the boxList to set
//     */
//    public void setBoxList(List<JTextField> boxList)
//    {
//        this.boxList = boxList;
//    }
}
