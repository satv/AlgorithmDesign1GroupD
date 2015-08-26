
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Group D guys and girls
 */
public class MatchAlgorithm {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void matching(String filename) throws FileNotFoundException {

        ParseData parseData = new ParseData();
        parseData.parseFile(filename);

        int n = parseData.getN();
        String[] manNames = parseData.getManNames();
        String[] womanNames = parseData.getWomanNames();

        Queue<Integer> freeMan = new LinkedList();
        for (int i = 0; i < n; i++) {
            freeMan.add(i);
        }

        //INITIALIZE S to empty matching.
        Integer[] wife = new Integer[n]; // wife[w]= her man // no bound == null
        Integer[] husband = new Integer[n]; // man[m] = his girl // no bound == null 

        int[][] womanPrefs = parseData.getWomanPrefs();
        int[][] manPrefs = parseData.getManPrefs();

        int[][] invertWomanPrefs = new int[n][n];
        int[][] invertManPrefs = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                invertWomanPrefs[i][womanPrefs[i][j]] = j;
                invertManPrefs[i][manPrefs[i][j]] = j;
            }
        }

        //while(some man m is unmatched and hasn't proposed to every woman)
        while (freeMan.size() != 0) {
            int currMan = freeMan.poll();
            for (int i = 0; i < n; i++) {
                //w <- first woman on m's list to whom m has not yet proposed.
                int w = manPrefs[currMan][i];
                //IF (w is unmatched)
                if (wife[w] == null) {
                    //Add pair m–w to matching S.
                    wife[w] = currMan;
                    husband[currMan] = w;
                    break;
                } //ELSE IF (w prefers m to her current partner m')
                else if (invertWomanPrefs[w][currMan] < invertWomanPrefs[w][wife[w]]) {
                    //Remove pair m'–w from matching S.
                    freeMan.add(wife[w]);
                    wife[w] = null;
                    husband[currMan] = null;
                    //Add pair m–w to matching S.
                    wife[w] = currMan;
                    husband[currMan] = w;
                    break;
                } //ELSE
                else {
                    //w rejects m.
                }
            }
            //RETURN stable matching S.
        }

        Output o = new Output();
        //o.debugEverything(n, manNames, womanNames, womanPrefs, manPrefs, invertWomanPrefs, invertManPrefs);
        //o.doublePairing(n, manNames, womanNames, wife, husband);
        o.mimicExampleOutputStyle(n, manNames, womanNames, wife, husband);
    }
}
