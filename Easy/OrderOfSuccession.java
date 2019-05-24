import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        Node root = null;
        for (int i = 0; i < n; i++) {
            Node node = new Node(in);
            if (root == null) {
                root = node;
            } else {
                root.addNode(node);
            }
        }

        downFirst(root);
    }

    private static void downFirst(Node node) {
        if (node.isVisible()) {
            System.out.println(node.name);
        }

        if (node.hasChildren()) {
            for (int i = 0; i < node.children.size(); i++) {
                downFirst(node.children.get(i));
            }
        }
    }
}

class Node {
    String name;
    String parent;
    Integer birth;
    boolean alive;
    String religion;
    String gender;

    List<Node> children;

    Node(Scanner in) {
        this.name = in.next();
        this.parent = in.next();
        this.birth = in.nextInt();
        this.alive = in.next().equals("-");
        this.religion = in.next();
        this.gender = in.next();
        children = new ArrayList<>();
    }

    boolean addNode(Node node) {
        if (node.parent.equals("-")) {
            return false;
        } else if (node.parent.equals(this.name)) {
            this.children.add(node);
            this.children.sort(Comparator.comparing(Node::getGender).reversed().thenComparing(Node::getBirth));
            return true;
        } else {
            for (Node child : children) {
                boolean b = child.addNode(node);
                if (b) {
                    return true;
                }
            }
        }

        return false;
    }

    boolean hasChildren() {
        return !children.isEmpty();
    }

    private String getGender() {
        return gender;
    }

    private Integer getBirth() {
        return birth;
    }

    private boolean isAlive() {
        return this.alive;
    }

    private boolean isAnglican() {
        return religion.equals("Anglican");
    }

    boolean isVisible() {
        return isAlive() && isAnglican();
    }
}