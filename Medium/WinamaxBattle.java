import java.util.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    static List<String> cardsValue;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        cardsValue = Arrays.asList("2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A");

        int n = in.nextInt(); // the number of cards for player 1
        Queue<String> player1 = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            player1.add(in.next()); // the n cards of player 1
        }

        int m = in.nextInt(); // the number of cards for player 2
        Queue<String> player2 = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            player2.add(in.next()); // the m cards of player 2
        }

        List<String> cardsP1 = new ArrayList<>();
        List<String> cardsP2 = new ArrayList<>();

        int round = 0;
        while(!player1.isEmpty() && !player2.isEmpty()) {
            String p1 = player1.poll();
            String p2 = player2.poll();

            cardsP1.add(p1);
            cardsP2.add(p2);

            int val = compareCards(p1, p2);

            if (val == 0) {
                if (player1.size() < 4 || player2.size() < 4) {
                    round = -1;
                    break;
                }

                cardsP1.add(player1.poll());
                cardsP1.add(player1.poll());
                cardsP1.add(player1.poll());

                cardsP2.add(player2.poll());
                cardsP2.add(player2.poll());
                cardsP2.add(player2.poll());

                continue;
            } else {
                if (val < 0) {
                    player1.addAll(cardsP1);
                    player1.addAll(cardsP2);
                } else {
                    player2.addAll(cardsP1);
                    player2.addAll(cardsP2);
                }
                cardsP1.clear();
                cardsP2.clear();
            }

            round++;
        }

        if (round == -1) {
            System.out.println("PAT");
        } else {
            System.out.println((player1.isEmpty() ? 2 : 1) + " " + round);
        }
    }

    private static int compareCards(String p1, String p2) {
        int i1 = cardsValue.indexOf(p1.substring(0, p1.length() - 1));
        int i2 = cardsValue.indexOf(p2.substring(0, p2.length() - 1));
        return i2 - i1;
    }
}