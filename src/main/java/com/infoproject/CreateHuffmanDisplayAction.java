/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infoproject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        String ens = ensembleTextArea.getText();
        String prob = probabilitiesTextArea.getText();
        //Parse into arrays
        String[] ensemble = ArrayParserUtils.parseCommaSeparatedStrings(ens);
        String[] probs = ArrayParserUtils.parseCommaSeparatedStrings(prob);
        //Check they are same size
        if(ArrayParserUtils.arraysAreSameLength(ensemble, probs)){
            //convert probs to array of doubles
            double[] p = ArrayParserUtils.parseIntoArrayOfDoubles(probs);
            HuffmanEncoder huffman = new HuffmanEncoder(p, ensemble);
            String[] binaryEncodings = huffman.encodeHuffman();
            //Calculate Entropy
            double[] ent = EntropyCalculator.calculateEntropyOfEach(p);
            ArrayParserUtils.printDoubleArray(ent);
            double entEns = EntropyCalculator.calculateEntropyOfEnsemble(p);
            System.out.println("Entropy of ensemble: " + EntropyCalculator
                    .roundTo4decimalPoints(entEns));
            //TODO: Display values and entropy
        }else {
            //TODO: Display message saying they are not the same
        }
        String message = String.format("{'%s'}, {'%s'}", ens, prob);
        System.out.println(message);
    }
    
}
