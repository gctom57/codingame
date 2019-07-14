import java.util.Scanner;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    private static int[] decimal = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static String[] roman = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int result = romanToDecimal(in.next()) + romanToDecimal(in.next());

        System.out.println(decimalToRoman(result));
    }

    private static int romanToDecimal(String s) {
        int res = 0;
        for (int i = 0; i < decimal.length; i++) {
            while (s.indexOf(roman[i]) == 0) {
                res += decimal[i];
                s = s.substring(roman[i].length());
            }
        }
        return res;
    }

    private static String decimalToRoman(int number) {
        String str = "";
        for (int i = 0; i < decimal.length; i++) {
            while (number >= decimal[i]) {
                str += roman[i];
                number -= decimal[i];
            }
        }
        return str;
    }
}