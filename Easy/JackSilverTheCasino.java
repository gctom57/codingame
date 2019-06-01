import java.util.Scanner;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int ROUNDS = in.nextInt();
        int CASH = in.nextInt();
        in.nextLine();
        for (int i = 0; i < ROUNDS; i++) {
            String[] PLAY = in.nextLine().split(" ");
            int casino = Integer.parseInt(PLAY[0]);
            int player = Integer.parseInt(PLAY.length == 3 ? PLAY[2] : "-1");

            int bet = (int) Math.ceil(CASH / 4d);
            CASH -= bet;

            int multiply = -1;

            if (PLAY[1].equals("PLAIN") && casino == player) {
                multiply = 35;
            } else if ((PLAY[1].equals("EVEN") && casino % 2 == 0 && casino != 0)
                    || (PLAY[1].equals("ODD") && casino % 2 == 1)) {
                multiply = 1;
            }

            CASH += bet + bet * multiply;
        }

        System.out.println(CASH);
    }
}