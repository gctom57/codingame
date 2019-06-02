import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int tributes = in.nextInt();
        in.nextLine();

        Map<String, Tribute> map = new LinkedHashMap<>();
        for (int i = 0; i < tributes; i++) {
            String name = in.nextLine();
            map.put(name, new Tribute(name));
        }
        int turns = in.nextInt();
        in.nextLine();

        for (int i = 0; i < turns; i++) {
            String line = in.nextLine();
            String[] info = line.split(",?\\s");

            String killerName = info[0];

            for (int j = 2; j < info.length; j++) {
                String victimName = info[j];
                Tribute t = map.get(killerName);
                t.killed.add(victimName);
                map.put(killerName, t);

                Tribute victim = map.get(victimName);
                victim.killer = t.name;
                map.put(victimName, victim);
            }

        }

        AtomicInteger i = new AtomicInteger();
        map.entrySet()
                .stream()
                .sorted(Comparator.comparing(e -> e.getValue().name))
                .forEach(e -> {
                    Tribute t = e.getValue();
                    if (i.get() != 0) {
                        System.out.println();
                    }
                    System.out.println("Name: " + t.name);

                    t.killed.sort(String::compareTo);
                    System.out.print("Killed: " + (t.killed.size() == 0 ? "None" : String.join(", ", t.killed)));
                    System.out.println("Killer: " + (t.killer.equals("") ? "Winner" : t.killer));

                    i.addAndGet(1);
                });
    }
}

class Tribute {
    String name;
    String killer = "";
    List<String> killed = new ArrayList<>();


    public Tribute(String name) {
        this.name = name;
    }
}