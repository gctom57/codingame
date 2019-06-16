import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int H = in.nextInt();
        in.nextInt();

        String[] box = new String[H];
        int holes = 0;
        for (int i = 0; i < H; i++) {
            box[i] = in.next();
            holes += box[i].length() - box[i].replace(".", "").length();
        }
        int H2 = in.nextInt();

        in.nextInt();
        String[] piece = new String[H2];
        int block = 0;
        for (int i = 0; i < H2; i++) {
            piece[i] = in.next();
            block += piece[i].length() - piece[i].replace("#", "").length();
        }

        if (block != holes) {
            System.out.println("HOLE");
            return;
        }

        piece = updatePiece(piece); // remove all the '.' that serves no purpose

        System.out.println(solveForEachRotation(box, piece) ? "FULL" : "HOLE");
    }

    private static String[] updatePiece(String[] piece) {
        String[] tmp = piece;
        for (int i = 0; i < 8; i++) {
            List<String> tmpList = new ArrayList<>(Arrays.asList(tmp));
            if (!tmpList.get(0).contains("#")) {
                tmpList.remove(0);
                tmp = tmpList.toArray(new String[0]);
            }
            tmp = rotateClockWise(tmp);
        }
        return tmp;
    }

    private static boolean solveForEachRotation(String[] boxes, String[] piece) {
        String[] p = piece;
        for (int turn = 0; turn < 4; turn++) {
            if (solve(boxes, p)) {
                return true;
            }

            p = rotateClockWise(p);
        }

        return false;
    }

    private static boolean solve(String[] boxes, String[] p) {
        for (int i = 0; i <= boxes.length - p.length; i++) {
            for (int j = 0; j <= boxes[0].length() - p[0].length(); j++) {

                String[] tmpBox = new String[boxes.length];
                System.arraycopy(boxes, 0, tmpBox, 0, boxes.length);

                fill(tmpBox, p, i, j);

                if (check(tmpBox)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static void fill(String[] boxes, String[] pieces, int a, int b) {
        for (int i = 0; i < pieces.length; i++) {
            StringBuilder line = new StringBuilder(boxes[i + a]);
            String piece = pieces[i];
            for (int j = 0; j < pieces[0].length(); j++) {
                if (piece.charAt(j) == '#') {
                    if (line.charAt(j + b) == '#') {
                        line.setCharAt(j + b, '.');
                    } else {
                        line.setCharAt(j + b, piece.charAt(j));
                    }
                }
            }
            boxes[i + a] = line.toString();
        }
    }

    private static boolean check(String[] boxes) {
        for (String box : boxes) {
            if (box.contains(".")) {
                return false;
            }
        }
        return true;
    }

    private static String[] rotateClockWise(String[] array) {
        int sizeW = array.length;
        int sizeH = array[0].length();
        String[] ret = new String[sizeH];

        for (int i = 0; i < sizeH; ++i) {
            StringBuilder build = new StringBuilder();
            for (int j = 0; j < sizeW; ++j) {
                build.append(array[sizeW - j - 1].charAt(i));
            }
            ret[i] = build.toString();
        }

        return ret;
    }
}