import java.util.*;

class Edge {
    int node;
    int cost;

    Edge(int n, int c) {
        node = n;
        cost = c;
    }
}

public class Prim {
    private static HashMap<Integer, ArrayList<Edge>> adjList;

    private static int prim(int start, int numNodes) {
        Queue<Edge> queue = new PriorityQueue<>(numNodes, Comparator.comparingInt(e -> e.cost));
        queue.add(new Edge(start, 0));
        HashSet<Integer> visited = new HashSet<>();
        int totalCost = 0;
        while (queue.size() > 0 && visited.size() != numNodes) {
            Edge curr = queue.poll();
            if (visited.contains(curr.node)) {
                continue;
            }
            visited.add(curr.node);
            totalCost += curr.cost;
            ArrayList<Edge> reachNodes = adjList.get(curr.node);
            for (Edge reachNode : reachNodes) {
                queue.add(new Edge(reachNode.node, reachNode.cost));
            }
        }
        return totalCost;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numNodes = sc.nextInt(); // 5
        int numEdges = sc.nextInt(); // 6
        adjList = new HashMap<>();
        for (int i = 1; i <= numNodes; i++) {
            adjList.put(i, new ArrayList<>());
        }
        /*
        1 2 3
        1 3 4
        4 2 6
        5 2 2
        2 3 5
        3 5 7
        */
        for (int i = 0; i < numEdges; i++) {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            int c = sc.nextInt();
            adjList.get(n1).add(new Edge(n2, c));
            adjList.get(n2).add(new Edge(n1, c));
        }
        int start = sc.nextInt(); // 1
        System.out.println(prim(start, numNodes));
    }
}