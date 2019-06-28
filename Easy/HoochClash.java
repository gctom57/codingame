import java.util.Scanner;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int A = in.nextInt();
        int B = in.nextInt();
        int C = in.nextInt();
        int D = in.nextInt();

        double toFind = Math.pow(C * 0.5d, 3) + Math.pow(D * 0.5d, 3);

        int low = A;
        int high = B;

        int i = D;
        int j = C;

        boolean found = false;

        while (high >= low) {
            double cal = Math.pow(high * 0.5d, 3) + Math.pow(low * 0.5d, 3);

            if (cal == toFind) {
                i = high;
                j = low;
                if (i != D || j != C) {
                    found = true;
                    break;
                }
                high--;
            } else if (cal > toFind) {
                high--;
            } else {
                low++;
            }
        }

        if (found) {
            System.out.println(j + " " + i);
        } else {
            System.out.println("VALID");
        }
    }
}