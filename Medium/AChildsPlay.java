import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int w = in.nextInt();
        int h = in.nextInt();
        long nb = in.nextLong();
        if (in.hasNextLine()) {
            in.nextLine();
        }

        int x = 0;
        int y = 0;

        char[][] grid = new char[h][w];

        for (int i = 0; i < h; i++) {
            String str = in.nextLine();
            grid[i] = str.toCharArray();
            int val = str.indexOf('O');
            if (val > 0) {
                y = i;
                x = val;
            }
        }

        Dir dir = Dir.TOP;

        // Find Cycle
        List<Cycle> cycles = new ArrayList<>();

        while (true) {
            if (grid[y + dir.getY()][x + dir.getX()] == '#') {
                switch (dir) {
                    case LEFT:
                        dir = Dir.TOP;
                        break;
                    case TOP:
                        dir = Dir.RIGHT;
                        break;
                    case RIGHT:
                        dir = Dir.DOWN;
                        break;
                    case DOWN:
                        dir = Dir.LEFT;
                        break;
                }
            }

            y += dir.getY();
            x += dir.getX();

            Cycle curr = new Cycle(x, y, dir);

            if (cycles.contains(curr)) {
                break;
            }
            cycles.add(curr);
        }

        int val = (int) (nb % cycles.size());

        Cycle c = cycles.get(val - 1);

        System.out.println(c.x + " " + c.y);
    }
}

enum Dir {
    LEFT(-1, 0),
    TOP(0, -1),
    RIGHT(1, 0),
    DOWN(0, 1),
    ;

    Dir(int x, int y) {
        this.x = x;
        this.y = y;
    }

    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

class Cycle {
    int x;
    int y;
    Dir dir;

    public Cycle(int x, int y, Dir dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cycle cycle = (Cycle) o;
        return x == cycle.x &&
                y == cycle.y &&
                dir == cycle.dir;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, dir);
    }
}