// Given a binary tree containing n nodes. The problem is to get the sum of all the
// leaf nodes which are at minimum level in the binary tree.

public class LeafSum {

    private static class Node{
        int data;
        Node left, right;

        Node(int data){
            this.data = data;
        }
    }

    private static int leafSumMin(Node head){
        int sum = 0;
        if(head == null){
            return 0;
        }
        if(head.left == null && head.right == null){
            sum+=head.data;
        }
        sum+= leafSumMin(head.left);
        sum+= leafSumMin(head.right);
        return sum;
    }

    public static void main(String[] args){
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(8);
        root.right = new Node(3);
        root.right.right = new Node(7);
        root.right.left = new Node(6);
        root.right.left.right = new Node(9); // left

        System.out.println(leafSumMin(root));
    }
}
