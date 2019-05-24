import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        Integer[][] cities = new Integer[N][2];
        for (int i = 0; i < N; i++) {
            int X = in.nextInt();
            int Y = in.nextInt();
            cities[i] = new Integer[]{X, Y};
        }

        Integer[] coord = cities[0];
        List<Integer[]> list = new ArrayList(Arrays.asList(cities));
        list.remove(0);

        Double total = 0.0;
        while (!list.isEmpty()) {
            int index = 0;
            Double tmpDistance = -1.0;
            for (int i = 0; i < list.size(); i++) {
                Double d = calc(coord[0], coord[1], list.get(i)[0], list.get(i)[1]);
                if (tmpDistance < 0.0 || d < tmpDistance) {
                    index = i;
                    tmpDistance = d;
                }
            }

            total += tmpDistance;
            coord = list.get(index);
            list.remove(index);
        }

        total += calc(coord[0], coord[1], cities[0][0], cities[0][1]);

        System.out.println(Math.round(total));
    }

    private static Double calc(int x, int y, int x1, int y1) {
        return Math.sqrt(Math.pow(x - x1, 2) + Math.pow(y - y1, 2));
    }
}