import java.util.*;
import java.io.*;
import java.math.*;
import java.util.stream.IntStream;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        IntStream.range(0, n).forEach(i -> {
            String card = in.nextLine().replaceAll(" ", "");

            int sum = 0;
            for (int j = card.length() - 1; j >= 0; j--) {
                int nb = Character.getNumericValue(card.charAt(j));
                if (j % 2 == 0) {
                    nb = nb * 2;
                }
                sum += nb > 9 ? nb - 9 : nb;
            }
            if (sum % 10 == 0) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        });
    }
}