/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.FileNotFoundException;

/**
 *
 * @author Sarah de Voss
 */
public class MatchingApp {
    public static void main(String[] args) throws FileNotFoundException{
        MatchAlgorithm mA = new MatchAlgorithm();
        String file = "";
        for (String s: args) {
            file = s;
        }
        MatchAlgorithm.matching(file);
    }
}
