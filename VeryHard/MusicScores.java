import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    static int width;
    static int height;

    static boolean[][] grid;

    static int firstBX = Integer.MAX_VALUE;
    static int firstBY;
    static int lastBY;
    static int nbBlackPixelOnFirstLine;

    static int lineHeight;
    static int noteHeight;

    static int minY;
    static int maxY;

    static int notesCounter = 6;

    static Note[] notes = new Note[12];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        width = in.nextInt();
        height = in.nextInt();

        grid = new boolean[height][width];

        int currentY = 0;
        int currentX = 0;
        while (in.hasNext()) {
            String str = in.next();
            int nbPixels = in.nextInt();

            if (str.equals("W")) {
                currentY += (currentX + nbPixels) / width;
                currentX = (currentX + nbPixels) % width;
            } else {
                if (currentX < firstBX) {
                    firstBX = currentX;
                    firstBY = currentY;
                    nbBlackPixelOnFirstLine = 0;
                }
                if (currentX == firstBX) {
                    nbBlackPixelOnFirstLine++;
                    lastBY = currentY;
                }

                // black pixel don't go all the way to the width
                for (int j = 0; j < nbPixels; j++) {
                    grid[currentY][++currentX] = true;
                }
            }
        }

        lineHeight = nbBlackPixelOnFirstLine / 5;
        noteHeight = (lastBY + 1 - firstBY - nbBlackPixelOnFirstLine) / 4;
        minY = firstBY - noteHeight;
        maxY = lastBY + noteHeight;

        // Quick fix for now
        int delta = 0;
        if (lineHeight == 1) {
            delta = 1;
            notesCounter = 4;
        }

        int full = noteHeight + lineHeight;
        int half = full / 2;

        notes[0] = new Note('G', minY, minY + noteHeight);
        notes[1] = new Note('F', minY + half, minY + half + noteHeight + delta);
        notes[2] = new Note('E', minY + full, minY + full + noteHeight - 1 + delta);
        notes[3] = new Note('D', minY + half + full, minY + half + full + noteHeight + delta);
        notes[4] = new Note('C', minY + 2 * full, minY + 2 * full + noteHeight - 1 + delta);
        notes[5] = new Note('B', minY + half + 2 * full, minY + half + 2 * full + noteHeight + delta);
        notes[6] = new Note('A', minY + 3 * full, minY + 3 * full + noteHeight - 1 + delta);
        notes[7] = new Note('G', minY + half + 3 * full, minY + half + 3 * full + noteHeight + delta);
        notes[8] = new Note('F', minY + 4 * full, minY + 4 * full + noteHeight - 1 + delta);
        notes[9] = new Note('E', minY + half + 4 * full, minY + half + 4 * full + noteHeight + delta);
        notes[10] = new Note('D', minY + 5 * full, minY + 5 * full + noteHeight - 1 + delta);
        notes[11] = new Note('C', minY + half + 5 * full, minY + half + 5 * full + noteHeight + delta);

        System.out.println(String.join(" ", findNote()));
    }

    private static List<String> findNote() {
        List<String> res = new ArrayList<>();

        int[] counter = new int[12];

        for (int i = firstBX; i < width - firstBX; i++) {
            for (int j = 0; j < 12; j++) {
                if (grid[notes[j].startY][i] && grid[notes[j].endY][i]) {
                    counter[j]++;

                    // counter to map the outline of the notes
                    if (counter[j] == notesCounter) {
                        res.add(notes[j].c + "" + (grid[notes[j].getMiddle()][i] ? "Q" : "H"));
                        i += noteHeight - notesCounter;
                        counter[j] = 0;
                    } else {
                        break;
                    }
                } else {
                    counter[j] = 0;
                }
            }
        }

        return res;
    }

    private static class Note {
        char c;
        int startY;
        int endY;

        Note(char c, int startY, int endY) {
            this.c = c;
            this.startY = startY;
            this.endY = endY;
        }

        int getMiddle() {
            return (endY + startY) / 2;
        }
    }
}