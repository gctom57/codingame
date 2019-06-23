import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    static Map<Integer, Integer> cycleMap = new HashMap<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        for (int i = 0; i < N; i++) {
            int A = in.nextInt();
            int B = in.nextInt();

            int max = Integer.MIN_VALUE;
            int nbMax = A;
            for (int j = A; j <= B; j++) {
                int cycle = syracuseCycle(j);
                if (cycle > max) {
                    max = cycle;
                    nbMax = j;
                }
            }

            System.out.println(nbMax + " " + max);
        }
    }

    static int syracuseCycle(int number) {
        if (cycleMap.containsKey(number)) {
            return cycleMap.get(number);
        }

        int c = number;
        int res = 1;
        while (c != 1) {
            c = c % 2 == 0 ? c / 2 : 3 * c + 1;

            if (cycleMap.containsKey(c)) {
                cycleMap.put(number, cycleMap.get(c) + res);
                return cycleMap.get(number);
            }

            res++;
        }

        cycleMap.put(number, res);
        return res;
    }
}