import java.util.Scanner;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    static int sum = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        calc(n, 0, 1);

        System.out.println(sum);
    }

    private static void calc(int currentSum, int round, int val) {
        if (round > 4) {
            return;
        }
        if (currentSum == 50) {
            sum += val;
            return;
        }

        for (int i = 1; i <= 12 && 50 - currentSum >= i; i++) {
            calc(currentSum + i, round + 1, val * (i == 1 ? 1 : 2));
        }
    }
}