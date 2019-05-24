import java.util.*;
import java.io.*;
import java.math.*;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String expression = in.next();

        Stack<Character> stack = new Stack<Character>();

        boolean found = true;
        for (Character c : expression.toCharArray()) {
            switch (c) {
                case '{':
                case '(':
                case '[':
                    stack.push(c);
                    break;
                case '}':
                    if (stack.isEmpty() || stack.pop() != '{') {
                        found = false;
                    }
                    break;
                case ')':
                    if (stack.isEmpty() || stack.pop() != '(') {
                        found = false;
                    }
                    break;
                case ']':
                    if (stack.isEmpty() || stack.pop() != '[') {
                        found = false;
                    }
                    break;
            }

            if (!found) {
                break;
            }
        }

        if (found) {
            found = stack.isEmpty();
        }

        System.out.println(found ? "true" : "false");
    }
}