class Node {
    String data;
    Node left, right;

    Node(String item) {
        data = item;
        left = right = null;
    }
}


public class ManagerHierarchy {

    private Node root;

    private ManagerHierarchy() {
        root = null;
    }

    /* function to print level order traversal of tree*/
    private void printLevelOrder() {
        int h = height(root);
        int i;
        for (i = 1; i <= h; i++) {
            printGivenLevel(root, i);
            System.out.println();
        }
    }

    /* Compute the "height" of a tree -- the number of
    nodes along the longest path from the root node
    down to the farthest leaf node.*/
    private int height(Node root) {
        if (root == null)
            return 0;
        else {
            /* compute  height of each subtree */
            int lheight = height(root.left);
            int rheight = height(root.right);

            /* use the larger one */
            if (lheight > rheight)
                return (lheight + 1);
            else return (rheight + 1);
        }
    }

    /* Print nodes at the given level */
    private void printGivenLevel(Node root, int level) {
        if (root == null) {
            return;
        }
        if (level == 1) {
            System.out.print(root.data + " ");
        } else if (level > 1) {
            printGivenLevel(root.left, level - 1);
            printGivenLevel(root.right, level - 1);
        }

    }

    public static void main(String args[]) {
        ManagerHierarchy tree = new ManagerHierarchy();

        /*tree.root = new Node("Jon");
        tree.root.left = new Node("Mark");
        tree.root.right = new Node("David");
        tree.root.left.left = new Node("Paul");
        tree.root.left.left.left = new Node("Lee");
        tree.root.left.left.right = new Node("Steve");*/

        tree.root = new Node("Jon");
        tree.root.left = new Node("Lee");
        tree.root.left.left = new Node("Paul");
        tree.root.left.left.left = new Node("Mark");
        tree.root.left.left.right = new Node("David");
        tree.root.left.right = new Node("Steve");
        tree.root.left.right.left = new Node("Mat");

        tree.printLevelOrder();
    }
}
