/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infoproject;

import utils.ArrayParserUtils;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import javax.swing.JTextArea;
import utils.MapUtils;

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
        if(ens != null && !ens.isEmpty() && prob != null && !prob.isEmpty()){
            //Parse into arrays
            String[] ensemble = ArrayParserUtils.parseCommaSeparatedStrings(ens);
            String[] probs = ArrayParserUtils.parseCommaSeparatedStrings(prob);
            double[] p = ArrayParserUtils.parseIntoArrayOfDoubles(probs);
            //convert probs to array of doubles
            //Check they are same size and the probs add up to 1.0
            if(ArrayParserUtils.arraysAreSameLength(ensemble, probs) &&
                    ArrayParserUtils.sumIsOne(p)){
                HuffmanEncoder huffman = new HuffmanEncoder(p, ensemble);
                Map<String, String> encodings = huffman.encodeHuffman();
                MapUtils.printMap(encodings);
                //Calculate Entropy
                double[] ent = EntropyCalculator.calculateEntropyOfEach(p);
                ArrayParserUtils.printDoubleArray(ent);
                double entEns = EntropyCalculator.calculateEntropyOfEnsemble(p);
                System.out.println("Entropy of ensemble: " + EntropyCalculator
                        .roundTo4decimalPoints(entEns));
                //TODO: Display values and entropy and L
            }else {
                //TODO: Display message saying they are not the same
                System.out.println("The length of the arrays must be equal and the sum "
                        + "of the probabilities must add up to 1.0.");
            }
            String message = String.format("You entered: {'%s'}, {'%s'}", ens, prob);
            System.out.println(message);
        }else{
            String message = "You must enter data in all fields.";
            System.out.println(message);
        }
    }
    
}
