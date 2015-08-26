/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dev;

import java.io.FileNotFoundException;

/**
 *
 * @author Sarah de Voss
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException{
        MatchingApp matchingApp = new MatchingApp();
        matchingApp.matching(args[0]);
    }
}
