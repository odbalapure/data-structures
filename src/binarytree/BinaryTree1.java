package binarytree;

import com.sun.security.jgss.GSSUtil;

import java.util.Scanner;

public class BinaryTree1 {

    public static void printTree(BinaryTreeNode<Integer> root) {
        // base case
        if (root == null) {
            return;
        }

        printTree(root.left);
        System.out.print(root.data + " ");
        printTree(root.right);
    }

    /*Function to print a binary tree*/
    public static void printTreeDetailed(BinaryTreeNode<Integer> root) {
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

    /*Create a binary tree from user input*/
    public static BinaryTreeNode<Integer> takeTreeInput() {
        System.out.println("Enter root data: ");
        Scanner sc = new Scanner(System.in);
        int rootData = sc.nextInt();

        // create an empty tree
        if (rootData == -1) {
            return null;
        }

        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
        BinaryTreeNode<Integer> leftChild = takeTreeInput();
        BinaryTreeNode<Integer> rightChild = takeTreeInput();

        root.left = leftChild;
        root.right = rightChild;
        return root;
    }

    /*Create a binary tree from user input - optimized*/
    public static BinaryTreeNode<Integer> takeTreeInputBetter(boolean isRoot, int parentData, boolean isLeft) {
        if (isRoot) {
            System.out.println("Enter root data: ");
        } else {
            if (isLeft) {
                System.out.println("Enter left child of " + parentData);
            } else {
                System.out.println("Enter right child of " + parentData);
            }
        }
        Scanner sc = new Scanner(System.in);
        int rootData = sc.nextInt();

        // create an empty tree
        if (rootData == -1) {
            return null;
        }

        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
        BinaryTreeNode<Integer> leftChild = takeTreeInputBetter(false, rootData, true);
        BinaryTreeNode<Integer> rightChild = takeTreeInputBetter(false, rootData, false);

        root.left = leftChild;
        root.right = rightChild;
        return root;
    }

    /*Count the no. of nodes in a tree*/
    public static int numberOfNodes(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }

        int leftNodeCount = numberOfNodes(root.left);
        int rightNodeCount = numberOfNodes(root.right);
        return 1+ leftNodeCount + rightNodeCount;
    }

    /*Additional of all node values in a tree*/
    public static int sumOfNode(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }

        int sum = root.data + sumOfNode(root.left) + sumOfNode(root.right);
        return sum;
    }

    /*Find largest node in a tree*/
    public static int largestNode(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return -1;
        }

        int largestLeft = largestNode(root.left);
        int largestRight = largestNode(root.right);
        return Math.max(root.data, Math.max(largestLeft, largestRight));
    }

    /*Find nodes larger than K*/
    public static int largerThanX(BinaryTreeNode<Integer> root, int k) {
        if (root == null) {
            return 0;
        }

        int count = 0;
        if (root.data > k) {
            count++;
        }

        int countLeft = largerThanX(root.left, k);
        int countRight = largerThanX(root.right, k);

        // return (root.data > k ? 1 : 0) + countLeft + countRight;
        return count + countLeft + countRight;
    }

    /*Find height of a binary tree*/
    public static int heightOfBinaryTree(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = 0;
        int rightHeight = 0;
        leftHeight += heightOfBinaryTree(root.left);
        rightHeight += heightOfBinaryTree(root.right);

        int height = Math.max(leftHeight, rightHeight);
        return 1 + height;
    }

    /*Count all the leaf nodes in a tree*/
    public static int countLeafNodes(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        return countLeafNodes(root.left) + countLeafNodes(root.right);
    }

    /*Print nodes at depth k*/
    // depth is the distance of a node from root
    // NOTE: Height should start from 1 and depth from 0 ideally
    public static void printNodesAtDepthK(BinaryTreeNode<Integer> root, int k) {
        if (root == null) {
            return;
        }

        if (k == 0) {
            System.out.print(root.data +" ");
            return;
        }

        printNodesAtDepthK(root.left, k-1);
        printNodesAtDepthK(root.right, k-1);
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
        root.left = new BinaryTreeNode<>(3);
        root.left.left = new BinaryTreeNode<>(5);
        root.right = new BinaryTreeNode<>(2);
        root.right.right = new BinaryTreeNode<>(4);

        System.out.println("####################################");
        System.out.println("Print a binary tree using recursion");
        printTreeDetailed(root);
        /*System.out.println("####################################");
        System.out.println("Create a binary tree from user input");
        BinaryTreeNode<Integer> inputTree = takeTreeInputBetter(true, 0, true);
        System.out.println("User input tree...");
        printTree(inputTree);*/
        System.out.println("####################################");
        System.out.println("Number of nodes in the tree: " + numberOfNodes(root));
        System.out.println("####################################");
        System.out.println("Sum of all the nodes in the tree: " + sumOfNode(root));
        System.out.println("####################################");
        System.out.println("The largest node in the tree: " + largestNode(root));
        System.out.println("####################################");
        System.out.println("Nodes larger than a given no.: " + largerThanX(root, 1));
        System.out.println("####################################");
        System.out.println("Nodes larger thank k: " + largerThanX(root, 0));
        System.out.println("####################################");
        System.out.println("Height of the binary tree: " + heightOfBinaryTree(root));
        System.out.println("####################################");
        System.out.println("Number of leaf nodes: " + countLeafNodes(root));
        System.out.println("####################################");
        System.out.println("Print nodes at depth k: ");
        printNodesAtDepthK(root, 1);
        System.out.println();
        System.out.println("####################################");
    }
}


