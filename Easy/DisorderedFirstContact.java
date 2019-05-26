import java.util.Scanner;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        int absN = Math.abs(N);

        if (in.hasNextLine()) {
            in.nextLine();
        }
        String MESSAGE = in.nextLine();

        while(absN > 0) {
            if (N < 0) {
                MESSAGE = encode(MESSAGE).message;
            } else {
                MESSAGE = decode(MESSAGE);
            }
            absN--;
        }

        System.out.println(MESSAGE);
    }

    private static Result encode(String message) {
        Result result = new Result();
        int length = 1;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < message.length(); i += length++) {
            String sub = message.substring(i, Math.min(message.length(), i+length));
            result.lastLength = length;
            result.lastSubLength = sub.length();
            if (length % 2 == 0) {
                builder.insert(0, sub);
            } else {
                builder.append(sub);
            }
        }
        result.message = builder.toString();
        return result;
    }

    private static String decode(String message) {
        Result r = encode(message);

        StringBuilder result;
        boolean fromLeft = r.lastLength % 2 == 0;

        int leftIndex = 0;
        int rightIndex = message.length();

        if (fromLeft) {
            result = new StringBuilder(message.substring(leftIndex, r.lastSubLength));
            leftIndex += r.lastSubLength;
        } else {
            result = new StringBuilder(message.substring(rightIndex - r.lastSubLength));
            rightIndex -= r.lastSubLength;
        }

        int times = r.lastLength - 1;

        while (times > 0) {
            if (times % 2 == 0) {
                result.insert(0, message, leftIndex, leftIndex + times);
                leftIndex += times--;
            } else {
                result.insert(0, message, rightIndex - times, rightIndex);
                rightIndex -= times--;
            }
        }

        return result.toString();
    }
}

class Result {
    int lastLength;
    int lastSubLength;
    String message;
}