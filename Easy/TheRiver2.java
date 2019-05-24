import java.util.Scanner;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int r1 = in.nextInt();

        boolean found = false;
        for (int start = r1 - 1; start > 0; start--) {
            int current = start;
            current = nextRiver(current);
            if (current == r1) {
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    private static int nextRiver(int n) {
        int s = n;
        while (s > 0) {
            n = n + (s % 10);
            s = s / 10;
        }
        return n;
    }
}