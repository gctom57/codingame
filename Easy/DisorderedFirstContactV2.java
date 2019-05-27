import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.IntStream;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        int absN = Math.abs(N);

        if (in.hasNextLine()) {
            in.nextLine();
        }
        String message = in.nextLine();
        char[] MESSAGE = message.toCharArray();

        List<Integer> mappingList = createMappingList(message);

        while(absN > 0) {
            MESSAGE = N < 0 ? convert(MESSAGE, mappingList::get) : convert(MESSAGE, mappingList::indexOf);
            absN--;
        }

        System.out.println(MESSAGE);
    }

    private static List<Integer> createMappingList(String message) {
        List<Integer> res = new ArrayList<>();

        MappingCheck mpCheck = new MappingCheck();

        IntStream.range(0, message.length()).forEach(i -> {
            if (mpCheck.add) {
                res.add(i);
            } else {
                res.add(mpCheck.index++, i);
            }

            mpCheck.switchSide(i);
        });

        return res;
    }

    private static char[] convert(char[] message, Function<Integer, Integer> mappingFunc) {
        char[] res = new char[message.length];
        IntStream.range(0, message.length).forEach(i -> res[i] = message[mappingFunc.apply(i)]);
        return res;
    }
}

class MappingCheck {
    boolean add = true;
    int nbCharToAdd = 1;
    int index = 0;
    int nbSwitch = 0;

    // welcome to the other side
    void switchSide(int i) {
        if (i == nbSwitch) {
            add = !add;
            nbSwitch += ++nbCharToAdd;
            index = 0;
        }
    }
}