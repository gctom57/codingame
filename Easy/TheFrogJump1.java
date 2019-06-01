import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int f = in.nextInt();
        List<Double> jumps = new ArrayList<>(f);
        for (int i = 0; i < f; i++) {
            jumps.add(in.nextDouble());
        }

        jumps.sort(Collections.reverseOrder());

        int initialX = in.nextInt();
        int initialY = in.nextInt();
        int mass = in.nextInt();
        int alpha = in.nextInt();
        float speed = in.nextFloat();
        float gravityA = in.nextFloat();
        float gravityB = in.nextFloat();

        double speedX = Math.cos(Math.toRadians(alpha)) * speed;
        double speedY = Math.sin(Math.toRadians(alpha)) * speed;

        double delta = speedY * speedY - 4 * (gravityB * 0.5d) * initialY;
        double time = (-1d * speedY - Math.sqrt(delta)) / (2d * gravityB * 0.5);

        double res = (gravityA * 0.5 * time * time) + (speedX * time) + initialX;
        BigDecimal bd = new BigDecimal(res);
        res = bd.setScale(2, RoundingMode.HALF_UP).doubleValue();

        int index = f+1;
        for (int i = 0; i < jumps.size() ;i++) {
            if (jumps.get(i).compareTo(res) <= 0) {
                index = i + 1;
                break;
            }
        }

        System.out.println(index);
    }
}