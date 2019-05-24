import java.util.*;
import java.io.*;
import java.awt.Polygon;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        final Polygon polygon = new Polygon();
        for (int i = 0; i < N; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            polygon.addPoint(x, y);
        }
        int M = in.nextInt();
        for (int i = 0; i < M; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            System.out.println(polygon.contains(x, y) ? "hit" : "miss");
        }
    }
}