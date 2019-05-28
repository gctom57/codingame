import java.util.Scanner;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int speed = in.nextInt();
        int lightCount = in.nextInt();
        int[][] lights = new int[lightCount][2];
        for (int i = 0; i < lightCount; i++) {
            lights[i] = new int[]{in.nextInt(), in.nextInt()};
        }

        for (int i = 0; i < lightCount; i++) {
            if ((36 * lights[i][0]) % (20 * speed * lights[i][1]) >= (10 * speed * lights[i][1])) {
                speed--;
                i = -1;
            }
        }

        System.out.println(speed);
    }
}