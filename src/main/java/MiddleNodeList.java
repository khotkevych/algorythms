import java.util.Arrays;

public class MiddleNodeList {

    private static Node head;
    private int size;

    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    private void add(int data) {
        Node node = new Node(data);
        node.next = head;
        head = node;
        size++;
    }


    private Object[] toArray() {
        Object[] result = new Object[size];
        int i = 0;
        for (Node x = head; x != null; x = x.next)
            result[i++] = x.data;
        return result;
    }

    public static void main(String[] args) {
        MiddleNodeList list = new MiddleNodeList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println(slow.data); // 4
        System.out.println(Arrays.toString(list.toArray()));
    }
}

class MiddleNodeList2 {

    private static Node first;
    private static Node last;
    private int size;

    class Node {
        int data;
        Node next;
        Node prev;

        Node(int data, Node prev) {
            this.data = data;
            this.prev = prev;
        }
    }

    private void add(int data) {
        final Node l = last;
        Node node = new Node(data, l);
        last = node;
        if (first == null) {
            first = last;
        }
        else {
            node.prev.next = node;
            //node.next = node;
        }
        size++;
    }

    private Object[] toArray() {
        Object[] result = new Object[size];
        int i = 0;
        for (Node x = first; x != null; x = x.next)
            result[i++] = x.data;
        return result;
    }

    public static void main(String[] args) {
        MiddleNodeList2 list = new MiddleNodeList2();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        Node slow = first;
        Node fast = first;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println(slow.data); // 5
        System.out.println(Arrays.toString(list.toArray()));
    }
}
