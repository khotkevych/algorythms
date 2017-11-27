import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EvenTree {

    private static Map<Integer, ArrayList<Integer>> tree = new HashMap<>();

    public static void main(String[] args) {
        int n = 10;
        int m = 9;
        for (int i = 1; i <= n; i++) {
            tree.put(i, new ArrayList<>());
        }
        int[] child = new int[]{2,3,4,5,6,7,8,9,10};
        int[] parent = new int[]{1,1,3,2,1,2,6,8,8};
        for (int i = 0; i < m; i++) {
            tree.get(parent[i]).add(child[i]);
        }
        int count = 0;
        for (int i = 2; i <= n; i++) {
            if ((countChild(i) % 2) != 0) {
                count++;
            }
        }
        System.out.println(count);
    }

    private static int countChild(int node) {
        int totalChild = tree.get(node).size();
        for (int child : tree.get(node)) {
            totalChild += countChild(child);
        }
        return totalChild;
    }

}
