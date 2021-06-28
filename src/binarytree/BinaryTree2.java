package binarytree;

import com.sun.source.tree.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTree2 {

    /*Remove leaf nodes of a tree*/
    public static BinaryTreeNode<Integer> removeLeafNodes(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return null;
        }

        if (root.left == null && root.right == null) {
            return null;
        }

        root.left = removeLeafNodes(root.left);
        root.right = removeLeafNodes(root.right);
        return root;
    }

    /*Check if a tree is balanced or not*/
    // if height(left tree) - height(right tree) <= 1
    // Balance means that - left or the right side should not be too heavy
    // NOTE: the difference MUST be absolute
    public static boolean isBalanced(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return true;
        }

        int leftHeight = BinaryTree1.heightOfBinaryTree(root.left);
        int rightHeight = BinaryTree1.heightOfBinaryTree(root.right);

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return false;
        }

        boolean isLeftBalanced = isBalanced(root.left);
        boolean isRightBalanced = isBalanced(root.right);

        return isLeftBalanced && isRightBalanced;
    }

    public static BalancedTreeReturn isBalancedOptimized(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return new BalancedTreeReturn(0, true);
        }

        BalancedTreeReturn leftOp = isBalancedOptimized(root.left);
        BalancedTreeReturn rightOp = isBalancedOptimized(root.right);

        boolean isBal = true;
        int height = 1 + Math.max(leftOp.height, rightOp.height);

        if (Math.abs(leftOp.height - rightOp.height) > 1) {
            isBal = false;
        }

        if (!leftOp.isBalanced || !rightOp.isBalanced) {
            isBal = false;
        }

        return new BalancedTreeReturn(height, isBal);
    }

    /*Find diameter of a tree*/
    // distance b/w 2 farthest nodes or the no. of edges
    //              1
    //            /   \
    //           2     3
    // in this case the diameter is 2

    public static BinaryTreeNode<Integer> takeInputLevelWise() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter root data: ");
        int rootData = sc.nextInt();

        if (rootData == -1) {
            return null;
        }

        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
        Queue<BinaryTreeNode<Integer>> pendingChildren = new LinkedList<>();
        pendingChildren.add(root);

        while (!pendingChildren.isEmpty()) {
            BinaryTreeNode<Integer> front = pendingChildren.poll();
            System.out.println("Enter left child of " + front.data);
            int left = sc.nextInt();
            if (left != -1) {
                BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<>(left);
                front.left = leftChild;
                pendingChildren.add(leftChild);
            }

            System.out.println("Enter right child of " + front.data);
            int right = sc.nextInt();
            if (right != -1) {
                BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<>(right);
                front.right = rightChild;
                pendingChildren.add(rightChild);
            }
        }

        return root;
    }


    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
        root.left = new BinaryTreeNode<>(3);
        root.left.left = new BinaryTreeNode<>(5);
        root.right = new BinaryTreeNode<>(2);
        root.right.right = new BinaryTreeNode<>(4);
        root.right.left = new BinaryTreeNode<>(6);

        /*System.out.println("####################################");
        BinaryTreeNode<Integer> removeLeaf = removeLeafNodes(root);
        BinaryTree1.printTree(removeLeaf);
        System.out.println();*/
        System.out.println("####################################");
        System.out.println("Is the binary tree balanced: " + isBalanced(root));
        System.out.println("####################################");
        System.out.println("Is the binary tree balanced - optimized: " + isBalancedOptimized(root).isBalanced);
        System.out.println("####################################");
        System.out.println("Level order traversal input");
        BinaryTreeNode<Integer> level = takeInputLevelWise();
        BinaryTree1.printTreeDetailed(level);
        System.out.println();
        System.out.println("####################################");
    }
}

class BalancedTreeReturn {
    int height;
    boolean isBalanced;

    public BalancedTreeReturn() {}

    public BalancedTreeReturn(int height, boolean isBalanced) {
        this.height = height;
        this.isBalanced = isBalanced;
    }
}
