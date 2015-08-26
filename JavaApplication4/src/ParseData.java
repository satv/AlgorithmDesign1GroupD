/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Group D guys and girls
 */
public class ParseData {

    Scanner sc;
    int n;
    String[] manNames;
    String[] womanNames;
    int[][] manPrefs;
    int[][] womanPrefs;

    public void parseFile(String[] args) {

        //File file = new File("sm-bbt-in.txt");
        sc = new Scanner(System.in);
        // .....

        while (sc.hasNext()) {
            String token = sc.next();
            if (token.startsWith("#")) {
                sc.nextLine();
//            } else if (token.startsWith("")) {
//                sc.nextLine();
            } else if (token.startsWith("n=")) {
                n = Integer.parseInt(token.substring(2));
                manNames = new String[n];
                womanNames = new String[n];
                manPrefs = new int[n][n];
                womanPrefs = new int[n][n];

            } else if (token.endsWith(":")) {
                // add ids to preference list
                int id = Integer.parseInt(token.substring(0, token.length() - 1));
                String[] priorities = sc.nextLine().trim().split(" ");

                if (id % 2 == 0) {
                    for (int i = 0; i < priorities.length; i++) {
                        int priorityId = Integer.parseInt(priorities[i]);
                        womanPrefs[(id - 1) / 2][i] = (priorityId - 1) / 2;
                    }
                } else {
                    for (int i = 0; i < priorities.length; i++) {
                        int priorityId = Integer.parseInt(priorities[i]);
                        manPrefs[(id - 1) / 2][i] = (priorityId - 1) / 2;
                    }
                }

            } else {

                int id = Integer.parseInt(token);
                if (id % 2 == 0) {
                    womanNames[(id - 1) / 2] = sc.next();
                } else {
                    manNames[(id - 1) / 2] = sc.next();
                }
            }
        }
//        printManNames();
//        printWomanNames();
//        printHowardsPriorities();
    }

    public int getN() {
        return n;
    }

    public String[] getManNames() {
        return manNames;
    }

    public String[] getWomanNames() {
        return womanNames;
    }

    public int[][] getWomanPrefs() {
        // int[][] womanPrefs = {{1, 7, 5, 3}, {7, 3, 1, 5}, {5, 3, 7, 1}, {7, 5, 1, 3}};
        return womanPrefs;
    }

    public int[][] getManPrefs() {
        // int[][] manPrefs = {{2, 4, 6, 8},{6, 4, 2, 8},{6, 4, 8, 2},{4, 8, 6, 2}};
        return manPrefs;
    }

    private void printManNames() {
        for (int i = 0; i < n; i++) {
            System.out.println(i + " " + manNames[i]);
        }
    }

    private void printWomanNames() {
        for (int i = 0; i < n; i++) {
            System.out.println(i + " " + womanNames[i]);
        }
    }
    
    private void printHowardsPriorities() {
        for (int i =0; i < n; i++ ) {
            System.out.println(manPrefs[2][i]);
        }
    }
}
