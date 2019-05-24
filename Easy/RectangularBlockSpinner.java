import java.util.Scanner;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        int angle = in.nextInt() % 360;
        in.nextLine();

        int newSize = 2 * size - 1;

        char[][] results = new char[newSize][newSize];
        for (int i = 0; i < newSize; i++) {
            for (int j = 0; j < newSize; j++) {
                results[i][j] = ' ';
            }
        }

        for (int i = 0; i < size; i++) {
            String line = in.nextLine();
            for (int j = 0; j < size; j++) {
                switch (angle) {
                    case 45:
                        results[size - 1 + i - j][i + j] = line.charAt(j * 2);
                        break;
                    case 135:
                        results[2 * size - 2 - i - j][size - 1 + i - j] = line.charAt(j * 2);
                        break;
                    case 225:
                        results[size - 1 - i + j][i + j] = line.charAt(j * 2);
                        break;
                    case 315:
                        results[i + j][size - 1 - i + j] = line.charAt(j * 2);
                        break;
                }
            }
        }

        for (int i = 0; i < newSize; i++) {
            for (int j = 0; j < newSize; j++) {
                System.out.print(results[i][j]);
            }
            System.out.println();
        }
    }
}