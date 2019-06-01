import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Scanner;
import java.time.temporal.ChronoUnit;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    static SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);
            LocalDate d1 = sdf.parse(in.next()).toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate();
            LocalDate d2 = sdf.parse(in.next()).toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate();

            Period time = Period.between(d1, d2);
            long days = ChronoUnit.DAYS.between(d1, d2);

            StringBuilder build = new StringBuilder();
            if (time.getYears() > 0) {
                build.append(time.getYears()).append(" year").append(time.getYears() > 1 ? "s" : "").append(", ");
            }
            if (time.getMonths() > 0) {
                build.append(time.getMonths()).append(" month").append(time.getMonths() > 1 ? "s" : "").append(", ");
            }
            build.append("total ").append(days).append(" days");

            System.out.println(build.toString());
        } catch (ParseException ignored) {

        }
    }
}