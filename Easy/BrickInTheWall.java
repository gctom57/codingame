import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int X = in.nextInt();
        int N = in.nextInt();
        List<Integer> bricks = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            bricks.add(in.nextInt());
        }

        bricks.sort(Collections.reverseOrder());

        double W = 0d;

        for (int i = 0; i < N; i++) {
            int L = i / X;
            W += L * 0.65 * bricks.get(i);
        }

        System.out.println(new DecimalFormat("0.000").format(W));
    }
}