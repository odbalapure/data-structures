package queue;

public class CircularQueueUsingArray {

    private int[] data;
    private int front;
    private int rear;
    private int size;

    public CircularQueueUsingArray() {
        data = new int[5];
        front = rear = -1;
    }

    public CircularQueueUsingArray(int size) {
        data = new int[size];
        front = rear = -1;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /*Add an element to a queue*/
    public void enqueue(int ele) {
        // queue is full, enqueue operation not possible
        if (size == data.length) {
            System.out.println("The queue is FULL, returning...");
            return;
        }

        // queue is empty, FRONT is -1
        // set FRONT to 0 after an enqueue operation
        if (size == 0) {
            front = 0;
        }

        // elements are inserted at the REAR end
        // increment REAR by 1 after an enqueue operation
        rear++;

        // ** if we reach the end, set REAR to 0
        if (rear == data.length) {
            rear = 0;
        }

        // rear = (rear + 1) % data.length;

        data[rear] = ele;
        size++;
    }

    /*Delete an element from a queue*/
    public int dequeue() {
        if (size == 0) {
            System.out.println("Queue is empty, cannot deque...");
            return Integer.MIN_VALUE;
        }

        int temp = data[front];

        front++;
        if (front == data.length) {
            front = 0;
        }

        size--;
        if (front == data.length) {
            front = 0;
        }

        if (size == 0) {
            front = -1;
            rear = -1;
        }

        return temp;
    }

    /*Return the first element from the queue*/
    public int front() {
        if (size == 0) {
            System.out.println("Queue is empty!");
            return Integer.MIN_VALUE;
        }

        return data[front];
    }



    public static void main(String[] args) {
        CircularQueueUsingArray queue = new CircularQueueUsingArray(5);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);

        System.out.println("Dequeued element: " + queue.dequeue());
        System.out.println("Front element: " + queue.front());
    }
}
