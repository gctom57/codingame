import java.util.*;
import java.util.stream.Collectors;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int R = in.nextInt();
        int L = in.nextInt();

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(R);

        List<Integer> list = new ArrayList<>();

        for (int i = 1; i < L; i++) {
            list.clear();

            int current = queue.poll();
            int counter = 1;
            while (!queue.isEmpty()) {
                int j = queue.poll();
                if (current == j) {
                    counter++;
                } else {
                    list.add(counter);
                    list.add(current);
                    current = j;
                    counter = 1;
                }
            }

            list.add(counter);
            list.add(current);

            queue.addAll(list);
        }

        System.out.println(queue.stream().map(Object::toString).collect(Collectors.joining(" ")));
    }
}