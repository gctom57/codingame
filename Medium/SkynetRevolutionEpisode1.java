import java.util.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Player {

    private static boolean[][] links;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(); // the total number of nodes in the level, including the gateways

        links = new boolean[N][N];

        int L = in.nextInt(); // the number of links
        int E = in.nextInt(); // the number of exit gateways
        for (int i = 0; i < L; i++) {
            int N1 = in.nextInt(); // N1 and N2 defines a link between these nodes
            int N2 = in.nextInt();
            links[N1][N2] = true;
            links[N2][N1] = true;
        }

        int[] gateways = new int[E];
        for (int i = 0; i < E; i++) {
            int EI = in.nextInt(); // the index of a gateway node
            gateways[i] = EI;
            System.err.print(EI + " ");
        }

        // game loop
        while (true) {
            int SI = in.nextInt();

            String result = "";
            int maxDepth = N + 1;
            for (int gateway : gateways) {
                NodeAndDepth newNode = findGateway(SI, gateway, false);
                if (newNode.node != -1 && newNode.depth < maxDepth) {
                    maxDepth = newNode.depth;
                    result = newNode.node + " " + gateway;
                }

                newNode = findGateway(SI, gateway, true);
                if (newNode.node != -1 && newNode.depth < maxDepth) {
                    maxDepth = newNode.depth;
                    result = newNode.node + " " + gateway;
                }
            }

            System.out.println(result);
        }
    }

    private static NodeAndDepth findGateway(int root, int gateaway, boolean reverse) {
        Set<Integer> visited = new LinkedHashSet<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(root);

        int nbJump = 0;
        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (!visited.contains(node)) {
                visited.add(node);
                for (int i = 0; i < links.length; i++) {
                    if ((!reverse && links[node][i]) || (reverse && links[i][node])) {
                        if (i == gateaway) {
                            return new NodeAndDepth(node, nbJump);
                        }
                        stack.push(i);
                    }
                }
            }
            nbJump++;
        }
        return new NodeAndDepth(0, 0);
    }
}

class NodeAndDepth {
    int node;
    int depth;

    NodeAndDepth(int node, int depth) {
        this.node = node;
        this.depth = depth;
    }
}