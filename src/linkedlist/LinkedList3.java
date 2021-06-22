package linkedlist;

import javax.sound.sampled.Line;
import java.util.Scanner;

public class LinkedList3 {

    /*Print linked list using recursion*/
    public static void printRecursive(Node<Integer> head) {
        if (head == null) {
            return;
        }

        printRecursive(head.next);
        System.out.print(head.data + " ");
    }

    /*Insert a node recursively*/
    public static Node<Integer> insertRecursively(Node<Integer> head, int ele, int pos) {
        // main EXIT condition
        if (head == null && pos > 0) {
            return null;
        }

        if (pos == 0) {
            System.out.println("Insert at the beginning...");
            Node<Integer> newNode = new Node<>(ele);
             newNode.next = head;
             return newNode;
        } else {
            Node<Integer> smallerHead = insertRecursively(head.next, ele, pos - 1);
            head.next = smallerHead;
            // head.next = insertRecursively(head.next, ele, pos - 1);
            return head;
        }
    }

    /*Delete node in linked list recursively*/
    public static Node<Integer> deleteRecursively(Node<Integer> head, int pos) {
        if (head == null) {
            return null;
        }

        if (pos == 0) {
            Node<Integer> res = head.next;
            return res;
        }

        head.next = deleteRecursively(head.next, pos - 1);
        return head;
    }

    /*Reverse a linked list iteratively*/
    public static void reverseLinkedList(Node<Integer> head) {
        if (head == null || head.next == null) {
            return;
        }

        Node<Integer> prev = null, curr = head, forward = null;
        while (curr != null) {
            forward = curr.next; // keep backup
            curr.next = prev; // link to previous node

            prev = curr;
            curr = forward;
        }

        LinkedList1.print(prev);
    }

    /*Reverse a linked list recursively*/
    public static Node<Integer> reverseLinkedListRecursively(Node<Integer> head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node<Integer> smallHead = reverseLinkedListRecursively(head.next);
        Node<Integer> tail = smallHead;
        while (tail.next != null) {
            tail = tail.next;
        }

        tail.next = head;
        head.next = null;

        return smallHead;
    }

    /*Mid point of a linked list*/
    public static Node<Integer> midOfLinkedList(Node<Integer> head) {
        Node<Integer> slow = head;
        Node<Integer> fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        System.out.println("Mid of linked list: " + slow.data);
        return slow;
    }

    /*Merge 2 sorted linked lists*/
    public static Node<Integer> mergerSortedLinkedList(Node<Integer> head1, Node<Integer> head2) {
        Node<Integer> t1 = head1, t2 = head2;
        Node<Integer> head = null, tail = null;

        // compare first nodes
        if (t1.data <= t2.data) {
            head = t1;
            tail = t1;

            t1 = t1.next;
        } else {
            head = t2;
            tail = t2;

            t2 = t2.next;
        }

        while (t1 != null && t2 != null) {
            if (t1.data <= t2.data) {
                tail.next = t1;
                tail = t1;

                t1 = t1.next;
            } else {
                tail.next = t2;
                tail = t2;

                t2 = t2.next;
            }
        }

        // append remaining nodes
        if (t1 != null) {
            // first list is remaining
            tail.next = t1;
        } else {
            tail.next = t2;
        }

        return head;
    }

    /*Find mid of a list using head and tail*/
    public static Node<Integer> mid(Node<Integer> head, Node<Integer> tail) {
        Node fast = head;
        Node slow = head;

        while (fast != tail && fast.next != tail) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        Node<Integer> head = new Node<>(1);
        head.next = new Node<>(2);
        head.next.next = new Node<>(3);
        head.next.next.next = new Node<>(4);
        head.next.next.next.next = new Node<>(5);
        head.next.next.next.next.next = new Node<>(6);

        Node<Integer> head1 = new Node<>(1);
        head1.next = new Node<>(2);
        head1.next.next = new Node<>(10);
        head1.next.next.next = new Node<>(19);
        head1.next.next.next.next = new Node<>(100);
        head1.next.next.next.next.next = new Node<>(199);

        Node<Integer> head2 = new Node<>(5);
        head2.next = new Node<>(32);
        head2.next.next = new Node<>(50);

        System.out.println("####################################");
        System.out.println("Print linked list recursively");
        printRecursive(head);
        System.out.println();
        System.out.println("####################################");
        System.out.println("Insert a node recursively");
        head = insertRecursively(head, 20, 0);
        LinkedList1.print(head);
        System.out.println("####################################");
        System.out.println("Delete a node recursively");
        head = deleteRecursively(head, 2);
        LinkedList1.print(head);
        System.out.println("####################################");
        System.out.println("Reverse Linked List");
        reverseLinkedList(head);
        System.out.println("####################################");
        System.out.println("Merge two sorted linked list");
        Node<Integer> mergedList = mergerSortedLinkedList(head1, head2);
        LinkedList1.print(mergedList);
        System.out.println("####################################");
        System.out.println("Get tail of a linked list");
        Node<Integer> tail = tailNode(head);
        LinkedList1.print(tail);
        System.out.println("####################################");
    }

    /*Final tail node of a linked list*/
    private static Node<Integer> tailNode(Node<Integer> head) {
        Node<Integer> temp = head;
        Node<Integer> tail = null;
        while (temp != null) {
            tail = temp;
            temp = temp.next;
        }

        return tail;
    }

    /*Insert node at the end of linked list*/
    public static Node<Integer> appendAtLast(Node<Integer> head, int data) {

        Node<Integer> currentNode = new Node<>(data);
        if (head == null) {
            // checking if the node is the first node
            head = currentNode;
        } else {
            // start appending nodes at the end
            Node<Integer> tail = head;
            while (tail.next != null) {
                tail = tail.next;
            }
            tail.next = currentNode;
        }

        return head;
    }
}
