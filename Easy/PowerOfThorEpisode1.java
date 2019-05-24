import java.util.Scanner;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 * ---
 * Hint: You can use the debug stream to print initialTX and initialTY, if Thor seems not follow your orders.
 **/
class Player {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int lightX = in.nextInt(); // the X position of the light of power
        int lightY = in.nextInt(); // the Y position of the light of power
        int initialTX = in.nextInt(); // Thor's starting X position
        int initialTY = in.nextInt(); // Thor's starting Y position

        // game loop
        while (true) {
            String direction = "";

            if (lightY < initialTY) {
                direction += "N";
                initialTY--;
            } else if (lightY > initialTY) {
                direction += "S";
                initialTY++;
            }

            if (lightX < initialTX) {
                direction += "W";
                initialTX--;
            } else if (lightX > initialTX) {
                direction += "E";
                initialTX++;
            }

            System.out.println(direction);
        }
    }
}