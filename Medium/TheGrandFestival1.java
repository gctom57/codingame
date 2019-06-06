import java.util.Scanner;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    static int R;
    static int[] prizes;
    static int[][] sumForIndexes;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        R = in.nextInt();

        sumForIndexes = new int[N][R];

        prizes = new int[N];
        for (int i = 0; i < N; i++) {
            prizes[i] = in.nextInt();
        }

        // max start from index 0 or index 1
        int res = Math.max(calcMaxFromIndex(0, R), calcMaxFromIndex(1, R));
        System.out.println(res);
    }

    static int calcMaxFromIndex(int index, int nbDays) {
        nbDays--;

        if (index >= prizes.length) {
            return 0;
        }

        if (sumForIndexes[index][nbDays] != 0) {
            return sumForIndexes[index][nbDays];
        }

        if (nbDays > 0) {
            // compare sum of remaining days vs a rest day and a sum of R days
            sumForIndexes[index][nbDays] = prizes[index] + Math.max(calcMaxFromIndex(index + 1, nbDays), calcMaxFromIndex(index + 2, R));
        } else {
            // compare a sum of R days 1 days in the future vs 2 days in the future
            sumForIndexes[index][nbDays] = prizes[index] + Math.max(calcMaxFromIndex(index + 2, R), calcMaxFromIndex(index + 3, R));
        }

        return sumForIndexes[index][nbDays];
    }
}