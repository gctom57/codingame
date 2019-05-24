import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int score = in.nextInt();

        for (int i = 0; i <= score / 5; i++) {
            for (int j = 0; j <= i; j++) {
                int nbPoint = score - (i * 5) - (j * 2);

                if (nbPoint >= 0 && nbPoint % 3 == 0) {
                    System.out.println(i + " " + j + " " + nbPoint / 3);
                }
            }
        }
    }
}