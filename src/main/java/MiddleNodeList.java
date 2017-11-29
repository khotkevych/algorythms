import java.util.LinkedList;

public class MiddleNodeList {

    private static Node head;

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
    }

    public static void main(String[] args) {
        LinkedList<String> a = new LinkedList<>();
        a.add(":");
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
    }
}
