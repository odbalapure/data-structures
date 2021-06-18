package linkedlist;

public class LinkedList2 {

    /*Delete the first node in a linked list*/
    public static void deleteFirstNode(Node head) {
        if (head == null) {
            System.out.println("Linked list empty, nothing to delete...");
            return;
        }

        head = head.next;
        LinkedList1.print(head);
    }

    /*Delete last node in a linked list*/
    public static void deleteLastNode(Node head) {
        if (head == null) {
            System.out.println("Linked list empty, nothing to delete...");
            return;
        }

        // find the 2nd last node
        Node secondLast = head;
        while (secondLast.next.next != null) {
            secondLast = secondLast.next;
        }

        secondLast.next = null;
        LinkedList1.print(head);
    }

    /*Delete a node with specific value*/
    public static void deleteSpecificValueNode(Node head, int key) {
        Node<Integer> temp = head, prev = null;

        // if the node to delete is head node
        if (temp != null && temp.data == key) {
            head = temp.next;
            return;
        }

        while (temp !=null && temp.data != key) {
            prev = temp;
            temp = temp.next;
        }

        // key was not present in the list
        if (temp == null) {
            System.out.println("Key NOT found, returning...");
            return;
        }

        prev.next = temp.next;
        LinkedList1.print(head);
    }

    /*Delete a node present at ith index*/
    public static void deleteNodeAtIndex(Node head, int pos) {
        if (head == null) {
            System.out.println("Linked list empty, nothing to delete...");
            return;
        }

        // delete first node
        if (pos == 0) {
            head = head.next;
        }

        Node<Integer> temp = head;
        for (int i=0; temp !=null && i < pos - 1; i++) {
            temp = temp.next;
        }

        if (temp == null || temp.next == null) {
            System.out.println("Not at this index cannot be deleted!");
            System.out.println("Index is out of bounds...");
            return;
        }

        Node next = temp.next.next;
        temp.next = next;
        LinkedList1.print(head);
    }

    public static void main(String[] args) {
        Node<Integer> head = new Node<>(1);
        head.next = new Node<>(2);
        head.next.next = new Node<>(3);
        head.next.next.next = new Node<>(4);
        head.next.next.next.next = new Node<>(5);

        System.out.println("####################################");
        System.out.println("Delete a node with specific value");
        deleteSpecificValueNode(head,3);
        System.out.println("####################################");
        System.out.println("Delete first node");
        deleteFirstNode(head);
        System.out.println("####################################");
        System.out.println("Delete last node");
        deleteLastNode(head);
        System.out.println("####################################");
        System.out.println("Delete a node at ith index");
        deleteNodeAtIndex(head, 10);
        System.out.println("####################################");
    }

}
