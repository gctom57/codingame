import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String N = in.nextLine();

        BigInteger n = new BigInteger(N);

        StringBuilder sb = new StringBuilder();

        List<BigInteger> fibs = fibNumbers(n);

        for (int i = fibs.size() - 1; i >= 0; i--) {
            BigInteger fib = fibs.get(i);
            sb.append(fib.compareTo(n) <= 0 ? "1" : "0");
            if (fib.compareTo(n) <= 0) {
                n = n.subtract(fib);
            }
        }

        System.out.println(new BigInteger(sb.toString(), 2).toString(8));
    }

    private static List<BigInteger> fibNumbers(BigInteger n) {
        List<BigInteger> fibs = new ArrayList<>();
        fibs.add(BigInteger.ONE);
        BigInteger nextFib = BigInteger.TWO;
        while (n.compareTo(nextFib) >= 0) {
            fibs.add(nextFib);
            nextFib = nextFib.add(fibs.get(fibs.size() - 2));
        }
        return fibs;
    }
}