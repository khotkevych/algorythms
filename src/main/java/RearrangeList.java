import java.util.LinkedList;

/*
Given a singly linked list, with some positive numbers (valid numbers) and zeros (invalid numbers).
Convert the linked list in such a way that if next valid number is same as current number,
double its value and replace the next number with 0.
After the modification, rearrange the linked list such that all 0’s are shifted to the end.
*/
public class RearrangeList {

    private static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    private static void rearrange(Node root) {
        while (root != null && root.next != null) {
            if (root.value != 0 && root.next.value == root.value) {
                root.value *= 2;
                root.next.value = 0;
                root=root.next;
            }
            root=root.next;
        }
    }

    // todo why do we need return?
    private static Node sort(Node root) {
        Node zero = null, zeroStart = null;
        Node num = null, numStart = null;
        while (root != null) {
            if (root.value == 0){
                if(zeroStart == null){
                    zero = root;
                    zeroStart = root;
                }else{
                    zero.next = root;
                    zero = zero.next;
                }
            }else{
                if(numStart == null){
                    num = root;
                    numStart = root;
                }else{
                    num.next = root;
                    num = num.next;
                }
            }
            root=root.next;
        }
        if(zero != null) {
            zero.next = numStart;
            return zeroStart;
        }else {
            return numStart;
        }
    }

    private static void print(Node root){
        while (root != null)
        {
            System.out.print(root.value + " ");
            root = root.next;
        }
    }

    private static void simple() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(2);
        list.add(2);
        list.add(0);
        list.add(4);
        list.add(0);
        list.add(8);
        int lastZeroIndex = -1;
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) != 0 && list.get(i) == list.get(i + 1)) {
                list.set(i, list.get(i) * 2);
                list.set(i + 1, 0);
                i++;
            }
            if (list.get(i) == 0) {
                for (int j = i; j > lastZeroIndex + 1; j--) {
                    int tmp = list.get(j);
                    list.set(j, list.get(j - 1));
                    list.set(j - 1, tmp);
                }
                lastZeroIndex++;
            }
        }
        System.out.print(list);
    }

    public static void main(String[] args) {
        Node root = new Node(2);
        root.next = new Node(2);
        root.next.next = new Node(0);
        root.next.next.next = new Node(4);
        root.next.next.next.next = new Node(0);
        root.next.next.next.next.next = new Node(8);
        rearrange(root);
        Node newHead = sort(root);
        print(newHead);
    }
}
