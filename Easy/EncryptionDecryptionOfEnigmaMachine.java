import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    private static Map<String, String> rotor1 = new HashMap();
    private static Map<String, String> rotor2 = new HashMap();
    private static Map<String, String> rotor3 = new HashMap();
    private static Map<String, String> decodeRotor1 = new HashMap();
    private static Map<String, String> decodeRotor2 = new HashMap();
    private static Map<String, String> decodeRotor3 = new HashMap();
    private static String[] keys;

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String operation = in.nextLine();
        int N = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }

        keys = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");
        parseRotor(in.nextLine(), 1);
        parseRotor(in.nextLine(), 2);
        parseRotor(in.nextLine(), 3);

        String message = in.nextLine();

        String str = "";
        if (operation.equals("ENCODE")) {
            str = encode(message, N);
        } else {
            str = decode(message, N);
        }

        System.out.println(str);
    }

    public static void parseRotor(String rotor, int index) {
        String[] splitted = rotor.split("");
        for (int i = 0; i < splitted.length; i++) {
            if (index == 1) {
                rotor1.put(keys[i], splitted[i]);
                decodeRotor1.put(splitted[i], keys[i]);
            } else if (index == 2) {
                rotor2.put(keys[i], splitted[i]);
                decodeRotor2.put(splitted[i], keys[i]);
            } else if (index == 3) {
                rotor3.put(keys[i], splitted[i]);
                decodeRotor3.put(splitted[i], keys[i]);
            }
        }
    }

    public static String encode(String word, int N) {
        String[] str = word.split("");
        String res = "";
        int i = 0;
        for (String s : str) {
            String tmp = getLetter(s, N + i++, true);
            tmp = rotor1.get(tmp);
            tmp = rotor2.get(tmp);
            tmp = rotor3.get(tmp);
            res += tmp;
        }
        return res;
    }

    public static String decode(String word, int N) {
        String[] str = word.split("");
        String res = "";
        int i = 0;
        for (String s : str) {
            String tmp = decodeRotor3.get(s);
            tmp = decodeRotor2.get(tmp);
            tmp = decodeRotor1.get(tmp);
            tmp = getLetter(tmp, N + i++, false);
            res += tmp;
        }
        return res;
    }

    public static String getLetter(String letter, int N, boolean encode) {
        int tmp = 0;

        for (int i = 0; i < keys.length; i++) {
            if (keys[i].equals(letter)) {
                tmp = i;
                break;
            }
        }

        if (encode) {
            tmp = tmp + N;
        } else {
            tmp = tmp - N;
        }

        tmp = tmp % 26;
        if (tmp < 0) {
            tmp = 26 + tmp;
        }

        return keys[tmp];
    }


}