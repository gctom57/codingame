import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        in.nextLine();

        List<String> invalid = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String ISBN = in.nextLine();
            if (ISBN.length() == 10) {
                if (!check10Digits(ISBN)) {
                    invalid.add(ISBN);
                }
            } else if (ISBN.length() == 13) {
                if (!check13Digits(ISBN)) {
                    invalid.add(ISBN);
                }
            } else {
                invalid.add(ISBN);
            }
        }
        System.out.println(invalid.size() + " invalid:");
        for (String s : invalid) {
            System.out.println(s);
        }
    }

    private static boolean check13Digits(String ISBN) {
        if (ISBN.contains("X")) {
            return false;
        }

        char[] c = ISBN.toCharArray();
        int sum = 0;
        for (int j = 0; j < c.length; j++) {
            sum += (c[j] - '0') * (j % 2 == 1 ? 3 : 1);
        }
        return sum % 10 == 0;
    }

    private static boolean check10Digits(String ISBN) {
        if (ISBN.substring(0, ISBN.length() - 1).contains("X")) {
            return false;
        }

        char[] c = ISBN.toCharArray();
        int sum = 0;
        for (int j = 0; j < c.length - 1; j++) {
            sum += (c[j] - '0') * (c.length - j);
        }

        int lastDigit = c[c.length - 1] - '0';
        lastDigit = lastDigit > 9 ? 10 : lastDigit;
        return (sum + lastDigit) % 11 == 0;
    }
}