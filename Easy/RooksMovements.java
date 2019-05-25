import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Point rook = new Point(in);

        int nbPieces = in.nextInt();
        int[][] board = new int[8][8];
        for (int i = 0; i < nbPieces; i++) {
            int colour = in.nextInt();
            Point onePiece = new Point(in);
            board[onePiece.x][onePiece.y] = colour == 0 ? -1 : 1;
        }

        List<Point> points = new ArrayList<>();
        for (int i = rook.x - 1; i >= 0; i--) {
            if (horizontalCheck(rook, board, points, i)) break;
        }

        for (int i = rook.x + 1; i < 8; i++) {
            if (horizontalCheck(rook, board, points, i)) break;
        }

        for (int j = rook.y - 1; j >= 0; j--) {
            if (verticalCheck(rook, board, points, j)) break;
        }

        for (int j = rook.y + 1; j < 8; j++) {
            if (verticalCheck(rook, board, points, j)) break;
        }

        points.stream()
                .sorted(Comparator.comparing(p -> p.getString(rook))).forEach(p -> System.out.println(p.getString(rook)));
    }

    private static boolean horizontalCheck(Point rook, int[][] board, List<Point> points, int i) {
        if (board[i][rook.y] == -1) {
            return true;
        } else {
            points.add(new Point(i, rook.y, board[i][rook.y] == 1));
            return board[i][rook.y] == 1;
        }
    }

    private static boolean verticalCheck(Point rook, int[][] board, List<Point> points, int j) {
        if (board[rook.x][j] == -1) {
            return true;
        } else {
            points.add(new Point(rook.x, j, board[rook.x][j] == 1));
            return board[rook.x][j] == 1;
        }
    }
}

class Point {
    int x;
    int y;
    String pos;
    boolean taken;

    public Point(Scanner in) {
        this.pos = in.next();
        this.x = (Character.getNumericValue(pos.charAt(0)) - 10);
        this.y = (Character.getNumericValue(pos.charAt(1)) - 1);
    }

    public Point(int x, int y, boolean taken) {
        this.x = x;
        this.y = y;
        this.taken = taken;
    }

    String getString(Point initial) {
        return "R" + initial.pos + (taken ? "x" : "-") + (char) (x + 'a') + "" + (y + 1);
    }
}