import java.util.*;
import java.util.stream.Collectors;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Map<String, Integer> register = new HashMap<>();
        register.put("a", in.nextInt());
        register.put("b", in.nextInt());
        register.put("c", in.nextInt());
        register.put("d", in.nextInt());

        int n = in.nextInt();
        in.nextLine();

        List<String[]> instructions = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            instructions.add(in.nextLine().split(" "));
        }

        for (int i = 0; i < instructions.size(); i++) {
            String[] s = instructions.get(i);

            int i2 = (register.containsKey(s[2]) ? register.get(s[2]) : Integer.parseInt(s[2]));
            int i3 = s.length == 4 ? (register.containsKey(s[3]) ? register.get(s[3]) : Integer.parseInt(s[3])) : 0;

            switch (s[0]) {
                case "MOV":
                    register.put(s[1], i2);
                    break;
                case "ADD":
                    register.put(s[1], i2 + i3);
                    break;
                case "SUB":
                    register.put(s[1], i2 - i3);
                    break;
                case "JNE":
                    if (i2 != i3) {
                        i = Integer.parseInt(s[1]) - 1;
                    }
                    break;
            }
        }

        System.out.println(register.values().stream().map(i -> Integer.toString(i)).collect(Collectors.joining(" ")));
    }
}