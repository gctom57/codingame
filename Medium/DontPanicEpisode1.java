import java.util.Scanner;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Player {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int nbFloors = in.nextInt(); // number of floors
        int width = in.nextInt(); // width of the area
        int nbRounds = in.nextInt(); // maximum number of rounds
        int exitFloor = in.nextInt(); // floor on which the exit is found
        int exitPos = in.nextInt(); // position of the exit on its floor
        int nbTotalClones = in.nextInt(); // number of generated clones
        int nbAdditionalElevators = in.nextInt(); // ignore (always zero)
        int nbElevators = in.nextInt(); // number of elevators
        int[] floors = new int[nbElevators+1];
        floors[exitFloor] = exitPos;
        for (int i = 0; i < nbElevators; i++) {
            floors[in.nextInt()] = in.nextInt();
        }

        // game loop
        while (true) {
            int floor = in.nextInt(); // floor of the leading clone
            int pos = in.nextInt(); // position of the leading clone on its floor
            int dir = in.next().compareTo("NONE"); // direction of the leading clone: LEFT or RIGHT

            boolean block = (floor >= 0) && (dir < 1 ? pos < floors[floor] : dir > 1 && pos > floors[floor]);

            System.out.println(block  ? "BLOCK" : "WAIT");
        }
    }
}