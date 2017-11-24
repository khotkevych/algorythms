import java.util.HashMap;
import java.util.LinkedList;

public class CommonManager {
    private static HashMap<String, String> map = new HashMap<>();

    private static String findManager(String name1, String name2) {
        if (map.containsKey(name1) && map.get(name1).equals(name2)) {
            return name1;
        }
        if (map.containsKey(name2) && map.get(name2).equals(name1)) {
            return name2;
        }
        LinkedList<String> parent1 = new LinkedList<>();
        LinkedList<String> parent2 = new LinkedList<>();
        getParents(parent1, name1);
        getParents(parent2, name2);
        parent1.retainAll(parent2);
        return parent1.peek();
    }

    private static void getParents(LinkedList<String> list, String name) {
        if (map.get(name) == null) {
            return;
        }
        list.add(map.get(name));
        getParents(list, map.get(name));
    }

    private static void add(String boss, String employee) {
        // store data in bidirectional order. Employee->boss
        if (map.size() == 0) {
            map.put(boss, null);
        }
        map.put(employee, boss);
    }

    public static void main(String[] args) {
        String name1 = "Hilary", name2 = "James";
        add("Sarah", "Fred");
        add("Sarah", "Paul");
        add("Fred", "Hilary");
        add("Fred", "Jenny");
        add("Jenny", "James");
        System.out.println(findManager(name1, name2)); // "Fred"
    }
}
