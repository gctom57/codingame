import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    static int nbDigit = 10;
    static int nbVowels = 5;
    static Map<Integer, Integer> robberUsage = new HashMap();

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int R = in.nextInt();
        int V = in.nextInt();

        int[] robbers = new int[R];
        for (int i = 0; i < V; i++) {
            int C = in.nextInt();
            int N = in.nextInt();

            int combinaison = (int) Math.pow(nbDigit, N) * (int) Math.pow(nbVowels, (C - N));
            robbers[0] += combinaison;
            Arrays.sort(robbers);
        }

        System.out.println(robbers[R - 1]);
    }
}