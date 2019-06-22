import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    static Depot[] allDepots = new Depot[7];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        for (int i = 0; i < 7; i++) {
            allDepots[i] = new Depot(i, in.nextLine().split(" "));
        }

        Depot[] tmp = new Depot[7];
        recursiveFind(tmp, 0);

        System.out.println(Stream.of(1, 2, 6, 0, 3, 5, 4).map(i -> tmp[i].getResult()).collect(Collectors.joining(" ")));
    }

    static boolean recursiveFind(Depot[] depots, int index) {
        if (index == 7) {
            return true;
        }

        if (index == 0) {
            for (int i = 0; i < 7; i++) {
                Depot d = allDepots[i];
                d.putSmallestOnRight();
                depots[0] = d;
                if (recursiveFind(depots, index + 1)) {
                    return true;
                }
            }
        } else {
            for (int i = 0; i < 7; i++) {
                Depot d = allDepots[i];

                if (alreadyUsed(d.index, depots, index)) {
                    continue;
                }

                for (int k = 0; k < 6; k++) {
                    if (d.tab[index % 6].equals(depots[0].tab[(3 + index) % 6]) && (index == 1 || d.tab[(1 + index) % 6].equals(depots[index - 1].tab[index - 2]))) {
                        depots[index] = d;

                        if (recursiveFind(depots, index + 1)) {
                            return true;
                        }
                    }
                    d.turnClockWise();
                }
            }
        }

        return false;
    }

    private static boolean alreadyUsed(int currentDepotIndex, Depot[] depotsUsed, int index) {
        boolean used = false;
        for (int j = 0; j < index; j++) {
            if (depotsUsed[j].index == currentDepotIndex) {
                used = true;
                break;
            }
        }
        return used;
    }
}

class Depot {
    int index;
    String[] tab;
    private String smallest;

    Depot(int index, String[] tab) {
        this.index = index;
        this.tab = tab;
        smallest = tab[0];
        for (int i = 1; i < tab.length; i++) {
            if (tab[i].compareTo(smallest) < 0) {
                smallest = tab[i];
            }
        }
    }

    void turnClockWise() {
        String[] tmp = new String[6];
        System.arraycopy(tab, 0, tmp, 1, 5);
        tmp[0] = tab[5];
        tab = tmp;
    }

    private boolean smallestOnRight() {
        return tab[0].equals(smallest);
    }

    void putSmallestOnRight() {
        while (!smallestOnRight()) {
            turnClockWise();
        }
    }

    String getResult() {
        return index + tab[0];
    }
}