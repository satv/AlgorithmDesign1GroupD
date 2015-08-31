
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author Sarah de Voss <satv@itu.dk>
 * @author Aaron Gornott <agor@itu.dk>
 * @author Rene Anda Nielsen <rann@itu.dk>
 */
public class GS {

    private static Scanner sc;
    private static int n;
    private static int[][] manPrefs = null;
    private static int[][] womanPrefs = null;
    private static String[] manNames = null;
    private static String[] womanNames = null;
    private static Integer[] husband;
    private static Integer[] wife;

    public static void main(String[] args) {

        GS gs = new GS();
        sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String token = sc.next();
            // ignore lines starting with #
            if (token.startsWith("#")) {
                sc.nextLine();
                // initialize n and create data structure
            } else if (token.startsWith("n=")) {
                n = Integer.parseInt(token.substring(2));
                manNames = new String[n];
                womanNames = new String[n];
                manPrefs = new int[n][n];
                womanPrefs = new int[n][n];
                // create preference lists
            } else if (token.endsWith(":")) {
                int id = Integer.parseInt(token.substring(0, token.length() - 1));
                String[] priorities = sc.nextLine().trim().split(" ");
                // if id belongs to a woman add entries to womanPrefs
                if (id % 2 == 0) {
                    for (int i = 0; i < priorities.length; i++) {
                        int priorityId = Integer.parseInt(priorities[i]);
                        womanPrefs[(id - 1) / 2][i] = (priorityId - 1) / 2;
                    }
                } else {
                    // if not add entries to manPrefs
                    for (int i = 0; i < priorities.length; i++) {
                        int priorityId = Integer.parseInt(priorities[i]);
                        manPrefs[(id - 1) / 2][i] = (priorityId - 1) / 2;
                    }
                }
            } else {
                // separate men and women into two arrays
                int id = Integer.parseInt(token);
                if (id % 2 == 0) {
                    womanNames[(id - 1) / 2] = sc.next();
                } else {
                    manNames[(id - 1) / 2] = sc.next();
                }
            }
        }
        sc.close();
        gs.matching();
        gs.output();
    }

    private void matching() {

        Queue<Integer> freeMan = new LinkedList();
        for (int i = 0; i < n; i++) {
            freeMan.add(i);
        }

        //INITIALIZE S to empty matching.
        wife = new Integer[n]; // wife[w]= her man // no bound == null
        husband = new Integer[n]; // man[m] = his girl // no bound == null 

        int[][] invertWomanPrefs = new int[n][n];
        // not needed int[][] invertManPrefs = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                invertWomanPrefs[i][womanPrefs[i][j]] = j;
                // not needed invertManPrefs[i][manPrefs[i][j]] = j;
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
    }

    private void output() {
        for (int i = 0; i < n; i++) {
            System.out.println(manNames[i] + " -- " + womanNames[husband[i]]);
        }
    }
}
