import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        List<Integer> list = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            list.add(in.nextInt());
        }
        Collections.sort(list);

        int total = 0;

        while (list.size() > 1) {
            int nb1 = list.remove(1);
            int nb2 = list.remove(0);
            int sum = nb1 + nb2;
            list.add(sum);
            Collections.sort(list);
            total += sum;
        }
        System.out.println(total);
    }
}