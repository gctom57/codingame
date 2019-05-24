import java.io.UnsupportedEncodingException;
import java.util.Scanner;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String[] args) throws UnsupportedEncodingException {
        Scanner in = new Scanner(System.in);
        String MESSAGE = in.nextLine();

        StringBuilder binString = new StringBuilder();
        for (byte b : MESSAGE.getBytes()) {
            StringBuilder tmp = new StringBuilder(Integer.toBinaryString(b));
            while (tmp.length() < 7) {
                tmp.insert(0, "0");
            }

            binString.append(tmp);
        }

        char currentValue = ' ';
        StringBuilder result = new StringBuilder();

        for (char c : binString.toString().toCharArray()) {
            if (currentValue != c) {
                if (c == '1') {
                    result.append(" 0 0");
                } else {
                    result.append(" 00 0");
                }
                currentValue = c;
            } else {
                result.append("0");
            }
        }

        System.out.println(result.toString().trim());
    }
}