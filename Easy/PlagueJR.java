import java.util.*;

public class Solution {

    static Map<Integer, List<Integer>> links = new HashMap<>();
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        for (int i = 0; i < N; i++) {
            int A = in.nextInt();
            int B = in.nextInt();
            links.computeIfAbsent(A, k -> new ArrayList<>()).add(B);
            links.computeIfAbsent(B, k -> new ArrayList<>()).add(A);
        }

        int max = Integer.MAX_VALUE;
        for (Map.Entry<Integer, List<Integer>> e : links.entrySet()) {

            visited = new boolean[N+1];
            visited[e.getKey()] = true;

            int tmp = findMaxDepth(e.getKey()) - 1;

            max = Math.min(max, tmp);

        }

        System.out.println(max);
    }

    private static int findMaxDepth(Integer index) {
        List<Integer> list = links.get(index);
        if (list != null && !list.isEmpty()) {
            int max = 0;
            for (Integer i : list) {
                if (!visited[i]) {
                    visited[i] = true;
                    max = Math.max(max, findMaxDepth(i));
                }
            }
            return max + 1;
        }
        return 1;
    }
}