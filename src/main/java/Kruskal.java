import java.util.ArrayList;
import java.util.Comparator;

class Triplet {
    int a, b;
    double w;

    Triplet(double w, int a, int b) {
        this.w = w;
        this.a = a;
        this.b = b;

    }
}

public class Kruskal {

    private static int num = 8;
    //  disjoint sets
    private static int fathers[] = new int[num];


    private static int find(int x) {
        return fathers[x] == x ? x : find(fathers[x]);
    }

    private static void unite(int x, int y) {
        fathers[find(x)] = find(y);
    }

    public static void main(String[] args) {
        for (int i = 0; i < num; i++) {
            fathers[i] = i;
        }
        ArrayList<Triplet> edges = new ArrayList<>();
        edges.add(new Triplet(0.35, 4, 5));
        edges.add(new Triplet(0.37, 4, 7));
        edges.add(new Triplet(0.28, 5, 7));
        edges.add(new Triplet(0.16, 0, 7));
        edges.add(new Triplet(0.32, 1, 5));
        edges.add(new Triplet(0.38, 0, 4));
        edges.add(new Triplet(0.17, 2, 3));
        edges.add(new Triplet(0.19, 1, 7));
        edges.add(new Triplet(0.26, 0, 2));
        edges.add(new Triplet(0.36, 1, 2));
        edges.add(new Triplet(0.29, 1, 3));
        edges.add(new Triplet(0.34, 2, 7));
        edges.add(new Triplet(0.40, 6, 2));
        edges.add(new Triplet(0.52, 3, 6));
        edges.add(new Triplet(0.58, 6, 0));
        edges.add(new Triplet(0.93, 6, 4));

        //  STEP 1: sort the list of edges
        edges.sort(new Comparator<Triplet>() {
            @Override
            public int compare(Triplet p1, Triplet p2) {
                return Double.compare(p1.w, p2.w);
            }
        });
        double mst_weight = 0, w;
        int mst_ni = 0, mst_edges = 0, a, b;
        //  STEP 2-3:
        while ((mst_edges < num - 1) || (mst_ni < edges.size())) {
            a = edges.get(mst_ni).a;
            b = edges.get(mst_ni).b;
            w = edges.get(mst_ni).w;
            //  we check if the edge is ok to be included in the MST
            //  if a and b are in different trees (if they are on the same we will create a cycle)
            if (find(a) != find(b)) {
                //  we unite the two trees the edge connects
                unite(a, b);
                mst_weight += w;
                System.out.println(a + " " + b + " " + w);
                mst_edges++;
            }
            mst_ni++;
        }
        System.out.println("\nWeight of the MST is " + mst_weight);
    }
}
