package binarysearchtree;

public class BinarySearchTreeNode<T> {
    T data;
    BinarySearchTreeNode<T> left;
    BinarySearchTreeNode<T> right;

    public BinarySearchTreeNode(T data) {
        this.data = data;
        left = null;
        right = null;
    }
}
