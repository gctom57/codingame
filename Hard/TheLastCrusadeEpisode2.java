import java.util.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Player {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Game g = new Game(in);

        // game loop
        while (true) {
            g.playOneTurn(in);
        }
    }
}

class Game {

    private int width;
    private int height;
    private int exitIndex;

    private List<Integer> clockWiseIndex;

    private int[][] maze;
    private boolean[][][] visited;

    private List<String> directions;
    private List<Rock> rocks;

    private String[][] pieces = { // Down : 'D', Left : 'L', Right : 'R'
            // Top, Left, Right
            {"X", "X", "X"}, //0
            {"D", "D", "D"}, //1
            {"X", "R", "L"}, //2
            {"D", "X", "X"}, //3
            {"L", "X", "D"}, //4
            {"R", "D", "X"}, //5
            {"X", "R", "L"}, //6
            {"D", "X", "D"}, //7
            {"X", "D", "D"}, //8
            {"D", "D", "X"}, //9
            {"L", "X", "X"}, //10
            {"R", "X", "X"}, //11
            {"X", "X", "D"}, //12
            {"X", "D", "X"}, //13
    };

    public Game(Scanner in) {
        clockWiseIndex = Arrays.asList(0, 1, 3, 2, 5, 4, 7, 8, 9, 6, 11, 12, 13, 10);
        directions = Arrays.asList("TOP", "LEFT", "RIGHT");

        width = in.nextInt(); // number of columns.
        height = in.nextInt(); // number of rows.
        in.nextLine();

        maze = new int[height][width];
        for (int i = 0; i < height; i++) {
            String[] LINE = in.nextLine().split(" "); // represents a line in the grid and contains W integers. Each integer represents one room of a given type.
            for (int j = 0; j < LINE.length; j++) {
                maze[i][j] = Integer.parseInt(LINE[j]);
            }
        }

        exitIndex = in.nextInt();
    }

    void playOneTurn(Scanner in) {
        int XI = in.nextInt();
        int YI = in.nextInt();
        int POS = directions.indexOf(in.next());
        int R = in.nextInt(); // the number of rocks currently in the grid.
        rocks = new ArrayList<>();
        for (int i = 0; i < R; i++) {
            rocks.add(new Rock(in.nextInt(), in.nextInt(), directions.indexOf(in.next())));
        }

        State s = getImmediateState(XI, YI, POS);
        if (s.order.equals("RIGHT")) {
            maze[s.y][s.x] = clockWiseIndex(maze[s.y][s.x]);
        } else if (s.order.equals("LEFT")) {
            maze[s.y][s.x] = counterClockWiseIndex(maze[s.y][s.x]);
        }

        if (s.order.equals("WAIT")) {
            System.out.println(s.order);
        } else {
            System.out.println(s.x + " " + s.y + " " + s.order);
        }
    }

    State getImmediateState(int x, int y, int pos) {
        List<State> states = getAllStates(x, y, pos);
        if (states.size() <= 1) {
            return new State(x, y, "WAIT");
        } else if (!states.get(1).order.equals("WAIT")) {
            return states.get(1);
        }

        State rockState = removeRocks(x, y, states);
        if (rockState != null) {
            return rockState;
        }

        return states.get(1);
    }

    State removeRocks(int x, int y, List<State> states) {
        for (int i = 0; i < states.size() - 1; i++) {
            if (!states.get(i).order.equals("WAIT")) {
                List<Rock> newRocks = new ArrayList<>();
                Iterator<Rock> it = rocks.iterator();
                while (it.hasNext()) {
                    Rock rock = it.next();
                    Room r = new Room(rock.x, rock.y, rock.direction, maze[rock.y][rock.x]);
                    Room nextRoom = getNextRoom(r, r.type);
                    if (nextRoom.isValid) {
                        // Add next rock position for next iteration on states
                        newRocks.add(new Rock(nextRoom.x, nextRoom.y, nextRoom.direction));
                    }

                    it.remove();
                }

                // Add all new rock position
                rocks.addAll(newRocks);
            } else {
                // try to remove rocks
                for (Rock rock : rocks) {
                    if (rock.x == x && rock.y == y) continue; //prevent rotation of cell occupied by indy

                    Room r = new Room(rock.x, rock.y, rock.direction, maze[rock.y][rock.x]);
                    if (r.canClockWise()) {
                        Room nextRoom = getNextRoom(r, clockWiseIndex(r.type));
                        if (nextRoom.x == states.get(1).x && nextRoom.y == states.get(1).y) continue;
                        if (!nextRoom.isValid) {
                            return new State(nextRoom.x, nextRoom.y, "RIGHT");
                        }
                    }
                }
            }
        }

        return null;
    }

    List<State> getAllStates(int x, int y, int pos) {
        System.err.println("Current room: (" + x + ", " + y + ") entering by " + directions.get(pos));
        Room currentRoom = new Room(x, y, pos, maze[y][x]);

        visited = new boolean[width][height][3];
        visited[x][y][pos] = true;

        Queue<Room> queue = new ArrayDeque<>();
        Room r = getNextRoom(currentRoom, currentRoom.type);
        r.states.add(new State(x, y, "NONE"));
        queue.add(r);

        visited[r.x][r.y][r.direction] = true;

        while (queue.size() > 0) {
            Room room = queue.poll();
            if (room.x == exitIndex && room.y == height - 1) {
                return room.states;
            }
            queue.addAll(getNextRooms(room));
        }

        return new ArrayList<>();
    }

    List<Room> getNextRooms(Room room) {
        ArrayList<Room> res = new ArrayList<>();

        // No rotation, we'll use this 'state' to replace it if needed
        Room nextRoom = getNextRoom(room, room.type);
        checkAndAddIfAbsent(room, nextRoom, res, "WAIT");

        if (room.canClockWise()) {
            // rotate clockwise
            nextRoom = getNextRoom(room, clockWiseIndex(room.type));
            checkAndAddIfAbsent(room, nextRoom, res, "RIGHT");
        }
        // skip room type 2 3 4 5 for counterclockwise rotation since they are the same
        if (room.canCounterClockWise()) {
            // rotate counterclockwise
            nextRoom = getNextRoom(room, counterClockWiseIndex(room.type));
            checkAndAddIfAbsent(room, nextRoom, res, "LEFT");

            // Special case of double rotate
            nextRoom = getNextRoom(room, counterClockWiseIndex(counterClockWiseIndex(room.type)));
            checkAndAddDoubleIfAbsent(room, nextRoom, res);
        }

        return res;
    }

    private void checkAndAddIfAbsent(Room room, Room nextRoom, ArrayList<Room> res, String order) {
        if (nextRoom.isValid && !visited[nextRoom.x][nextRoom.y][nextRoom.direction]) {
            nextRoom.states.addAll(room.states);
            nextRoom.states.add(new State(room.x, room.y, order));

            visited[nextRoom.x][nextRoom.y][nextRoom.direction] = true;

            System.err.println("Adding room: (" + room.x + ", " + room.y + ")[" + room.type + "][" + directions.get(room.direction) + "] -> " + order);

            res.add(nextRoom);
        }
    }

    // Special case
    private void checkAndAddDoubleIfAbsent(Room room, Room nextRoom, ArrayList<Room> res) {
        if (nextRoom.isValid && !visited[nextRoom.x][nextRoom.y][nextRoom.direction]) {
            nextRoom.states.addAll(room.states);
            visited[nextRoom.x][nextRoom.y][nextRoom.direction] = true;

            // Find the first WAIT state to replace it
            int i;
            for (i = room.states.size() - 1; i >= 0; i--) {
                if (room.states.get(i).order.equals("WAIT")) {
                    break;
                }
            }
            if (i >= 0) {
                nextRoom.states.set(i, new State(room.x, room.y, "RIGHT"));
            }
            nextRoom.states.add(new State(room.x, room.y, "RIGHT"));

            System.err.println("Adding room: (" + room.x + ", " + room.y + ")[" + room.type + "][" + directions.get(room.direction) + "] -> " + "RIGHT");

            res.add(nextRoom);
        }
    }

    Room getNextRoom(Room r, int roomType) {
        String exit = pieces[Math.abs(roomType)][r.direction];

        // Check if current rotation (or lack of) produce a correct exit from the current direction
        boolean isValid = !exit.equals("X");

        // Build the next Room object
        int newX = r.x + (exit.equals("L") ? -1 : (exit.equals("R") ? 1 : 0));
        int newY = r.y + (exit.equals("D") ? 1 : 0);

        if (newX >= width || newX < 0) {
            isValid = false;
            newX = r.x;
        }
        if (newY >= height) {
            isValid = false;
            newY = r.y;
        }

        if (r.x == newX && r.y == newY) {
            isValid = false;
        }

        String res;
        switch (exit) {
            case "L":
                res = "RIGHT";
                break;
            case "R":
                res = "LEFT";
                break;
            default:
                res = "TOP";
                break;
        }

        return new Room(newX, newY, directions.indexOf(res), maze[newY][newX], isValid);
    }

    int clockWiseIndex(int index) {
        return clockWiseIndex.get(index);
    }

    int counterClockWiseIndex(int index) {
        return clockWiseIndex.indexOf(index);
    }
}

abstract class Coordinate {
    int x;
    int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Rock extends Coordinate {
    int direction;

    public Rock(int x, int y, int direction) {
        super(x, y);
        this.direction = direction;
    }
}

class State extends Coordinate {
    String order;

    public State(int x, int y, String order) {
        super(x, y);
        this.order = order;
    }
}

class Room extends Coordinate {
    int direction;
    int type;
    boolean isValid; // Can we access this room ?
    List<State> states;

    public Room(int x, int y, int direction, int type) {
        super(x, y);
        this.direction = direction;
        this.type = type;
        this.states = new ArrayList<>();
    }

    public Room(int x, int y, int direction, int type, boolean isValid) {
        super(x, y);
        this.direction = direction;
        this.type = type;
        this.isValid = isValid;
        this.states = new ArrayList<>();
    }

    boolean canClockWise() {
        return type >= 2;
    }

    boolean canCounterClockWise() {
        return type >= 6;
    }
}