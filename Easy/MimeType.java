import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(); // Number of elements which make up the association table.
        int Q = in.nextInt(); // Number Q of file names to be analyzed.

        Map<String, String> mimeMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            mimeMap.put(in.next().toUpperCase(), in.next());
            in.nextLine();
        }

        for (int i = 0; i < Q; i++) {
            String FNAME = in.nextLine().toUpperCase(); // One file name per line.

            String extension = "";
            int index = FNAME.lastIndexOf('.');
            if (index >= 0) {
                extension = FNAME.substring(index+1);
            }

            System.out.println(mimeMap.getOrDefault(extension, "UNKNOWN"));

        }
    }
}