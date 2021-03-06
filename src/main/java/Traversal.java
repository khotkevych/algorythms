import java.util.Iterator;
import java.util.LinkedList;

public class Traversal {

    private int V;
    private LinkedList<Integer> adj[];

    private Traversal(int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }

    private void addEdge(int v,int w)
    {
        adj[v].add(w);
    }

    private void BFS(int s)
    {
        boolean visited[] = new boolean[V];
        LinkedList<Integer> queue = new LinkedList<>();
        // Mark the current node as visited and enqueue it
        visited[s]=true;
        queue.add(s);
        while (queue.size() != 0)
        {
            // Dequeue a vertex from queue and print it
            s = queue.poll();
            System.out.print(s+" ");
            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            for (Integer n : adj[s]) {
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    private void DFSUtil(int v,boolean visited[])
    {
        // Mark the current node as visited and print it
        visited[v] = true;
        System.out.print(v+" ");
        // Recur for all the vertices adjacent to this vertex
        for (Integer n : adj[v]) {
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }

    private void DFS(int v)
    {
        boolean visited[] = new boolean[V];
        DFSUtil(v, visited);
    }

    public static void main(String[] args){
        // https://www.geeksforgeeks.org/wp-content/uploads/BFS.jpg
        Traversal g = new Traversal(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        System.out.println("Following is Breadth First Traversal (starting from vertex 2)");
        g.BFS(2);
        System.out.println();
        System.out.println("Following is Depth First Traversal (starting from vertex 2)");
        g.DFS(2);
    }
}
