import java.util.*;
import java.util.stream.IntStream;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int W = in.nextInt();
        int H = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }

        List<String> ROWS = new ArrayList<>();

        for (int i = 0; i < H; i++) {
            ROWS.add(in.nextLine());
        }

        IntStream.range(0, W).filter(j -> j % 3 == 0).forEach(j -> {

            int position = j;
            char character = 'A';

            for (int i = 0; i < ROWS.size(); i++) {
                if (i == 0) {
                    character = ROWS.get(i).charAt(position);
                }

                if (position < W - 1 && ROWS.get(i).charAt(position + 1) == '-') {
                    position += 3;
                } else if (position >= 1 && ROWS.get(i).charAt(position - 1) == '-') {
                    position -= 3;
                }
            }

            System.out.println(character + "" + ROWS.get(H - 1).charAt(position));
        });

    }
}