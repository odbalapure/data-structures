package binarysearchtree;

public class BinarySearchTree1 {

    /*Function to print a binary tree*/
    public static void printTreeDetailed(BinarySearchTreeNode<Integer> root) {
        // base case
        if (root == null) {
            return;
        }

        System.out.print(root.data + ": ");
        if (root.left != null) {
            System.out.print("L" + root.left.data + ", ");
        }

        if (root.right != null) {
            System.out.print("R" + root.right.data);
        }
        System.out.println();

        printTreeDetailed(root.left);
        printTreeDetailed(root.right);
    }

    /*Check if an element exists in a BST*/
    public static boolean searchInBst(BinarySearchTreeNode<Integer> root, int data) {
        // if tree is empty return false as we have nothing to search
        if (root == null) {
            return false;
        }

        // the best case
        if (root.data == data) {
            return true;
        }

        if (data < root.data) {
            return searchInBst(root.left, data);
        }

        return searchInBst(root.right, data);
    }

    /*Print nodes b/w k1 and k2*/
    public static void printBwK1K2(BinarySearchTreeNode<Integer> root, int k1, int k2) {
        if (root == null) {
            return;
        }

        if (root.data < k1) {
            printBwK1K2(root.right, k1, k2);
        } else if (root.data > k2) {
            printBwK1K2(root.left, k1, k2);
        } else {
            System.out.print(root.data + " ");
            printBwK1K2(root.left, k1, k2);
            printBwK1K2(root.right, k1, k2);
        }
    }

    /*Check whether a tree is a BST*/
    public static boolean checkTreeIsBst(BinarySearchTreeNode<Integer> root) {
        if (root == null) {
            return true;
        }

        int leftMax = maximum(root.left);
        if (leftMax >= root.data) {
            return false;
        }

        int rightMin = minimum(root.right);
        if (rightMin < root.data) {
            return false;
        }

        boolean isLeftBst = checkTreeIsBst(root.left);
        boolean isRightBst = checkTreeIsBst(root.right);
        return isLeftBst && isRightBst;
    }

    /*Find minimum node*/
    public static int minimum(BinarySearchTreeNode<Integer> root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }

        int leftMin = minimum(root.left);
        int rightMin = minimum(root.right);

        return Math.min(root.data, Math.min(leftMin, rightMin));
    }

    /*Find maximum node*/
    public static int maximum(BinarySearchTreeNode<Integer> root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }

        int leftLarge = maximum(root.left);
        int rightLarge = maximum(root.right);

        return Math.max(root.data, Math.max(leftLarge, rightLarge));
    }

    /*Check is tree is BST - optimized*/
    public static IsBst checkTreeIsBst2(BinarySearchTreeNode<Integer> root) {
        if (root == null) {
            return new IsBst(Integer.MAX_VALUE, Integer.MIN_VALUE, true);
        }

        IsBst leftAns = checkTreeIsBst2(root.left);
        IsBst rightAns = checkTreeIsBst2(root.right);

        int min = Math.min(root.data, Math.min(leftAns.min, rightAns.min));
        int max = Math.max(root.data, Math.max(leftAns.max, rightAns.max));

        boolean isBst = true;
        if (leftAns.max >= root.data) {
            isBst = false;
        }

        if (rightAns.min < root.data) {
            isBst = false;
        }

        if (!leftAns.isBst) {
            isBst = false;
        }

        if (!rightAns.isBst) {
            isBst = false;
        }

        return new IsBst(min, max, isBst);
    }

    public static void main(String[] args) {
        BinarySearchTreeNode<Integer> root = new BinarySearchTreeNode<>(4);
        root.left = new BinarySearchTreeNode<>(2);
        root.right = new BinarySearchTreeNode<>(6);

        root.left.left = new BinarySearchTreeNode<>(1);
        root.left.right = new BinarySearchTreeNode<>(3);

        root.right.left = new BinarySearchTreeNode<>(5);
        root.right.right = new BinarySearchTreeNode<>(7);

        System.out.println("####################################");
        System.out.println("Is the node present in the BST: " + searchInBst(root, 100));
        System.out.println("####################################");
        System.out.println("Print nodes b/w k1 and k2");
        printBwK1K2(root, 1, 6);
        System.out.println();
        System.out.println("####################################");
        System.out.println("Is the tree a BST: " + checkTreeIsBst(root));
        System.out.println("####################################");
        System.out.println("Is the tree a BST - optimized: " + checkTreeIsBst2(root).isBst);
        System.out.println("####################################");
    }
}

class IsBst {
    int min, max;
    boolean isBst;

    public IsBst(int min, int max, boolean isBst) {
        this.min = min;
        this.max = max;
        this.isBst = isBst;
    }
}