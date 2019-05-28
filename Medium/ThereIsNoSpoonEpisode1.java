import java.util.Scanner;

/**
 * Don't let the machines win. You are humanity's last hope...
 **/
class Player {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int width = in.nextInt(); // the number of cells on the X axis
        int height = in.nextInt(); // the number of cells on the Y axis
        if (in.hasNextLine()) {
            in.nextLine();
        }
        boolean[][] b = new boolean[height][width];
        for (int i = 0; i < height; i++) {
            String line = in.nextLine(); // width characters, each either 0 or .
            System.err.println(line);
            String[] str = line.split("");

            for (int j=0; j < width; j++) {
                b[i][j] = !str[j].equals(".");
            }
        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (b[i][j]) {
                    String right = getCoordinate(b, i, j+1, true);
                    String down = getCoordinate(b, i+1, j, false);
                    System.err.println("i: " + i + ", j: " + j + "b[i][j]: " + b[i][j]);
                    System.out.println(j + " "+ i + " " + right + " " + down);
                }
            }
        }

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");


        // Three coordinates: a node, its right neighbor, its bottom neighbor
        System.out.println("0 0 1 0 0 1");
    }

    static String getCoordinate(boolean[][] b, int i, int j, boolean horizontal) {
        if (horizontal) {
            while(j < b[0].length) {
                if (b[i][j]) {
                    return j + " " + i;
                }
                j++;
            }
        } else {
            while(i < b.length) {
                if (b[i][j]) {
                    return j + " " + i;
                }
                i++;
            }
        }

        return "-1 -1";
    }
}
    