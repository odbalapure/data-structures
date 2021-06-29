package binarysearchtree;

public class BSTCrud {

    public static void main(String[] args) {
        BST bst = new BST();
        bst.insert(5);
        bst.insert(2);
        bst.insert(7);
        bst.insert(1);
        bst.insert(3);
        bst.insert(6);
        bst.insert(8);

        bst.printTree();

        System.out.println(bst.isPresent(5));
        bst.delete(5);
        System.out.println(bst.isPresent(5));

        bst.printTree();

        System.out.println(bst.isPresent(2));
        bst.delete(2);
        System.out.println(bst.isPresent(2));

        bst.printTree();
    }
}
