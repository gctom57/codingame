import java.util.Scanner;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    private static long[] houses;
    private static long[] sumForIndexes;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        houses = new long[N];
        for (int i = 0; i < N; i++) {
            houses[i] = in.nextLong();
        }

        sumForIndexes = new long[N];

        // max start from index 0 or index 1
        long res = Math.max(calcMaxFromIndex(0), calcMaxFromIndex(1));
        System.out.println(res);
    }

    static long calcMaxFromIndex(int index) {
        if (index >= houses.length) {
            return 0;
        }

        if (sumForIndexes[index] != 0) {
            return sumForIndexes[index];
        }

        long right2 = Math.max(calcMaxFromIndex(index + 2), calcMaxFromIndex(index + 3));

        // compare 2 houses vs 3 houses next
        sumForIndexes[index] = (houses[index] > 0 ? houses[index] : 0) + (right2 > 0 ? right2 : 0);

        return sumForIndexes[index];
    }
}