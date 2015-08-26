/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev;

/**
 *
 * @author Group D guys and girls
 */
public class ParseData {
    
    public void parseFile(String filename){
        // .....
        
    }
    
    public int getN(){
        int n= 4;
        return n;
    }
    
    public String[] getManNames(){
        String[] manNames  = {"Sheldon", "Rajesh", "Howard", "Leonard"};
        return manNames;
    }
    public String[] getWomanNames(){
        String[] womanNames = {"Amy", "Penny", "Bernadette", "Emily"};
        return womanNames;
    }
    
    public int[][] getWomanPrefs(){
        int[][] womanPrefs = {{1, 7, 5, 3}, {7, 3, 1, 5}, {5, 3, 7, 1}, {7, 5, 1, 3}};
        return womanPrefs;
    }
    
    public int[][] getManPrefs(){
        int[][] manPrefs = {{2, 4, 6, 8},{6, 4, 2, 8},{6, 4, 8, 2},{4, 8, 6, 2}};
        return manPrefs;
    }
}