import java.util.Scanner;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    static Integer[] res;
    static String[][] sheets;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        sheets = new String[N][3];
        res = new Integer[N];
        for (int i = 0; i < N; i++) {
            sheets[i] = new String[]{in.next(), in.next(), in.next()};
        }

        for (int i = 0; i < N; i++) {
            System.out.println(getRes(i));
        }
    }

    private static int getRes(int index) {
        if (res[index] != null) {
            return res[index];
        }

        String val1 = sheets[index][1];
        String val2 = sheets[index][2];

        int i1 = val1.charAt(0) == '$' ? getRes(Integer.parseInt(val1.substring(1))) : Integer.parseInt(val1);
        int i2 = val2.equals("_") ? 0 : val2.charAt(0) == '$' ? getRes(Integer.parseInt(val2.substring(1))) : Integer.parseInt(val2);

        switch (sheets[index][0]) {
            case "VALUE":
                res[index] = i1;
                break;
            case "ADD":
                res[index] = i1 + i2;
                break;
            case "SUB":
                res[index] = i1 - i2;
                break;
            case "MULT":
                res[index] = i1 * i2;
                break;
        }

        return res[index];
    }
}