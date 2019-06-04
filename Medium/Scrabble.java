import java.util.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Map<Character, Integer> charMap = new HashMap<>() {
            {
                put('a', 1);
                put('b', 3);
                put('c', 3);
                put('d', 2);
                put('e', 1);
                put('f', 4);
                put('g', 2);
                put('h', 4);
                put('i', 1);
                put('j', 8);
                put('k', 5);
                put('l', 1);
                put('m', 3);
                put('n', 1);
                put('o', 1);
                put('p', 3);
                put('q', 10);
                put('r', 1);
                put('s', 1);
                put('t', 1);
                put('u', 1);
                put('v', 4);
                put('w', 4);
                put('x', 8);
                put('y', 4);
                put('z', 10);
            }
        };


        int N = in.nextInt();
        in.nextLine();

        List<String> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(in.nextLine());
        }

        String letters = in.nextLine();
        removeIncorrectWord(list, letters);

        String word = null;
        int max = 0;
        for (String line : list) {
            char[] cs = line.toCharArray();
            int tmp = 0;
            for (char c : cs) {
                tmp += charMap.get(c);
            }
            if (tmp > max) {
                word = line;
                max = tmp;
            }
        }

        System.out.println(word == null ? "invalid word" : word);
    }

    private static void removeIncorrectWord(List<String> list, String letters) {
        Iterator<String> iter = list.iterator();
        while (iter.hasNext()) {
            String tmp = letters;

            boolean remove = false;
            for (char c : iter.next().toCharArray()) {
                if (tmp.indexOf(c) >= 0) {
                    tmp = tmp.replaceFirst(Character.toString(c), "");
                } else {
                    remove = true;
                }
            }

            if (remove) {
                iter.remove();
            }
        }
    }
}