package dev;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Group D guys and girls
 */
public class MatchingApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ParseData parseData = new ParseData();
        parseData.parseFile("");
        
        int n = parseData.getN();
        String[] manNames  = parseData.getManNames();
        String[] womanNames = parseData.getWomanNames();        
        
        Queue<Integer> freeMan = new LinkedList();
        for(int i = 0; i < n; i++){
            freeMan.add(i);
        }
        
        //INITIALIZE S to empty matching.
        Integer[] wife = new Integer[n];
        Integer[] husband = new Integer[n];
        
        int[][] womanPrefs = parseData.getWomanPrefs();
        int[][] manPrefs = parseData.getManPrefs();
        
        int[][] invertWomanPrefs = new int[n][n];
        int[][] invertManPrefs = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                invertWomanPrefs[i][womanPrefs[i][j]] = j;
                invertManPrefs[i][manPrefs[i][j]] = j;
            }
        }
        
        //while(some man m is unmatched and hasn't proposed to every woman)
        while(freeMan.size() != 0){
            int currMan = freeMan.poll();
            for(int i = 0; i < n; i++){
                //w ← first woman on m's list to whom m has not yet proposed.
                int w = manPrefs[currMan][i];
                //IF (w is unmatched)
                if( wife[w] == null  ){
                    //Add pair m–w to matching S.
                   wife[w] = currMan;
                   husband[currMan] = w;
                   break; 
                }
                //ELSE IF (w prefers m to her current partner m')
                else if(invertWomanPrefs[w][currMan] < invertWomanPrefs[w][wife[w]]){
                    //Remove pair m'–w from matching S.
                    wife[w] = null;
                    husband[currMan] = null;
                    //Add pair m–w to matching S.
                    wife[w] = currMan;
                    husband[currMan] = w;
                }
                //ELSE
                else{
                    //w rejects m.
                }
            }
            //RETURN stable matching S.
        }
    }
    
}
