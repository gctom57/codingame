import java.util.Arrays;
import java.util.Scanner;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    static int nbDigit = 10;
    static int nbVowels = 5;

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int R = in.nextInt();
        int V = in.nextInt();

        int[] robbers = new int[R];
        for (int i = 0; i < V; i++) {
            int C = in.nextInt();
            int N = in.nextInt();

            int combination = (int) Math.pow(nbDigit, N) * (int) Math.pow(nbVowels, (C - N));
            robbers[0] += combination;
            Arrays.sort(robbers);
        }

        System.out.println(robbers[R - 1]);
    }
}