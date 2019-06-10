import java.util.Scanner;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    // first line = initial and 5 others are possible combinations
    static int[][] results = new int[6][6];
    static int bestDistance = Integer.MAX_VALUE;
    static int solution = 6; // if we find a solution it's max 5 combination
    static int finalValue = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        finalValue = in.nextInt();

        for (int i = 0; i < 6; i++) {
            int v = in.nextInt();
            results[0][i] = v;
        }

        calculate(0);

        System.out.println(bestDistance == 0 ? "POSSIBLE" : "IMPOSSIBLE");
        System.out.println(bestDistance == 0 ? solution : bestDistance);
    }

    private static void calculate(int lvl) {
        //System.err.println("lvl : " + lvl + " result : " + results[lvl][0]);

        int tmpDistance = Math.abs(finalValue - results[lvl][0]);
        if (tmpDistance <= bestDistance) {
            bestDistance = tmpDistance;

            if (bestDistance == 0) {
                solution = Math.min(solution, lvl);
            }
        }

        if (lvl == 5) {
            return;
        }

        for (int i = 0; i < 6 - lvl - 1; i++) {
            for (int j = i + 1; j < 6 - lvl; j++) {
                int a = results[lvl][i];
                int b = results[lvl][j];

                int l = 1;
                for (int k = 0; k < 6 - lvl; k++) {
                    if (k != i && k != j) {
                        results[lvl + 1][l++] = results[lvl][k];
                    }
                }

                results[lvl + 1][0] = a + b;
                calculate(lvl + 1);

                results[lvl + 1][0] = a * b;
                calculate(lvl + 1);

                if (a != b) {
                    results[lvl + 1][0] = Math.abs(a - b);
                    calculate(lvl + 1);
                }

                if (a % b == 0) {
                    results[lvl + 1][0] = a / b;
                    calculate(lvl + 1);
                } else if (b % a == 0) {
                    results[lvl + 1][0] = b / a;
                    calculate(lvl + 1);
                }
            }
        }
    }
}