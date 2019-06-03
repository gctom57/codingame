import java.util.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int xA = in.nextInt();
        int yA = in.nextInt();
        int xB = in.nextInt();
        int yB = in.nextInt();
        int n = in.nextInt();

        Set<Coefficient> coefs = new HashSet<>();

        for (int i = 0; i < n; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();

            if (a < 0) {
                a = -1 * a;
                b = -1 * b;
                c = -1 * c;
            }

            addCoefficients(coefs, a, b, c);
        }

        int countA = 0;
        int countB = 0;

        for(Coefficient coef : coefs) {
            int valA = (coef.a * xA) + (coef.b * yA) + coef.c;
            int valB = (coef.a * xB) + (coef.b * yB) + coef.c;

            if (valA == 0 || valB == 0) {
                System.out.println("ON A LINE");
                return;
            }

            if (valA < 0) {
                countA++;
            }
            if (valB < 0) {
                countB++;
            }
        }

        if (countA % 2 == countB % 2) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    private static void addCoefficients(Set<Coefficient> coefficients, int a, int b, int c) {
        List<Integer> list = new ArrayList<>();
        if (a != 0) {
            list.add(Math.abs(a));
        }
        if (b != 0) {
            list.add(Math.abs(b));
        }
        if (c != 0) {
            list.add(Math.abs(c));
        }

        int val = Collections.min(list);

        Coefficient coef;
        if (a % val == 0 && b % val == 0 && c % val == 0) {
            coef = new Coefficient(a / val, b / val, c / val);
        } else {
            coef = new Coefficient(a, b, c);
        }

        coefficients.add(coef);
    }
}

class Coefficient{
    int a;
    int b;
    int c;

    public Coefficient(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coefficient coef = (Coefficient) o;
        return a == coef.a &&
                b == coef.b &&
                c == coef.c;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b, c);
    }
}