import java.util.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        long X = in.nextLong();
        
        List<Horse> horses = new ArrayList<>(N + M);
        for (int i = 0; i < N; i++) {
            horses.add(new Horse(in.nextLong(), in.nextLong()));
        }

        for (int i = 0; i < M; i++) {
            long E = (1103515245L * X + 12345) % 2147483648L;
            horses.add(new Horse(X, E));
            X = (1103515245L * E + 12345) % 2147483648L;
        }

        horses.sort(Comparator.comparingDouble(a -> a.v));

        long delta = horses.get(0).deltaWith(horses.get(1));
        for (int i = 0; i < horses.size() - 1; i++) {
            Horse ih = horses.get(i);

            for (int j = i + 1; j < horses.size(); j++) {
                Horse jh = horses.get(j);

                if (jh.v - ih.v >= delta) {
                    break;
                }
                delta = Math.min(delta, jh.deltaWith(ih));
            }
        }
        System.out.println(delta);
    }
}

public class Horse {
    long v;
    long e;

    Horse(long v, long e) {
        this.v = v;
        this.e = e;
    }

    long deltaWith(Horse h) {
        return Math.abs(h.v - this.v) + Math.abs(h.e - this.e);
    }
}