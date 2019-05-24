import java.util.Scanner;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int c = in.nextInt();

        int[] devices = new int[n];
        boolean[] devicesOn = new boolean[n];
        for (int i = 0; i < n; i++) {
            devices[i] = in.nextInt();
        }

        boolean blown = false;
        int min = c;
        int tmp = c;
        for (int i = 0; i < m; i++) {
            int mx = in.nextInt() - 1;

            if (devicesOn[mx]) {
                tmp += devices[mx];
            } else {
                tmp -= devices[mx];
            }

            if (tmp < 0) {
                blown = true;
                break;
            }

            if (tmp < min) {
                min = tmp;
            }

            devicesOn[mx] = !devicesOn[mx];
        }

        if (blown) {
            System.out.println("Fuse was blown.");
        } else {
            System.out.println("Fuse was not blown.");
            System.out.println("Maximal consumed current was " + (c - min) + " A.");
        }
    }
}