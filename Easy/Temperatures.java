import java.util.Scanner;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // the number of temperatures to analyse

        int closest = 0;
        for (int i = 0; i < n; i++) {
            int t = in.nextInt(); // a temperature expressed as an integer ranging from -273 to 5526
            if ((closest == 0 || Math.abs(closest) >= Math.abs(t))
                    && (Math.abs(closest) != Math.abs(t) || closest <= t)) {
                closest = t;
            }
        }

        System.out.println(closest);
    }
}