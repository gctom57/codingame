import java.util.Scanner;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] numbers = in.nextLine().chars().map(i -> i - '0').toArray();

        int min = 1; // value for mod 1

        for (int j = 2; j <= 9; j++) {
            int nbModular = 1;
            int currModulo = numbers[0] % j;

            for (int i = 1; i < numbers.length; i++) {
                int tmp = numbers[i] % j;

                if (currModulo != tmp) {
                    nbModular++;
                    currModulo = tmp;
                }
            }

            if (min > nbModular) {
                System.out.println(j);
                return;
            }

            min = nbModular;
        }

        System.out.println("Normal");
    }
}