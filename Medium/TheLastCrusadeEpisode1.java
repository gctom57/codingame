import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Player {

    static String[][] pieces = { // Down, Left, Right
            // Top, Left, Right
            {"X", "X", "X"}, //0
            {"D", "D", "D"}, //1
            {"X", "R", "L"}, //2
            {"D", "X", "X"}, //3
            {"L", "X", "D"}, //4
            {"R", "D", "X"}, //5
            {"X", "R", "L"}, //6
            {"D", "X", "D"}, //7
            {"X", "D", "D"}, //8
            {"D", "D", "X"}, //9
            {"L", "X", "X"}, //10
            {"R", "X", "X"}, //11
            {"X", "X", "D"}, //12
            {"X", "D", "X"}, //13
    };

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int W = in.nextInt(); // number of columns.
        int H = in.nextInt(); // number of rows.
        in.nextLine();

        int[][] maze = new int[H][W];
        for (int i = 0; i < H; i++) {
            String[] LINE = in.nextLine().split(" "); // represents a line in the grid and contains W integers. Each integer represents one room of a given type.
            for (int j = 0; j < LINE.length; j++) {
                maze[i][j] = Integer.parseInt(LINE[j]);
            }
        }
        int EX = in.nextInt(); // the coordinate along the X axis of the exit (not useful for this first mission, but must be read).

        List<String> directions = Arrays.asList("TOP", "LEFT", "RIGHT");

        // game loop
        while (true) {

            int XI = in.nextInt();
            int YI = in.nextInt();
            int POS = directions.indexOf(in.next());

            String direction = pieces[maze[YI][XI]][POS];
            XI += direction.equals("L") ? -1 : (direction.equals("R") ? 1 : 0);
            YI += direction.equals("D") ? 1 : 0;

            System.out.println(XI + " " + YI);
        }
    }
}