import java.util.Scanner;

/**
 * Send your available units to put out those fires! Watch out for water supplies!
 **/
class Player {

    static boolean[][] grid;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int L = in.nextInt(); // Size of forest map
        int water = in.nextInt(); // Total amount of water available

        // game loop
        while (true) {
            int N = in.nextInt(); // Amount of fires
            grid = new boolean[L][L];
            for (int i = 0; i < N; i++) {
                int fireX = in.nextInt(); // X coordinate of fire
                int fireY = in.nextInt(); // Y coordinate of fire
                grid[fireY][fireX] = true;
            }

            Attack[] attack = new Attack[3];
            attack[0] = new Attack(0, 0, 0);
            attack[1] = new Attack(0, 0, 0);
            attack[2] = new Attack(0, 0, 0);

            for (int i = 0 ; i < L; i++) {
                for (int j = 0 ; j < L; j++) {
                    if (i + 2 < L && j + 2 < L) {
                        // check for planes
                        int nbFireIn3x3 = calcFireFrom(i, j, 3);
                        if (nbFireIn3x3 > attack[0].nbFire) {
                            attack[0] = new Attack(nbFireIn3x3, i, j);
                        }
                    }

                    if (i + 1 < L && j + 1 < L) {
                        int nbFireIn2x2 = calcFireFrom(i, j, 2);
                        if (nbFireIn2x2 > attack[1].nbFire) {
                            attack[1] = new Attack(nbFireIn2x2, i, j);
                        }
                    }

                    if (grid[i][j]) {
                        attack[2] = new Attack(1, i, j);
                    }
                }
            }

            if (attack[0].nbFire > 5) {
                System.out.println("C " + attack[0].y + " " + attack[0].x);
            } else if (attack[1].nbFire > 1) {
                System.out.println("H " + attack[1].y + " " + attack[1].x);
            } else {
                System.out.println("J " + attack[2].y + " " + attack[2].x);
            }
        }
    }

    static int calcFireFrom(int i, int j, int nbArea) {
        int nbFire = 0;
        for (int k = 0; k < nbArea; k++) {
            for (int l = 0; l < nbArea; l++) {
                nbFire += grid[i + k][j + l] ? 1 : 0;
            }
        }
        return nbFire;
    }

    static class Attack {
        int nbFire;
        int x;
        int y;

        public Attack(int nbFire, int x, int y) {
            this.nbFire = nbFire;
            this.x = x;
            this.y = y;
        }
    }
}