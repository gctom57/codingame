import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {
    private static Map<Integer, Integer> totals = new HashMap<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        if (n == 3 || n == 4) {
            System.out.println("2 1");
            return;
        }

        int max = 1;
        int spot = 1;

        for (int i = 0; i <= n/2; i++) {
            // 0000000, i=0 -> x00000X -> 2 'x'
            // 0000000, i=1 -> 0x0000X -> 2 'x'
            // 0000000, i=2 -> X0x000X -> 3 'x'
            int sum = (i <= 1 ? 2 : 3)
                    + (totals.containsKey(i) ? totals.get(i) : calcSpot(0, i))
                    + (totals.containsKey(n - i - 1) ? totals.get(n - i - 1) : calcSpot(i, n - 1));

            if (max < sum) {
                max = sum;
                spot = i + 1;
            }
        }

        System.out.println(max + " " + spot);
    }

    private static int calcSpot(int start, int end) {
        int distance = end - start;
        if (distance <= 3) {
            return 0;
        }

        if (totals.containsKey(distance)) {
            return totals.get(distance);
        }

        int mid = (start + end) / 2;

        int nb = 1 + calcSpot(start, mid) + calcSpot(mid, end);
        totals.put(distance, nb);
        return nb;
    }
}