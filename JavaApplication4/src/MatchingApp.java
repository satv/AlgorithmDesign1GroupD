/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.FileNotFoundException;

/**
 *
 * @author Group D guys and girls
 */
public class MatchingApp {
    public static void main(String[] args) throws FileNotFoundException{
        String file = "";
        for(String s: args){
            file = s;
        }
        if(file.compareTo("") == 0){
            file = "sm-bbt-in.txt";
        }
        MatchAlgorithm.matching(file);
    }
}
