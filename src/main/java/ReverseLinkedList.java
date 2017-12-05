
public class ReverseLinkedList {

    static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    private static Node reverse(Node head) {
        if(head.next == null){
            return head;
        }
        Node current = head;
        Node prev = null;
        while (current != null) {
            head = current.next;
            current.next = prev;
            prev = current;
            current = head;
        }
        return prev;
    }

    private static Node reverseRecursive(Node head)
    {
        if(head.next == null) {
            return head;
        }
        Node newHead = reverseRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    private static void print(Node head) {
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        // add to the end
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        print(reverseRecursive(head));
    }
}
