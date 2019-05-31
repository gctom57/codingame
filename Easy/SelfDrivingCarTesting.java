import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        in.nextLine();
        String[] pos = in.nextLine().split(";");
        int index = Integer.parseInt(pos[0]) - 1;

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i < pos.length; i++) {
            int nb = Integer.parseInt(pos[i].substring(0, pos[i].length() - 1));
            char c = pos[i].charAt(pos[i].length() - 1);
            while (nb-- > 0) {
                queue.add(c == 'L' ? -1 : (c == 'R' ? 1 : 0));
            }
        }

        index += queue.poll();
        for (int i = 0; i < N; i++) {
            String[] patterns = in.nextLine().split(";");
            int j = Integer.parseInt(patterns[0]);
            while (j-- > 0) {
                System.out.println(patterns[1].substring(0, index) + '#' + patterns[1].substring(index + 1));
                index += queue.poll();
            }
        }
    }
}