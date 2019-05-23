import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) throws UnsupportedEncodingException {
        Scanner in = new Scanner(System.in);
        String MESSAGE = in.nextLine();

        String binString = "";
        for (byte b : MESSAGE.getBytes()) {
            String tmp = Integer.toBinaryString(b);
            while (tmp.length() < 7) {
                tmp = "0" + tmp;
            }

            binString += tmp;
        }

        char currentValue = ' ';
        String result = "";

        for (char c : binString.toCharArray()) {
            if (currentValue != c) {
                if (c == '1') {
                    result += " 0 0";
                } else {
                    result += " 00 0";
                }
                currentValue = c;
            } else {
                result += "0";
            }
        }

        System.out.println(result.trim());
    }
}