import java.util.Scanner;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long start = in.nextLong();
        long n = in.nextLong();

        for (int i = 0; i < n; i++) {
            String s = Long.toBinaryString(start);
            long end = s.chars().filter(ch -> ch == '1').count() * 3
                    + s.chars().filter(ch -> ch == '0').count() * 4;

            if (start == end) {
                break;
            }

            start = end;
        }

        System.out.println(start);
    }
}