import java.util.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    static List<Driver> drivers;
    static int[] bends;
    static double g = 9.81;
    static double angle = 60d;


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int v = in.nextInt();

        drivers = new ArrayList<>(n);
        bends = new int[v];

        for (int i = 0; i < n; i++) {
            drivers.add(new Driver((char)('a' + i), in.nextInt()));
        }

        for (int i = 0; i < v; i++) {
            bends[i] = in.nextInt();
        }

        drivers.sort(Comparator.comparingInt(Driver::getSpeed).reversed());

        int max = calcOptimalSpeed();
        List<Driver> res = calcResult();

        System.out.println(max);
        System.out.println("y");
        res.forEach(d -> System.out.println(d.c));
    }

    static List<Driver> calcResult() {
        List<Driver> result = new ArrayList<>();
        for (int i : bends) {

            int countFall = 0;

            Iterator<Driver> iter = drivers.iterator();
            while (iter.hasNext()) {
                Driver d = iter.next();

                if (Math.toDegrees(Math.atan(d.getSpeed() * d.getSpeed() / (i * g))) > angle) {
                    result.add(countFall++, d);
                    iter.remove();
                }
            }
        }

        result.addAll(0, drivers);
        return result;
    }

    static int calcOptimalSpeed() {
        int min = Integer.MAX_VALUE;
        for (int i : bends) {
            min = Math.min(min, (int)(Math.sqrt(Math.tan(Math.toRadians(angle)) * i * g)));
        }
        return min;
    }
}

class Driver {
    char c;
    int speed;

    public Driver(char c, int speed) {
        this.c = c;
        this.speed = speed;
    }

    int getSpeed() {
        return speed;
    }
}