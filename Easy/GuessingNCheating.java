import java.util.Scanner;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int R = in.nextInt();
        in.nextLine();

        boolean cheating = false;
        int i = 0;
        int min = 0;
        int max = Integer.MAX_VALUE;
        while (i < R && !cheating) {
            String[] line = in.nextLine().split(" ");
            int value = Integer.parseInt(line[0]);
            switch(line[2]) {
                case "high":
                    if (value < min) {
                        cheating = true;
                    } else {
                        max = Math.min(value, max);
                    }
                    break;
                case "low":
                    if (value > max) {
                        cheating = true;
                    } else {
                        min = Math.max(value, min);
                    }
                    break;
                case "on":
                    if (value < min || value > max) {
                        cheating = true;
                    }
                    break;
            }

            if (max == 1 || min == 100 || max - min < 2) {
                cheating = true;
            }

            i++;
        }

        if (cheating) {
            System.out.println("Alice cheated in round " + i);
        } else {
            System.out.println("No evidence of cheating");
        }
    }
}