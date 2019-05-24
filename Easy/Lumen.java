import java.util.Scanner;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int L = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }

        boolean[][] lighted = new boolean[N][N];

        int nbDarkSpot = N * N;

        // lines
        for (int i = 0; i < N; i++) {
            String[] line = in.nextLine().split(" ");

            int nbLights = 0;
            // rows
            for (int j = 0; j < N; j++) {
                if (line[j].equals("C")) {
                    for (int k = Math.max(0, i - L + 1); k < Math.min(N, i + L); k++) {
                        for (int l = Math.max(0, j - L + 1); l < Math.min(N, j + L); l++) {
                            if (!lighted[k][l]) {
                                lighted[k][l] = true;
                                nbLights++;
                            }
                        }
                    }
                }
            }

            nbDarkSpot -= nbLights;
        }

        System.out.println(nbDarkSpot);
    }
}