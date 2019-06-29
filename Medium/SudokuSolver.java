import java.util.Scanner;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    static int[][] board;
    static boolean[] numbers = new boolean[9];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        board = new int[9][9];
        for (int i = 0; i < 9; i++) {
            String[] line = in.nextLine().split("");
            for (int j = 0; j < 9; j++) {
                board[i][j] = Integer.parseInt(line[j]);
            }
        }

        solve();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    private static boolean solve() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == 0) {
                    for (int k = 1; k < 10; k++) {
                        board[i][j] = k;
                        if (isValid(i, j) && solve()) {
                            return true;
                        }
                        board[i][j] = 0;
                    }
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean isValid(int y, int x) {
        return isRowValid(y) && isColValid(x) && isSquareValid(y, x);
    }

    private static boolean isRowValid(int y) {
        numbers = new boolean[9];
        for (int j = 0; j < 9; j++) {
            if (invalidNumbers(y, j)) {
                return false;
            }
        }

        return true;
    }

    private static boolean isColValid(int x) {
        numbers = new boolean[9];
        for (int i = 0; i < 9; i++) {
            if (invalidNumbers(i, x)) {
                return false;
            }
        }

        return true;
    }

    private static boolean isSquareValid(int y, int x) {
        numbers = new boolean[9];

        int startX = (x / 3) * 3;
        int endX = startX + 3;

        int startY = (y / 3) * 3;
        int endY = startY + 3;

        for (int i = startY; i < endY; i++) {
            for (int j = startX; j < endX; j++) {
                if (invalidNumbers(i, j)) {
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean invalidNumbers(int y, int x) {
        if (board[y][x] != 0) {
            if (!numbers[board[y][x] - 1]) {
                numbers[board[y][x] - 1] = true;
            } else {
                return true;
            }
        }
        return false;
    }
}