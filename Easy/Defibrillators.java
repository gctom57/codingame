import java.util.Scanner;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Double longitude = Double.parseDouble(in.next().replaceAll(",", "."));
        Double latitude = Double.parseDouble(in.next().replaceAll(",", "."));

        int N = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }

        Double min = Double.MAX_VALUE;
        String res = "";

        for (int i = 0; i < N; i++) {
            String DEFIB = in.nextLine();
            String[] str = DEFIB.split(";");
            Double defibLon = Double.parseDouble(str[4].replaceAll(",", "."));
            Double defibLat = Double.parseDouble(str[5].replaceAll(",", "."));

            Double x = (defibLon - longitude) * Math.cos((latitude + defibLat) / 2);
            Double y = defibLat - latitude;
            Double d = Math.sqrt(x * x + y * y) * 6371;

            if (d <= min) {
                res = str[1];
                min = d;
            }
        }

        System.out.println(res);
    }
}