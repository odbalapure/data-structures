package queue;

public class QueueUsingArray {

    private int[] data;
    private int front;
    private int rear;
    private int size;

    public QueueUsingArray() {
        data = new int[5];
        front = rear = -1;
    }

    public QueueUsingArray(int size) {
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
        // set FRONT to 0 after an enqueue opeartion
        if (size == 0 || front == -1) {
            front = 0;
        }

        // elements are inserted at REAR end
        // increment REAR by 1 after an enqueue operation
        rear++;
        data[rear] = ele;
        size++;
    }

    /*Delete an element from a queue*/
    public int dequeue() {
        if (size == 0) {
            System.out.println("Queue is empty, cannot deque...");
            front = -1;
            rear = -1;

            return Integer.MIN_VALUE;
        }

        int temp = data[front];
        front++;
        size--;

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
        QueueUsingArray queue = new QueueUsingArray(5);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);

        System.out.println("Dequeued element: " + queue.dequeue());
        System.out.println("Front element: " + queue.front());
    }
}
