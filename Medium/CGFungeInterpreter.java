import java.util.Scanner;
import java.util.Stack;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    private static final int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }

        String[] lines = new String[N];

        for (int i = 0; i < N; i++) {
            lines[i] = in.nextLine();
        }

        Position p = new Position(0, 0, 0);

        Stack<Integer> stack = new Stack<>();

        char c = lines[p.y].charAt(p.x);
        boolean charValue = false;

        while (c != 'E') {
            if (charValue && c != '"') {
                stack.push((int) c);
            } else if (c != ' ') {
                switch (c) {
                    case '>':
                        p.index = 0;
                        break;
                    case '<':
                        p.index = 2;
                        break;
                    case '^':
                        p.index = 3;
                        break;
                    case 'v':
                        p.index = 1;
                        break;
                    case 'S':
                        move(p, 1);
                        break;
                    case 'P':
                        stack.pop();
                        break;
                    case 'X':
                        int a = stack.pop();
                        int b = stack.pop();
                        stack.push(a);
                        stack.push(b);
                        break;
                    case 'D':
                        stack.push(stack.peek());
                        break;
                    case '_':
                        int e = stack.pop();
                        if (e == 0) {
                            p.index = 0;
                        } else {
                            p.index = 2;
                        }
                        break;
                    case '|':
                        int f = stack.pop();
                        if (f == 0) {
                            p.index = 1;
                        } else {
                            p.index = 3;
                        }
                        break;
                    case 'I':
                        System.out.print(stack.pop());
                        break;
                    case 'C':
                        System.out.print(Character.toChars(stack.pop()));
                        break;
                    case '+':
                        stack.push(stack.pop() + stack.pop());
                        break;
                    case '-':
                        int d = stack.pop();
                        stack.push(stack.pop() - d);
                        break;
                    case '*':
                        stack.push(stack.pop() * stack.pop());
                        break;
                    case '"':
                        charValue = !charValue;
                        break;
                    default:
                        stack.push(c - '0');
                        break;
                }
            }

            move(p, 1);
            c = lines[p.y].charAt(p.x);
        }
    }

    private static void move(Position p, int i) {
        int[] d = directions[p.index];
        p.x += d[1] * i;
        p.y += d[0] * i;
    }
}

class Position {
    int x;
    int y;
    int index;

    public Position(int x, int y, int index) {
        this.x = x;
        this.y = y;
        this.index = index;
    }
}