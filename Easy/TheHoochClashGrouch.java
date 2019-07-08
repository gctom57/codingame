import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    private static int[] combi = new int[]{1, 1, 2, 6, 24, 120};
    private static double[] pow = new double[3500];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int low = in.nextInt();
        int high = in.nextInt();

        Map<Double, Integer> volumes = new HashMap<>();

        for (int i = low; i <= high; i++) {
            pow[i - low] = Math.pow(i * 0.5d, 3);
        }

        for (int i = low; i < high; i++) {
            for (int j = i + 1; j <= high; j++) {
                double val = pow[i - low] + pow[j - low];
                volumes.compute(val, (k, v) -> (v == null) ? 1 : v + 1);
            }
        }

        long count = volumes.entrySet()
                .stream()
                .filter(e -> e.getValue() >= 2)
                .count();

        Map<Integer, Long> maps = volumes.values()
                .stream()
                .filter(i -> i >= 2)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        long count2 = maps.entrySet()
                .stream()
                .mapToLong(e -> e.getValue() * combi[e.getKey()])
                .sum();

        System.out.println(count + " " + count2);
    }
}