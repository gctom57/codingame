import java.util.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    static Map<Integer, List<Integer>> map = new HashMap<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // the number of relationships of influence

        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(in.nextInt(), k -> new ArrayList<>()).add(in.nextInt());
        }

        int max = 0;
        for (Map.Entry<Integer, List<Integer>> e : map.entrySet()) {
            max = Math.max(max, findMaxDepth(e.getKey()));
        }

        System.out.println(max);
    }

    private static int findMaxDepth(Integer key) {
        List<Integer> list = map.get(key);
        if (list!= null && !list.isEmpty()) {
            int max = 0;
            for (Integer i : list) {
                max = Math.max(max, findMaxDepth(i) + 1);
            }
            return max;
        }
        return 1;
    }
}