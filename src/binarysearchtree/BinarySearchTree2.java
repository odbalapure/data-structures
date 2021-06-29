package binarysearchtree;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree2 {

    /*Function to find path from a node to root*/
    public static List<Integer> rootToNodePath(BinarySearchTreeNode<Integer> root, int x) {
        if (root == null) {
            return null;
        }

        if (root.data == x) {
            List<Integer> op = new ArrayList<>();
            op.add(x);
            return op;
        }

        List<Integer> leftOp = rootToNodePath(root.left, x);
        if (leftOp != null) {
            leftOp.add(root.data);
            return leftOp;
        }

        List<Integer> rightOp = rootToNodePath(root.right, x);
        if (rightOp != null) {
            rightOp.add(root.data);
            return rightOp;
        }

        return null;
    }

    public static void main(String[] args) {
        BinarySearchTreeNode<Integer> root = new BinarySearchTreeNode<>(4);
        root.left = new BinarySearchTreeNode<>(2);
        root.right = new BinarySearchTreeNode<>(6);

        root.left.left = new BinarySearchTreeNode<>(1);
        root.left.right = new BinarySearchTreeNode<>(3);

        root.left.left = new BinarySearchTreeNode<>(5);
        root.left.right = new BinarySearchTreeNode<>(7);

        System.out.println("####################################");
        System.out.println("Path from root to a node");
        List<Integer> nToRoot = rootToNodePath(root, 2);
        if (nToRoot == null) {
            System.out.println("Element NOT found...");
        } else {
            System.out.println(nToRoot);
        }
        System.out.println("####################################");
    }
}
