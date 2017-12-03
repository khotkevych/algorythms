// Reverse a Doubly Linked List

public class ReverseDoubledList {

    // add to the beginning
    private static Node head;

    static class Node{
        int data;
        Node prev, next;

        Node(int data){
            this.data = data;
        }
    }

    private void add(int data){
        Node node = new Node(data);
        node.next = head;
        if(head != null){
            head.prev = node;
        }
        head = node;
    }

    private void print(){
        Node node = head;
        while(node != null){
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    private void reverse(){
        Node tmp = null, node = head;
        while(node != null){
            // swap
            tmp = node.prev;
            node.prev = node.next;
            node.next = tmp;
            //
            node = node.prev; // it in the node.next before swapping
        }
        if(tmp != null) {
            head = tmp.prev;
        }
    }

    public static void main(String[] args){
        ReverseDoubledList list = new ReverseDoubledList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.print();
        list.reverse();
        list.print();
    }
}
