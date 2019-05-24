import java.util.*;
import java.io.*;
import java.util.stream.IntStream;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        int width = 1 + 2 * (N - 1);
        int maxWidth = 1 + 2 * width;

        String space = " ";
        String star = "*";

        System.out.println("." + space.repeat(width - 1) + "*");

        IntStream.range(1, N).forEach(i -> {
            int nbStars = 1 + 2 * i;
            int nbSpace = (maxWidth - nbStars) / 2;
            System.out.println(space.repeat(nbSpace) + star.repeat(nbStars));
        });

        IntStream.range(0, N).forEach(i -> {
            int nbStars = (1 + 2 * i);
            int nbSpace1 = (width - nbStars) / 2;
            int nbSpace2 = 2 * nbSpace1 + 1;
            System.out.println(space.repeat(nbSpace1) + star.repeat(nbStars) + space.repeat(nbSpace2) + star.repeat(nbStars));
        });
    }
}