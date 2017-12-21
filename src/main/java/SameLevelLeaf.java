public class SameLevelLeaf {

    private static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    private static int level = 0;


    private static boolean check(Node head, int currLevel) {
        if (head == null) {
            return true;
        }
        if (head.left == null && head.right == null) {
            if (level == 0) {
                level = currLevel;
                return true;
            }
            return level == currLevel;
        }
        return check(head.left, currLevel + 1) && check(head.right, currLevel + 1);
    }

    public static void main(String args[]) {
        Node root = new Node(12);
        root.left = new Node(5);
        root.left.left = new Node(3);
        root.left.right = new Node(9);
        root.left.left.left = new Node(1);
        root.left.right.left = new Node(1);
        if (check(root, 0))
            System.out.println("Leaves are at same level");
        else
            System.out.println("Leaves are not at same level");
    }
}
