import java.util.Scanner;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    static int[][] squared;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int h = in.nextInt();
        int w = in.nextInt();

        squared = new int[h+1][w+1];

        System.out.println(calc(h, w));
    }

    static int calc(int h, int w) {
        if (h == w) {
            return 1;
        }

        if (squared[h][w] != 0) {
            return squared[h][w];
        }

        int horizontalSquare = Integer.MAX_VALUE;
        int verticalSquare = Integer.MAX_VALUE;

        for (int i = 1; i <= h / 2 ; i++) {
            horizontalSquare = Math.min(calc(i, w) + calc(h - i, w), horizontalSquare);
        }

        for (int i = 1; i <= w / 2; i++) {
            horizontalSquare = Math.min(calc(h, i) + calc(h, w - i), horizontalSquare);
        }

        squared[h][w] = Math.min(horizontalSquare, verticalSquare);

        return squared[h][w];
    }
}