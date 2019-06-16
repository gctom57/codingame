import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Queue;
import java.util.Scanner;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    static String[][] addition = {
            {"T1", "T", "0"},
            {"T", "0", "1"},
            {"0", "1", "1T"}
    };

    static String[][] multiplication = {
            {"1", "0", "T"},
            {"0", "0", "0"},
            {"T", "0", "1"}
    };

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String lhs = in.nextLine();
        String op = in.nextLine();
        String rhs = in.nextLine();

        String res = "";

        switch (op) {
            case "+":
                res = addition(lhs, rhs);
                break;
            case "-":
                res = substraction(lhs, rhs);
                break;
            case ">>":
                res = shiftDown(lhs, rhs);
                break;
            case "<<":
                res = shiftUp(lhs, rhs);
                break;
            case "*":
                res = multiplication(lhs, rhs);
                break;
        }

        System.out.println(res);
    }

    private static int getIndex(char c) {
        return c == 'T' ? 0 : (c == '0' ? 1 : 2);
    }

    private static String addition(String l, String r) {
        StringBuilder tmp = new StringBuilder(l);

        Queue<String> rets = new ArrayDeque<>();
        for (int i = 0; i < l.length() || i < r.length(); i++) {
            char c = '0';
            char d = '0';

            if (i < l.length()) {
                c = l.charAt(l.length() - 1 - i);
            }

            if (i < r.length()) {
                d = r.charAt(r.length() - 1 - i);
            }

            int cIndex = getIndex(c);
            int dIndex = getIndex(d);

            String res = addition[cIndex][dIndex];

            if (l.length() - 1 < i) {
                tmp.insert(0, res.charAt(res.length() - 1));
            } else {
                tmp.setCharAt(l.length() - 1 - i, res.charAt(res.length() - 1));
            }

            if (res.length() > 1) {
                String ret = res.substring(0, res.length() - 1);
                ret = fillWithZero(ret, i + 1);
                rets.add(ret);
            }
        }

        String tmps = tmp.toString();
        if (!rets.isEmpty()) {
            while (!rets.isEmpty()) {
                tmps = addition(tmps, rets.poll());

            }
            if (tmps.charAt(0) == '0') {
                tmps = tmps.substring(1);
            }
        }


        return tmps;
    }

    private static String inverse(String r) {
        return r.replaceAll("T", "M").replaceAll("1", "T").replaceAll("M", "1");
    }

    private static String substraction(String l, String r) {
        return addition(l, inverse(r));
    }


    private static String multiplication(String l, String r) {
        int index = 0;

        Queue<String> toAdd = new ArrayDeque<>();
        while (index < l.length() && index < r.length()) {
            char d = r.charAt(r.length() - 1 - index);
            int dIndex = getIndex(d);

            StringBuilder build = new StringBuilder();
            for (int i = l.length() - 1; i >= 0; i--) {
                char c = l.charAt(i);
                int cIndex = getIndex(c);

                String res = multiplication[cIndex][dIndex];

                build.insert(0, res);
            }

            String tmp = build.toString();
            if (index > 0) {
                tmp = fillWithZero(tmp, index);
            }

            toAdd.add(tmp);
            index++;
        }

        String res = toAdd.poll();
        while (!toAdd.isEmpty()) {
            String poll = toAdd.poll();
            res = addition(poll, res);
        }

        return res;
    }

    private static String shiftUp(String l, String r) {
        String tmp = r;
        StringBuilder res = new StringBuilder(l);
        while (!tmp.startsWith("T") && !tmp.equals("0")) {
            res.append("0");
            tmp = addition(tmp, "T");
        }
        return res.toString();
    }

    private static String shiftDown(String l, String r) {
        String tmp = r;
        String res = l;

        while (!tmp.startsWith("T") && !tmp.equals("0")) {
            res = res.length() == 1 ? "0" : res.substring(0, res.length() - 1);
            tmp = addition(tmp, "T");
        }

        return res;
    }

    private static String fillWithZero(String str, int nb) {
        return str + String.join("", Collections.nCopies(nb, "0"));
    }
}