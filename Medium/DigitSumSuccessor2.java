import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String number = "0" + in.nextLong();

        Pattern p = Pattern.compile("(\\d*?)(9*)([1-9])(0*)$");
        Matcher m = p.matcher(number);

        if (m.find()) { // Don't forget this one ^^
            String trailingZero = m.group(4);
            String nines = m.group(2);
            int lowestDigit = Integer.parseInt(m.group(3)) - 1;
            int remaining = m.group(1).isEmpty() ? 0 : (Integer.parseInt(m.group(1)) + 1);

            String nextNumber = remaining + "" + trailingZero + lowestDigit + nines;

            System.out.println(nextNumber);
        } else {
            System.out.println();
        }
    }
}