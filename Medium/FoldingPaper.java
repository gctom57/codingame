import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String order = in.nextLine();
        String side = in.nextLine();

        Map<Character, Integer> map = new HashMap<>();
        map.put('U', 1);
        map.put('R', 1);
        map.put('L', 1);
        map.put('D', 1);

        for (int i = 0; i < order.length(); i++) {
            char c = order.charAt(i);

            switch (c) {
                case 'U':
                    map.computeIfPresent('R', (k, v) -> v *= 2);
                    map.computeIfPresent('L', (k, v) -> v *= 2);
                    map.put('D', map.get('D') + map.get('U'));
                    break;
                case 'D':
                    map.computeIfPresent('R', (k, v) -> v *= 2);
                    map.computeIfPresent('L', (k, v) -> v *= 2);
                    map.put('U', map.get('U') + map.get('D'));
                    break;
                case 'L':
                    map.computeIfPresent('U', (k, v) -> v *= 2);
                    map.computeIfPresent('D', (k, v) -> v *= 2);
                    map.put('R', map.get('L') + map.get('R'));
                    break;
                case 'R':
                    map.computeIfPresent('U', (k, v) -> v *= 2);
                    map.computeIfPresent('D', (k, v) -> v *= 2);
                    map.put('L', map.get('L') + map.get('R'));
                    break;
            }

            map.put(c, 1);
        }

        System.out.println(map.get(side.charAt(0)));
    }
}