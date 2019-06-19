import java.util.Scanner;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Player {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int rows = in.nextInt(); // Number of rows
        in.nextInt(); // Number of columns

        int[][] grid = new int[rows][2];

        // game loop
        while (true) {
            int nimSum = 0;
            for (int i = 0; i < rows; i++) {
                int xPlayer = in.nextInt(); // Position of the first player's token
                int xBoss = in.nextInt(); // Position of the second player's token

                int nimber = xBoss - xPlayer - 1;
                nimSum ^= nimber;

                grid[i] = new int[]{xPlayer, nimber};
            }

            for (int i = 0; i < rows; i++) {
                int test = grid[i][1] ^ nimSum;
                if (test <= grid[i][1]) {
                    System.out.println(i + " " + (grid[i][0] + (grid[i][1] - test)));
                    break;
                }
            }
        }
    }
}