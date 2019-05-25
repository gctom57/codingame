import java.util.EnumSet;
import java.util.Scanner;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            String A = in.next();
            int xA = in.nextInt();
            int yA = in.nextInt();
            String B = in.next();
            int xB = in.nextInt();
            int yB = in.nextInt();
            String C = in.next();
            int xC = in.nextInt();
            int yC = in.nextInt();
            String D = in.next();
            int xD = in.nextInt();
            int yD = in.nextInt();

            double abY = Math.abs(yB - yA);
            double abX = Math.abs(xB - xA);
            double bcY = Math.abs(yC - yB);
            double bcX = Math.abs(xC - xB);
            double cdY = Math.abs(yD - yC);
            double cdX = Math.abs(xD - xC);
            double daY = Math.abs(yA - yD);
            double daX = Math.abs(xA - xD);

            EnumSet<Flag> flags = EnumSet.noneOf(Flag.class);

            if (abY / abX == cdY / cdX && bcY / bcX == daY / daX) {
                flags.add(Flag.PARALLELOGRAM);
            }
            if (Math.hypot(abY, abX) == Math.hypot(cdY, cdX)
                    && Math.hypot(abY, abX) == Math.hypot(bcY, bcX)) {
                flags.add(Flag.RHOMBUS);
            }
            if (Math.toDegrees(Math.atan2(yD - yA, xD - xA) - Math.atan2(yB - yA, xB - xA)) % 90 == 0
                    && Math.toDegrees(Math.atan2(yB - yC, xB - xC) - Math.atan2(yD - yC, xD - xC)) % 90 == 0) {
                flags.add(Flag.RECTANGLE);
            }

            displayFlag(A+B+C+D, flags);
        }
    }

    private static void displayFlag(String value, EnumSet<Flag> enums) {
        String res;
        if (enums.contains(Flag.RECTANGLE) && enums.contains(Flag.RHOMBUS)) {
            res = "square";
        } else if (enums.contains(Flag.RECTANGLE)) {
            res = "rectangle";
        } else if (enums.contains(Flag.RHOMBUS)) {
            res = "rhombus";
        } else if (enums.contains(Flag.PARALLELOGRAM)) {
            res = "parallelogram";
        } else {
            res = "quadrilateral";

        }
        System.out.println(value + " is a " + res + ".");
    }

    public enum Flag {
        PARALLELOGRAM, RHOMBUS, RECTANGLE
    }
}

