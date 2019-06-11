import java.util.Scanner;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int X = in.nextInt();
        in.nextLine();

        char[][] c = new char[N][N];
        for (int i = 0; i < N; i++) {
            c[i] = in.nextLine().toCharArray();
        }

        for (int i = 0; i < X; i++) {
            int y = N % 2 == 0 ? N - 1 : 0;
            int x = N - 1;
            int dir = x % 2 == 0 ? 1 : -1;

            char end = c[y][x];

            while(x != 0 || y != N - 1) {
                c[y][x] = c[y + dir][x];

                y += dir;

                if (y % (N - 1) == 0 && x > 0) {
                    c[y][x] = c[y][--x];
                    dir *= -1;
                }
            }

            c[y][x] = end;
        }

        for (int i = 0; i < N; i++) {
            System.out.println(new String(c[i]));
        }
    }
}