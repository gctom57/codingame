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
        int N = in.nextInt();

        List<Integer> horses = new ArrayList();
        for (int i = 0; i < N; i++) {
            int pi = in.nextInt();
            horses.add(pi);
        }

        Collections.sort(horses);
        int delta = 10000000;
        for (int i = 0; i < N-1; i++) {
            int tmp = horses.get(i+1) - horses.get(i);
            if (tmp < delta) {
                delta = tmp;
            }
        }

        System.out.println(delta);
    }
}