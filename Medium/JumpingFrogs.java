import java.util.Scanner;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        Frog[] frogs = new Frog[3];

        for (int i = 0; i < 3; i++) {
            frogs[i] = new Frog(in.nextInt(), in.nextInt(), in.nextInt());
        }

        if (canMeet(frogs[0], frogs[1]) && canMeet(frogs[1], frogs[2]) && canMeet(frogs[0], frogs[2])) {
            System.out.println("Possible");
        } else {
            System.out.println("Impossible");
        }
    }

    static boolean canMeet(Frog f1, Frog f2) {
        int pgcd = pgcd(f1.k, f2.k);
        return Math.abs(f1.x - f2.x) % pgcd == 0 && Math.abs(f1.y - f2.y) % pgcd == 0;
    }

    static int pgcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (a!=b) {
            if (a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }
        return a ;
    }
}

class Frog {
    int x;
    int y;
    int k;

    public Frog(int x, int y, int k) {
        this.x = x;
        this.y = y;
        this.k = k;
    }
}