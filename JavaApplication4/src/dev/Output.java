package dev;

/**
 *
 * @author Group D guys and girls
 */
public class Output {

    public void debugEverything(int n, String[] manNames, String[] womanNames, int[][] womanPrefs, int[][] manPrefs, int[][] invertWomanPrefs, int[][] invertManPrefs){

        System.out.println("n: "+ n);
        System.out.println();
        System.out.println("manNames: ");
        for (String name : manNames) {
            System.out.print(name + ", ");
        }
        System.out.println();
        System.out.println("womanNames: ");
        for (String name : womanNames) {
            System.out.print(name + ", ");
        }
        System.out.println();
        System.out.println();
        System.out.println("manPrefs");
        for(int[] arr : manPrefs){
            for(int val : arr){
                System.out.print(val + ", ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("invertManPrefs");
        for(int[] arr : invertManPrefs){
            for(int val : arr){
                System.out.print(val + ", ");
            }
            System.out.println();
        }        
        
        System.out.println();
        System.out.println("womanPrefs");
        for(int[] arr : womanPrefs){
            for(int val : arr){
                System.out.print(val + ", ");
            }
            System.out.println();
        }
        
        System.out.println();
        System.out.println("invertWomanPrefs");
        for(int[] arr : invertWomanPrefs){
            for(int val : arr){
                System.out.print(val + ", ");
            }
            System.out.println();
        }
    }
    
    public void doublePairing(int n, String[] manNames, String[] womanNames, Integer[] wife, Integer[] husband){
        System.out.println();
        System.out.println("wife:");
        for(int i = 0; i < n; i++){
            System.out.println(womanNames[i]+"("+i + ") -> " + manNames[wife[i]]+"("+i+")");
        }
        System.out.println();
        System.out.println("husband");
        for(int i = 0; i < n; i++){
            System.out.println(manNames[i]+"("+i + ") -> " + womanNames[husband[i]]+"("+i+")");
        }
    }
    
    public void mimicExampleOutputStyle(int n, String[] manNames, String[] womanNames, Integer[] wife, Integer[] husband){
        for(int i = 0; i < n; i++){
            System.out.println(manNames[i]+" -- " + womanNames[husband[i]]);
        }
    }
}
