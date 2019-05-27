import java.util.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List availableRotations = Arrays.asList("x", "x'", "y", "y'", "z", "z'");
        Map<String, String> rotationsMap = new HashMap<>();
        rotationsMap.put("F", "UDLRFF");
        rotationsMap.put("B", "DURLBB");
        rotationsMap.put("U", "BFUURL");
        rotationsMap.put("D", "FBDDLR");
        rotationsMap.put("L", "LLBFUD");
        rotationsMap.put("R", "RRFBDU");

        List<String> rotations = Arrays.asList(in.nextLine().split(" "));

        Faces f = new Faces(in.nextLine(), in.nextLine());

        rotations.parallelStream().forEach(rot -> {
            int index = availableRotations.indexOf(rot);
            f.s1 = rotationsMap.get(f.s1).substring(index, index + 1);
            f.s2 = rotationsMap.get(f.s2).substring(index, index + 1);
        });

        System.out.println(f.s1);
        System.out.println(f.s2);
    }
}

class Faces {
    String s1;
    String s2;

    public Faces(String s1, String s2) {
        this.s1 = s1;
        this.s2 = s2;
    }
}