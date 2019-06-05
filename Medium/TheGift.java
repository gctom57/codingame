import java.util.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String[] args) {
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
        
        while(budgets.size() > 0) {
            int mean = C / budgets.size();
            int current = Math.min(budgets.poll(), mean);
            System.out.println(current);
            C -= current;
        }
    }
}