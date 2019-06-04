import java.util.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        Node root = new Node();

        for (int i = 0; i < N; i++) {
            root.add(in.next().chars().mapToObj(c -> (char)c - '0').toArray(Integer[]::new), 0);
        }

        System.out.println(root.countNode());
    }

    static class Node {
        Map<Integer, Node> children = new HashMap<>();

        public void add(Integer[] c, int index) {
            children.putIfAbsent(c[index], new Node());
            if (index < c.length - 1) {
                children.get(c[index]).add(c, index+1);
            }
        }

        int countNode() {
            int val = children.size();
            for (Node child : children.values()) {
                val += child.countNode();
            }
            return val;
        }
    }
}
