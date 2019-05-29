import java.util.Scanner;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int high = 0;
        int res = 0;

        for (int i = 0; i < n; i++) {
            int v = in.nextInt();

            if (v > high) {
                high = v;
            } else if ((v - high) < res) {
                res = v - high;
            }
        }

        System.out.println(res);
    }
}