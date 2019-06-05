import java.util.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int L = in.nextInt();
        int H = in.nextInt();

        String[][] c = new String[H][L];
        for (int i = 0; i < H; i++) {
            c[i] = in.next().split("(?<=\\G.{" + L + "})");
        }

        long numA = getNumberFromInput(in, H, c);
        long numB = getNumberFromInput(in, H, c);

        long result = 0;
        switch (in.next()) {
            case "+":
                result = numA + numB;
                break;
            case "-":
                result = numA - numB;
                break;
            case "*":
                result = numA * numB;
                break;
            case "/":
                result = numA / numB;
                break;
        }

        writeNumber(result, c);
    }

    private static void writeNumber(long result, String[][] c) {
        Deque<Long> queue = new ArrayDeque<>();

        queue.add(result);
        while (result >= 20) {
            queue.poll();
            queue.push(result % 20);
            queue.push(result / 20);
            result /= 20;
        }

        while (!queue.isEmpty()) {
            int index = Math.toIntExact(queue.poll());
            for (String[] strings : c) {
                System.out.println(strings[index]);
            }
        }
    }

    private static long getNumberFromInput(Scanner in, int H, String[][] c) {
        long num = 0;
        int S = in.nextInt();
        int power = (S / H) - 1;

        List<Integer> ints = new ArrayList<>();
        for (int i = 0; i < S; i++) {

            ints = findIndexes(c[i % H], in.next(), ints);

            if ((i + 1) % H == 0) {
                num += ints.get(0) * Math.pow(20, power--);
                ints.clear();
            }
        }

        return num;
    }

    private static List<Integer> findIndexes(String[] origin, String toFind, List<Integer> currentIndexes) {
        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < origin.length; i++) {
            if (origin[i].equals(toFind) && (currentIndexes.isEmpty() || currentIndexes.contains(i))) {
                indexes.add(i);
            }
        }

        return indexes;
    }
}