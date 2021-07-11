package priorityqueues;

import java.util.PriorityQueue;

public class PriorityQueue1 {

    public static void kLargest() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int arr[] = {4,1,6,3,7,2,9,8};
        int k = 3;

        for (int i=0; i<k; i++) {
            pq.add(arr[i]);
        }

        for (int i=k; i<arr.length; i++) {
            // compare the first element of the queue with array element
            // in min priority queue the smallest element is at the 0th index
            if (pq.peek() < arr[i]) {
                pq.poll();
                pq.add(arr[i]);
            }
        }

        while (!pq.isEmpty()) {
            System.out.print(pq.poll() +" ");
        }

        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("####################################");
        System.out.println("Print k largest elements");
        kLargest();
        System.out.println("####################################");
    }
}
