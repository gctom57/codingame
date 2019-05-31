import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        in.nextLine();

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < N; i++) {
            builder.append(in.nextLine()).append("\n");
        }

        String expr = "\\((.*?)\\)";
        Pattern p = Pattern.compile(expr, Pattern.DOTALL);
        Matcher m = p.matcher(builder);

        StringBuilder res = new StringBuilder();

        int index = 0;
        while (m.find()) {
            String group = m.group();
            String[] grouped = group.substring(1, group.length() - 1).split("\\|", -1);
            String tmp = grouped[index++ % grouped.length];
            m.appendReplacement(res, tmp);
        }

        m.appendTail(res);
        System.out.println(res);
    }
}