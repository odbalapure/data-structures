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

    /*Remove a node and append it at the beginning of the list*/
    public static void appendNodeToFirst(int n) {
        Node<Integer> head = new Node<>(1);
        head.next = new Node<>(2);
        head.next.next = new Node<>(3);
        head.next.next.next = new Node<>(4);
        head.next.next.next.next = new Node<>(5);

        if (head == null) {
            return;
        }

        Node<Integer> temp = head;
        for (int i=0; temp!=null && i<n-1; i++) {
            temp = temp.next;
        }

        Node<Integer> deleted = temp.next;
        Node<Integer> next = temp.next.next;
        temp.next = next;

        System.out.println("Deleted node was: " + deleted.data);
        deleted.next = head;
        head = deleted;
        LinkedList1.print(head);
    }

    /*Remove duplicates from a sorted list*/
    public static void removeDuplicates() {
        Node<Integer> head = new Node<>(1);
        head.next = new Node<>(2);
        head.next.next = new Node<>(2);
        head.next.next.next = new Node<>(4);
        head.next.next.next.next = new Node<>(4);
        head.next.next.next.next.next = new Node<>(4);

        Node<Integer> curr = head;
        while (curr != null) {
            Node<Integer> temp = curr;
            while (temp != null && temp.data == curr.data) {
                temp = temp.next;
            }

            curr.next = temp;
            curr = curr.next;
        }

        LinkedList1.print(head);
    }

    /*Check whether is linked list is a palindrome*/
    public static boolean isPalindrome() {
        Node<Integer> head = new Node<>(1);
        head.next = new Node<>(2);
        head.next.next = new Node<>(2);
        head.next.next.next = new Node<>(2);
        head.next.next.next.next = new Node<>(2);
        head.next.next.next.next.next = new Node<>(1);

        int counter = 0;
        int arr[] = new int[sizeOfLl(head)];

        Node<Integer> curr = head;
        while (curr != null) {
            arr[counter++] = curr.data;
            curr = curr.next;
        }

        Node<Integer> temp = head;
        for (int j=arr.length-1; j>=0; j--) {
            System.out.println(arr[j] +" | " + temp.data);
            if (arr[j] != temp.data) {
                return false;
            }
            temp = temp.next;
        }

        return true;
    }

    /*Append last N nodes to beginning*/
    public static void appendLastNToFirst() {
        int m = 3;
        Node<Integer> head = new Node<>(4);
        head.next = new Node<>(5);
        head.next.next = new Node<>(6);
        head.next.next.next = new Node<>(1);
        head.next.next.next.next = new Node<>(2);
        head.next.next.next.next.next = new Node<>(3);

        int count = countNodes(head);
        System.out.println("Total nodes in the list: " + count);

        if (count != m && m < count) {
            int skip = count - m;
            Node<Integer> curr = head, prev = null;

            // skip the nodes
            while (skip > 0) {
                prev = curr;
                curr = curr.next;
                skip--;
            }

            System.out.println("Head value: " + head.data);

            // change pointers
            prev.next = null;
            Node<Integer> tempHead = head;
            head = curr;

            // now connect the lists
            while (curr.next != null) {
                curr = curr.next;
            }

            curr.next = tempHead;
            LinkedList1.print(head);
        }
    }

    /*Get last N nodes*/
    public static Node<Integer> kthNodeFromLast(Node<Integer> head, int k) {
        Node<Integer> slow = head;
        Node<Integer> fast = head;
        // for k = 3; list => 1 2 3 | 4 5 6
        for (int i=0; i<k; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // slow pointer points to the nth node from last
        return slow;
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
        System.out.println("Delete node and append at beginning");
        appendNodeToFirst(3);
        System.out.println("####################################");
        System.out.println("Remove duplicates from a sorted linked list");
        removeDuplicates();
        System.out.println("####################################");
        System.out.println("Check for palindrome linked list");
        System.out.println("Is palindrome: " + isPalindrome());
        System.out.println("####################################");
        System.out.println("Remove last N nodes and append them to beginning");
        appendLastNToFirst();
        System.out.println("####################################");
    }

    /*Helper function to find the size of a linked list*/
    private static int size = 0;
    private static int sizeOfLl(Node<Integer> head) {
        Node<Integer> temp = head;
        while (temp != null) {
            temp = temp.next;
            size++;
        }
        return size;
    }

    /*Helper function to count nodes in linked list*/
    public static int countNodes(Node head) {
        if (head == null) {
            return 0;
        }

        return (1 + countNodes(head.next));
    }
}
