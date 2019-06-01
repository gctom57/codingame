import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String intext = in.nextLine();
        intext = intext.toLowerCase();
        intext = intext.replaceAll("(\\s+)?([.,;]+)(\\s)?", "$2");
        intext = intext.replaceAll("([.,;])+", "$1 ");
        intext = intext.replaceAll("(\\s)*", "$1");
        intext = intext.trim();

        Matcher m = Pattern.compile("(^|(?<=(\\.\\s)))(\\w)").matcher(intext);
        StringBuffer sb = new StringBuffer();
        while (m.find()) {
            m.appendReplacement(sb, m.group(3).toUpperCase());
        }
        intext = m.appendTail(sb).toString();
        System.out.println(intext);
    }
}