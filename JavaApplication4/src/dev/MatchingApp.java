/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author user
 */
public class MatchingApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int n = 4;
        String[] manNames  = {"Sheldon", "Rajesh", "Howard", "Leonard"};
        String[] womanNames = {"Amy", "Penny", "Bernadette", "Emily"};        
        
        Queue<Integer> freeMan = new LinkedList();
        for(int i = 0; i < n; i++){
            freeMan.add(i);
        }
        
        //INITIALIZE S to empty matching.
        Integer[] wife = new Integer[n];
        Integer[] husband = new Integer[n];
        
        int[][] womanPrefs = {{1, 7, 5, 3}, {7, 3, 1, 5}, {5, 3, 7, 1}, {7, 5, 1, 3}};
        int[][] manPrefs = {{2, 4, 6, 8}, {6, 4, 2, 8}, {6, 4, 8, 2}, {4, 8, 6, 2}};
        
        
        //while(some man m is unmatched and hasn't proposed to every woman)
        while(freeMan.size() != 0){
            //w← first woman on m's list to whom m has not yet proposed.
            int currMen = freeMan.poll();
            
            for(int i = 0; i < n; i++){
                //IF (w is unmatched)
                if( wife [ manPrefs[currMen][i] ] == null  ){
                    //Add pair m–w to matching S.
                   wife[manPrefs[currMen][i]] = currMen;
                   husband[currMen] = manPrefs[currMen][i];
                   break; 
                }
            }
            //ELSE IF (w prefers m to her current partner m')
            
                //Remove pair m'–w from matching S.
                //Add pair m–w to matching S.
            //ELSE
                //w rejects m.
            //RETURN stable matching S.
        }
    
    }
    
}
