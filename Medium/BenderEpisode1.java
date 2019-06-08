import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    static Grid[][] grid;
    static List<Teleport> teleports;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int L = in.nextInt();
        int C = in.nextInt();

        in.nextLine();

        Bender b = new Bender(-1, -1);

        grid = new Grid[L][C];
        teleports = new ArrayList<>();

        for (int i = 0; i < L; i++) {
            char[] tmp = in.nextLine().toCharArray();
            for (int j = 0; j < C; j++) {
                grid[i][j] = new Grid(tmp[j]);
                if (tmp[j] == '@') {
                    b = new Bender(j, i);
                } else if (tmp[j] == 'T') {
                    teleports.add(new Teleport(j, i));
                }
            }
        }

        List<String> moves = new ArrayList<>();

        boolean done = false;
        while (!done) {
            updateDirection(b);
            String move = move(b);
            if (move.equals("FINAL")) {
                done = true;
                moves.add(b.getDirection());
            } else if (move.equals("LOOP")) {
                done = true;
                moves.clear();
            } else {
                moves.add(move);
            }
        }

        if (moves.isEmpty()) {
            System.out.println("LOOP");
        } else {
            moves.forEach(System.out::println);
        }
    }

    private static void updateDirection(Bender b) {
        Grid g = grid[b.getNextY()][b.getNextX()];
        switch (g.c) {
            case 'X':
                if (b.enraged) {
                    break;
                }
            case '#':
                for (int i = 0; i <= 3; i++) {
                    b.index = b.reversed ? 3 - i : i;
                    if (!grid[b.getNextY()][b.getNextX()].isObstacle() && !grid[b.getNextY()][b.getNextX()].isVisitedTooManyTime(b.index)) {
                        break;
                    }
                }
                break;
            default:
                break;
        }
    }

    private static String move(Bender b) {
        b.moveNext();

        String res = b.getDirection();

        Grid g = grid[b.y][b.x];
        g.visited[b.index]++;

        if (g.isVisitedTooManyTime(b.index)) {
            return "LOOP";
        }

        switch (g.c) {
            case 'B':
                b.enraged = !b.enraged;
                break;
            case 'S':
                b.index = 0;
                break;
            case 'E':
                b.index = 1;
                break;
            case 'N':
                b.index = 2;
                break;
            case 'W':
                b.index = 3;
                break;
            case 'I':
                b.reversed = !b.reversed;
                break;
            case 'T':
                if (teleports.get(0).x == b.x && teleports.get(0).y == b.y) {
                    b.x = teleports.get(1).x;
                    b.y = teleports.get(1).y;
                } else {
                    b.x = teleports.get(0).x;
                    b.y = teleports.get(0).y;
                }
                break;
            case '$':
                res = "FINAL";
                break;
            case 'X':
                if (b.enraged) {
                    g.c = ' ';
                    break;
                }
            default:
                break;
        }


        return res;
    }
}

class Teleport {
    int x;
    int y;

    Teleport(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Bender {
    int x;
    int y;

    private final int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private final String[] dirString = {"SOUTH", "EAST", "NORTH", "WEST"};
    int index = 0;

    boolean enraged;
    boolean reversed;

    String getDirection() {
        return dirString[index];
    }


    Bender(int x, int y) {
        this.x = x;
        this.y = y;
    }

    void moveNext() {
        x = getNextX();
        y = getNextY();
    }

    int getNextY() {
        return y + directions[index][0];
    }

    int getNextX() {
        return x + directions[index][1];
    }
}

class Grid {
    char c;
    int[] visited = new int[4];

    Grid(char c) {
        this.c = c;
    }

    boolean isObstacle() {
        return c == '#' || c == 'X';
    }

    boolean isVisitedTooManyTime(int index) {
        return visited[index] > 4;
    }
}
