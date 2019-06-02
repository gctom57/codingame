import java.util.Arrays;
import java.util.Scanner;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] opBowls = Arrays.stream(in.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] myBowls = Arrays.stream(in.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int num = in.nextInt();

        int nbGrain = myBowls[num];
        myBowls[num++] = 0;
        boolean mine = true;

        while (nbGrain > 0) {
            if ((mine && num >= 7) || (!mine && num >= 6)) {
                mine = !mine;
                num = 0;
            }

            if (mine) {
                myBowls[num]++;
            } else {
                opBowls[num]++;
            }

            num++;
            nbGrain--;
        }

        for (int i = 0; i < 6; i++) {
            System.out.print(opBowls[i] + " ");
        }
        System.out.println("[" + opBowls[6] + "]");

        for (int i = 0; i < 6; i++) {
            System.out.print(myBowls[i] + " ");
        }
        System.out.println("[" + myBowls[6] + "]");

        if (num == opBowls.length && mine) {
            System.out.println("REPLAY");
        }
    }
}