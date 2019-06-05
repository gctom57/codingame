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
        int C = in.nextInt();

        int total = 0;
        PriorityQueue<Integer> budgets = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            int B = in.nextInt();
            total += B;
            budgets.add(B);
        }

        if (total < C) {
            System.out.println("IMPOSSIBLE");
            return;
        }

        List<Integer> repartitions = new ArrayList<>();

        Iterator<Integer> iter = budgets.iterator();
        while(budgets.size() > 0) {
            int mean = C / budgets.size();

            int current = budgets.poll();

            if (current < mean) {
                repartitions.add(current);
                C -= current;
            } else {
                repartitions.add(mean);
                C -= mean;
            }
        }

        for (Integer i : repartitions) {
            System.out.println(i);
        }
    }
}