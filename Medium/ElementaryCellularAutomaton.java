import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    static List<String> neighborhood = Arrays.asList("111", "110", "101", "100", "011", "010", "001", "000");

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] binary = Integer.toBinaryString((1 << 8) | in.nextInt()).substring(1).split("");

        int N = in.nextInt();
        String p = in.next();

        System.out.println(p);
        p = p.replaceAll("\\.", "0").replaceAll("@", "1");

        int l = p.length();
        for (int i = 0; i < N - 1; i++) {
            StringBuilder tmp = new StringBuilder();
            for (int j = 0; j < l; j++) {
                char c = p.charAt((l + j - 1) % l);
                char c1 = p.charAt((l + j) % l);
                char c2 = p.charAt((l + j + 1) % l);

                int index = neighborhood.indexOf("" + c + c1 + c2);
                tmp.append(binary[index]);
            }
            p = tmp.toString();
            System.out.println(p.replaceAll("0", "\\.").replaceAll("1", "@"));
        }
    }
}