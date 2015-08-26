/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev;

import java.util.Scanner;

/**
 *
 * @author Group D guys and girls
 */
public class ParseData {

    int n;

    public void parseFile(String filename) {
        // .....
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String token = sc.next();
            if (token.startsWith("#")) {
                n = Integer.parseInt(token.substring(2));
            } else if (token.endsWith(":")) {
                // add ids to priority list
            } else {
                // add id to list
                    // if (id % 2 == 0) {
                    // it's a woman
                // }
                // it's man
            }

        }

    }

    public int getN() {
        return n;
    }

    public String[] getManNames() {
        String[] manNames = {"Sheldon", "Rajesh", "Howard", "Leonard"};
        return manNames;
    }

    public String[] getWomanNames() {
        String[] womanNames = {"Amy", "Penny", "Bernadette", "Emily"};
        return womanNames;
    }

    public int[][] getWomanPrefs() {
        // int[][] womanPrefs = {{1, 7, 5, 3}, {7, 3, 1, 5}, {5, 3, 7, 1}, {7, 5, 1, 3}};
        int[][] womanPrefs = {{0, 3, 2, 1}, {3, 1, 0, 2}, {2, 1, 3, 0}, {3, 2, 0, 1}};
        return womanPrefs;
    }

    public int[][] getManPrefs() {
        // int[][] manPrefs = {{2, 4, 6, 8},{6, 4, 2, 8},{6, 4, 8, 2},{4, 8, 6, 2}};
        int[][] manPrefs = {{0, 1, 2, 3}, {2, 1, 0, 3}, {2, 1, 3, 0}, {1, 3, 2, 0}};
        return manPrefs;
    }
}
