import java.util.*;
import java.io.*;
import java.math.*;
import java.util.stream.IntStream;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        in.nextLine();

        String[] compounds = new String[N];
        for (int i = 0; i < N; i++) {
            compounds[i] = in.nextLine();
        }

        boolean found = true;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < compounds[i].length() - 2; j++) {
                if (compounds[i].substring(j, j+2).equals("CH")) {
                    int bonds = Integer.parseInt(""+compounds[i].charAt(j+2));
                    try {
                        bonds += Integer.parseInt(""+compounds[i-1].charAt(j+1));
                    } catch (Exception e) {}//Don't like it but it's easier
                    try {
                        bonds += Integer.parseInt(""+compounds[i+1].charAt(j+1));
                    } catch (Exception e) {}
                    try {
                        bonds += Integer.parseInt(""+compounds[i].charAt(j-2));
                    } catch (Exception e) {}
                    try {
                        bonds += Integer.parseInt(""+compounds[i].charAt(j+4));
                    } catch (Exception e) {}
                    if (bonds != 4) {
                        found = false;
                    }
                }
                j += 5;
            }
        }

        System.out.println(found ? "VALID" : "INVALID");
    }
}