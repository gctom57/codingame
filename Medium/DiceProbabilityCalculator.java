import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.text.DecimalFormat;
import java.math.RoundingMode;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    static Map<Integer, Integer> total = new HashMap<>();
    static Map<Integer, Integer> dices = new HashMap<>();

    static List<String> exprList = new ArrayList<>();

    static ScriptEngineManager mgr = new ScriptEngineManager();
    static ScriptEngine engine = mgr.getEngineByName("JavaScript");

    static final String DICE = "DICE";

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String expr = in.nextLine();

        Matcher m = Pattern.compile("d[0-9]").matcher(expr);

        int lastIndex = 0;
        while (m.find()) {
            String str = expr.substring(lastIndex, m.start());
            exprList.add(str);
            exprList.add(DICE);
            dices.put(exprList.size() - 1, Integer.parseInt(m.group().substring(1, 2)));
            lastIndex += str.length() + 2;
        }

        if (lastIndex != expr.length()) {
            exprList.add(expr.substring(lastIndex));
        }

        try {
            evaluate("", exprList, 0);
        } catch (ScriptException e) {
            e.printStackTrace();
        }

        int nbCombination = total.values().stream().mapToInt(i -> i).sum();

        DecimalFormat format = new DecimalFormat("##.00");
        format.setRoundingMode(RoundingMode.HALF_UP);

        total.entrySet().stream().sorted(Map.Entry.comparingByKey())
                .forEach(e -> System.out.println(e.getKey() + " " + format.format(e.getValue() * 100d / nbCombination)));
    }

    private static void evaluate(String eval, List<String> exprList, int arrayIndex) throws ScriptException {
        if (exprList.size() <= arrayIndex) {
            Object value = engine.eval(eval);
            int val = value instanceof Boolean ? ((boolean)value ? 1 : 0) : (int)value;

            total.putIfAbsent(val, 0);
            total.computeIfPresent(val, (k, v) -> v+1);

            return;
        }

        if (exprList.get(arrayIndex).equals(DICE)) {
            for (int diceValue = 1; diceValue <= dices.get(arrayIndex); diceValue++) {
                evaluate(eval + diceValue, exprList, arrayIndex + 1);
            }
        } else {
            evaluate(eval + exprList.get(arrayIndex), exprList, arrayIndex + 1);
        }
    }
}