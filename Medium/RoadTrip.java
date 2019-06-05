import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        double C = (double) in.nextInt();
        int P = in.nextInt();

        List<Friend> friends = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int budget = in.nextInt();
            int joy = in.nextInt();
            friends.add(new Friend((double) budget, joy));
        }

        int maxJoy = 0;
        for (int i = 1; i <= N; i++) {
            double perPerson = (C + P * i) / i;

            List<Friend> tmpList = friends.stream()
                    .filter(f -> f.budget >= perPerson)
                    .sorted(Comparator.comparingInt(Friend::getJoy).reversed())
                    .collect(Collectors.toList());

            int tmpJoy = 0;
            if (tmpList.size() >= i - 1) {
                for (int j = 0; j < i - 1; j++) {
                    tmpJoy += tmpList.get(j).getJoy();
                }
            }

            maxJoy = Math.max(tmpJoy, maxJoy);
        }

        System.out.println(maxJoy);
    }
}

class Friend {
    double budget;
    int joy;

    public Friend(double budget, int joy) {
        this.budget = budget;
        this.joy = joy;
    }

    int getJoy() {
        return joy;
    }
}