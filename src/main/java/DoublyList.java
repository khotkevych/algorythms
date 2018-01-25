import java.util.ArrayList;

public class DoublyList {
    static class Node {
        int data, prev, next;

        Node(int data, int prev, int next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

        void print() {
            System.out.println(data + " " + prev + " " + next);
        }

    }

    static ArrayList<Node> nodes = new ArrayList<>();

    void add(int data) {
        if (nodes.size() == 0) {
            nodes.add(new Node(0, 0, 1));
            nodes.add(new Node(data, 0, 0));
        } else {
            nodes.get(nodes.size() - 1).next = nodes.size();
            nodes.add(new Node(data, nodes.size() - 1, 0));
        }
    }

    void remove(int i) {
        if (i <= 0 || i >= nodes.size()) {
            return;
        }
        nodes.get(nodes.size() - 2).next = 0;
        if (i != nodes.size() - 1) {
            nodes.get(i).data = nodes.get(nodes.size() - 1).data;
        }
        nodes.remove(nodes.size() - 1);
    }

    public static void main(String[] args) {
        DoublyList t = new DoublyList();
        t.add(1);
       /* for (int i = 2; i < 32; i = i * 2) {
            t.add(i);
        }*/
        System.out.println("data prev next");
        for (Node n : nodes) {
            n.print();
        }
        t.remove(1);
        System.out.println();
        System.out.println("data prev next");
        for (Node n : nodes) {
            n.print();
        }
        System.out.println();
        int i = nodes.get(0).next;
        while (i != 0) {
            System.out.print(" " + nodes.get(i).data);
            i = nodes.get(i).next;
        }
    }
}
