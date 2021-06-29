package binarysearchtree;

public class BST {
    private BinarySearchTreeNode<Integer> root;
    private int size;

    /*
    * Function to check whether a node exists in a BST or not
    * */
    public boolean isPresent(int x) {
        return isPresentHelper(root, x);
    }

    // Helper method for isPresent()
    private static boolean isPresentHelper(BinarySearchTreeNode<Integer> node, int x) {
        if (node == null) {
            return false;
        }

        if (node.data == x) {
            return true;
        }

        if (x < node.data) {
            return isPresentHelper(node.left, x);
        }

        if (x > node.data) {
            return isPresentHelper(node.right, x);
        }

        return false;
    }

    /*
    * Function to insert a node in a BST
    * */
    public void insert(int x) {
        root = insertHelper(root, x);
    }

    // Helper function for insert()
    public static BinarySearchTreeNode<Integer> insertHelper(BinarySearchTreeNode<Integer> node, int x) {
        if (node == null) {
            return new BinarySearchTreeNode<>(x);
        }

        if (x >= node.data) {
            node.right = insertHelper(node.right, x);
        } else {
            node.left = insertHelper(node.left, x);
        }
        return node;
    }


    /*
    * Delete a node from a BST
    * Returns false if the node to delete does not exists
    * */
    public boolean delete(int x) {
        BstDeleteReturn output = deleteHelper(root,x );
        root = output.root;
        if (output.deleted) {
            size--;
        }

        return output.deleted;
    }

    // Helper method for delete()
    private static BstDeleteReturn deleteHelper(BinarySearchTreeNode<Integer> root, int x) {
        if (root == null) {
            return new BstDeleteReturn(null, false);
        }

        if (root.data < x) {
            BstDeleteReturn outputRight =  deleteHelper(root.right, x);
            root.right = outputRight.root;
            outputRight.root = root;
            return outputRight;
        }

        if (root.data > x) {
            BstDeleteReturn outputLeft =  deleteHelper(root.left, x);
            root.left = outputLeft.root;
            outputLeft.root = root;
            return outputLeft;
        }

        // 0 children
        if (root.left == null && root.right == null) {
            return new BstDeleteReturn(null, true);
        }

        // only left child
        if (root.left != null && root.right == null) {
            return new BstDeleteReturn(root.left, true);
        }

        // only right child
        if (root.right != null && root.left == null) {
            return new BstDeleteReturn(root.right, true);
        }

        // both children are present
        int minRight = minimum(root.right);
        root.data = minRight;
        BstDeleteReturn output = deleteHelper(root.right, minRight);
        root.right = output.root;
        return new BstDeleteReturn(root, true);
    }

    // Helper method to find minimum node
    private static int minimum(BinarySearchTreeNode<Integer> root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }

        int leftMin = minimum(root.left);
        int rightMin = minimum(root.right);

        return Math.min(root.data, Math.min(leftMin, rightMin));
    }

    /*
    * Print the BST
    * */
    public void printTree() {
        printTreeHelper(root);
    }

    // Helper method for printTree()
    public static void printTreeHelper(BinarySearchTreeNode<Integer> node) {
        // base case
        if (node == null) {
            return;
        }

        System.out.print(node.data + ": ");
        if (node.left != null) {
            System.out.print("L" + node.left.data + ", ");
        }

        if (node.right != null) {
            System.out.print("R" + node.right.data);
        }
        System.out.println();

        printTreeHelper(node.left);
        printTreeHelper(node.right);
    }

}

class BstDeleteReturn {
    BinarySearchTreeNode<Integer> root;
    boolean deleted;

    public BstDeleteReturn() {

    }

    public BstDeleteReturn(BinarySearchTreeNode<Integer> root, boolean deleted) {
        this.root = root;
        this.deleted = deleted;
    }
}