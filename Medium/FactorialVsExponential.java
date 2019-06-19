import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int K = in.nextInt();
        List<Integer> s = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            float A = in.nextFloat();

            int val = 1;
            double fact = 0; // ln(1)
            while (val * Math.log(A) > fact) {
                fact += Math.log(++val); // ln(n!) = ln(2) + ln(3) + ...
            }

            s.add(val);
        }

        System.out.println(s.stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }
}