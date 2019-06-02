import java.util.Scanner;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String c = in.nextLine();

        int index = c.indexOf("+");
        if (index == -1) {
            index = c.lastIndexOf("-");
        }

        double cReal = Double.parseDouble(c.substring(0, index));
        double cImag = Double.parseDouble(c.substring(index, c.length() - 1));

        int m = in.nextInt();
        double zReal = 0.0;
        double zImag = 0.0;

        for (int i = 0; i < m; i++) {
            double tmp = zReal;
            zReal = zReal * zReal - zImag * zImag + cReal;
            zImag = 2 * tmp * zImag + cImag;

            if (zReal * zReal + zImag * zImag >= 4.0) {
                m = i + 1;
                break;
            }
        }

        System.out.println(m);
    }
}