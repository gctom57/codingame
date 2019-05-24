import java.util.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int SIZE = in.nextInt();
        double half = SIZE / 2d;

        int N = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }

        Map<String, Integer> scoreBoard = new LinkedHashMap<>();
        for (int i = 0; i < N; i++) {
            String name = in.nextLine();
            scoreBoard.put(name, 0);
        }

        int T = in.nextInt();
        for (int i = 0; i < T; i++) {
            String throwName = in.next();
            int x = in.nextInt();
            int y = in.nextInt();

            scoreBoard.put(throwName, scoreBoard.get(throwName) + calcScore(x, y, half));
        }

        scoreBoard
                .entrySet()
                .stream()
                .sorted((e1, e2) -> e2.getValue() - e1.getValue())
                .forEach(e -> System.out.println(e.getKey() + " " + e.getValue()));
    }

    private static int calcScore(int x, int y, double radius) {
        // In diamond shape
        if (Math.abs(x) + Math.abs(y) <= radius) {
            return 15;
        }

        // In circle
        if (Math.hypot(x, y) <= radius) {
            return 10;
        }

        // In square
        if (Math.abs(x) <= radius && Math.abs(y) <= radius) {
            return 5;
        }

        return 0;
    }
}