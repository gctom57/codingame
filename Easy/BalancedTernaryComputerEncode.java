import java.util.Scanner;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        boolean negative = N < 0;
        N = Math.abs(N);

        int[] base = new int[]{0, 1, -1};
        String strP = "01T";
        String strN = "0T1";

        String result = "";
        do{
            int remaining = N % 3;

            N -= base[remaining];
            result = (negative ? strN.charAt(remaining) : strP.charAt(remaining)) + result;

            N = N / 3;
        } while(N > 0);

        System.out.println(result);
    }
}