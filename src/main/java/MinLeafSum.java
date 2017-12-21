public class MinLeafSum {

    private static class Node {
        int data;
        Node left, right;

        public Node(int item) {
            data = item;
            left = right = null;
        }
    }

    private static int findMinLevel(Node root) {
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        if (root.left == null) {
            return findMinLevel(root.right) + 1;
        }
        if (root.right == null) {
            return findMinLevel(root.left) + 1;
        }
        return Math.min(findMinLevel(root.left), findMinLevel(root.right)) + 1;
    }

    private static int minLeafSum(Node root){
        int minLevel = findMinLevel(root);
        System.out.println("Min level: " + minLevel);
        return minLeafSum(root, minLevel, 1);
    }
    private static int minLeafSum(Node root, int minLevel, int currLevel) {
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null) {
            return root.data;
        }
        int sum=0;
        if(currLevel < minLevel){
            sum+= minLeafSum(root.left, minLevel, currLevel+1);
            sum+= minLeafSum(root.right, minLevel, currLevel+1);
        }
        return sum;
    }

    public static void main(String args[]) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.right.left = new Node(8);
        root.right.left.right = new Node(9);
        System.out.println(minLeafSum(root));
    }
}
