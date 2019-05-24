import java.util.Scanner;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int W = in.nextInt();
        int H = in.nextInt();
        int[][] map = new int[H][W];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                map[i][j] = in.nextInt();
            }
        }

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if ((map[i][j] == 1)
                        || (i > 0 && j > 0 && map[i-1][j-1] == 0)
                        || (i > 0 && map[i-1][j] == 0)
                        || (i > 0 && j < W - 1 && map[i-1][j+1] == 0)
                        || (i < H - 1 && j < W - 1 && map[i+1][j+1] == 0)
                        || (i < H - 1 && map[i+1][j] == 0)
                        || (i < H - 1 && j > 0 && map[i+1][j-1] == 0)
                        || (j > 0 && map[i][j-1] == 0)
                        || (j < W - 1 && map[i][j+1] == 0)) {
                    continue;
                }

                System.out.println(j + " " + i);
            }
        }
    }
}