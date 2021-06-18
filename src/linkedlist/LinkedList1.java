package linkedlist;

import java.util.Scanner;

public class LinkedList1 {

    public static Node<Integer> createLinkedList() {
        Node<Integer> head = new Node<>(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);

        /*
        * Another way of linking nodes
        * n1.next = n2;
        * n2.next = n3;
        * n3.next = n4;
        * */

        return head;
    }

    /*Print the linked list*/
    public static void print(Node<Integer> head){
        Node<Integer> temp = head;
        while(temp != null){
            System.out.print(temp.data +" ");
            temp = temp.next;
        }
        System.out.println();
    }

    /*Increment every node value*/
    public static void incrementNodeValue(Node<Integer> head){
        Node<Integer> temp = head;
        while(temp != null){
            temp.data++;
            temp = temp.next;
        }

        print(head);
    }

    /*Find length of linked list*/
    public static void lengthOfLl(Node head) {
        int count = 0;
        Node<Integer> temp = head;
        while (temp != null) {
            temp = temp.next;
            count++;
        }
        System.out.println("Length of linked list: " + count);
    }

    /*print ith node of a linked list*/
    public static void printIthNode(Node<Integer> head, int i){
        if (head == null) {
            return;
        }

        int index = 0;
        Node<Integer> temp = head;
        while (temp != null) {
            if (index == i) {
                System.out.println("Index of " + temp.data  + " is: "  + index);
                return;
            }
            temp = temp.next;
            index++;
        }
    }

    /*Append a node at last by iterating a list*/
    public static Node<Integer> appendAtLast() {
        Scanner sc = new Scanner(System.in);
        int data = sc.nextInt();
        Node<Integer> head = null;

        while (data != -1) {
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

            data = sc.nextInt();
        }

        return head;
    }

    /*Append a node at last - using tail*/
    public static Node<Integer> appendAtLastOptimized() {
        Scanner sc = new Scanner(System.in);
        int data = sc.nextInt();
        Node<Integer> head = null, tail = null;

        while (data != -1) {
            Node<Integer> currentNode = new Node<>(data);
            if (head == null) {
                // checking if the node is the first node
                head = currentNode;
                tail = currentNode;
            } else {
                // start appending nodes at the end
                tail.next = currentNode;
                tail = tail.next;
                // tail = currentNode;
            }

            data = sc.nextInt();
        }

        return head;
    }

    /*Insert a node at beginning*/
    public static void insertNodeAtBeginning(Node head, int data) {
        Node<Integer> node = new Node(data);
        node.next = head;
        head = node;

        print(head);
    }

    /*Insert a node at a particular index*/
    public static void insertAtIndex(Node<Integer> head, int ele, int pos) {
        Node<Integer> nodeToInsert = new Node<>(ele);

        int count = 0;
        Node<Integer> prev = head;
        while (count < pos - 1) {
            prev = prev.next;
            count++;
        }

        nodeToInsert.next = prev.next;
        prev.next = nodeToInsert;

        print(head);
    }

    public static void main(String[] args) {
        Node<Integer> node = new Node<Integer>(10);
        node.next = new Node<>(20);
        node.next.next = new Node<>(30);
        node.next.next.next = new Node<>(40);
        node.next.next.next.next = new Node<>(50);
        node.next.next.next.next.next = new Node<>(60);

        System.out.println("####################################");
        System.out.println("Print List");
        print(node);
        System.out.println("####################################");
        System.out.println("Increment every node value");
        incrementNodeValue(node);
        System.out.println("####################################");
        System.out.println("Length of the List");
        lengthOfLl(node);
        System.out.println("####################################");
        System.out.println("Print ith Node");
        printIthNode(node, 4);
        System.out.println("####################################");
        System.out.println("Append node at the last");
        Node<Integer> head = appendAtLastOptimized();
        print(head);
        System.out.println("####################################");
        System.out.println("Insert node at beginning");
        insertNodeAtBeginning(head, 1000);
        System.out.println("####################################");
        System.out.println("Insert ath ith index");
        insertAtIndex(head, 100, 2);
        System.out.println("####################################");
    }

}
