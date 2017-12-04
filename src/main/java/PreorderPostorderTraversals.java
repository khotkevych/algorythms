// http://www.geeksforgeeks.org/full-and-complete-binary-tree-from-given-preorder-and-postorder-traversals/

/*
http://www.geeksforgeeks.org/wp-content/uploads/2009/06/tree12.gif
(a) Inorder (Left, Root, Right) : 4 2 5 1 3
(b) Preorder (Root, Left, Right) : 1 2 4 5 3
(c) Postorder (Left, Right, Root) : 4 5 2 3 1
*/
public class PreorderPostorderTraversals {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    private static int preIndex = 0;

    private static Node constructTreeUtil(int pre[], int post[], int l, int h, int size) {
        if (preIndex >= size || l > h) {
            return null;
        }
        // The first Node in preorder traversal is root
        Node root = new Node(pre[preIndex]);
        preIndex++;
        // If the current subarry has only one element, no need to recur or preIndex > size after incrementing
        if (l == h || preIndex >= size) {
            return root;
        }
        int i;
        // Search the next element of pre[] in post[]
        for (i = l; i <= h; i++) {
            if (post[i] == pre[preIndex]) {
                break;
            }
        }
        // Use the index of element found in postorder to divide postorder array
        // in two parts. Left subtree and right subtree
        if (i <= h) {
            root.left = constructTreeUtil(pre, post, l, i, size);
            root.right = constructTreeUtil(pre, post, i + 1, h, size);
        }
        return root;
    }

    private static void printInorder(Node root) {
        if (root == null) {
            return;
        }
        printInorder(root.left);
        System.out.print(root.data + " ");
        printInorder(root.right);
    }

    public static void main(String[] args) {
        int pre[] = {1, 2, 4, 8, 9, 5, 3, 6, 7};
        int post[] = {8, 9, 4, 5, 2, 6, 7, 3, 1};
        int size = pre.length;
        Node root = constructTreeUtil(pre, post, 0, size - 1, size);
        System.out.println("Inorder traversal of the constructed tree:");
        printInorder(root);
    }
}
