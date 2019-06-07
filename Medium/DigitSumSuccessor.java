import java.util.Scanner;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String number = "0" + in.nextLong();

        String trailingZero = "";
        String lowestDigit = "";
        String nines = "";
        String remaining = "";

        for (int i = number.length() - 1; i >= 0; i--) {
            if (number.charAt(i) != '0') {
                lowestDigit = "" + number.charAt(i);
                break;
            }
            trailingZero = number.charAt(i) + trailingZero;
        }

        int nbChar = lowestDigit.length() + trailingZero.length();

        for (int i = number.length() - 1 - nbChar; i >= 0; i--) {
            if (number.charAt(i) != '9') {
                break;
            }
            nines = number.charAt(i) + nines;
        }

        nbChar += nines.length();

        if (number.length() - nbChar > 0) {
            remaining = number.substring(0, number.length() - nbChar);
        }

        StringBuilder build = new StringBuilder();
        if (!remaining.equals("")) {
            build.append((Integer.parseInt(remaining) + 1));
        }
        if (!trailingZero.equals("")) {
            build.append(trailingZero);
        }
        if (!lowestDigit.equals("")) {
            build.append((Integer.parseInt(lowestDigit) - 1));
        }
        if (!nines.equals("")) {
            build.append(nines);
        }

        System.out.println(build.toString());
    }
}