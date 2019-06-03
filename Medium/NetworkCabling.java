import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        int[] ys = new int[N];

        int minX = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            ys[i] = y;

            minX = Math.min(minX, x);
            maxX = Math.max(maxX, x);
        }

        Arrays.sort(ys);

        int medianY = ys[ys.length / 2];

        long total = Math.abs(maxX - minX);
        for (int i : ys) {
            total += Math.abs(i - medianY);
        }

        System.out.println(total);
    }
}