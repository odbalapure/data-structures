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

    public void enqueue(int ele) {
        if (size == data.length) {
            System.out.println("Queue is FULL!");
            return;
        }

        if (size == 0) {
            front = 0;
        }

        rear++;
        /*Condition to make a circular queue*/
        if (rear == data.length) {
            rear = 0;
        }

        data[rear] = ele;
        size++;
    }

    public int front() {
        if (size == 0) {
            System.out.println("Queue is empty!");
            return -1;
        }

        return data[front];
    }

    public int dequeue() {
        if (size == 0) {
            System.out.println("Size if zero, cannot deque...");
            return -1;
        }

        if (size == 0) {
            front = rear = -1;
        }

        int temp = data[front];
        front++;
        size--;

        return temp;
    }

    public static void main(String[] args) {
        int num = 25, n = 5;
        int temp_num;
        for(int i=2;i<=num/2;++i)
        {
            temp_num=1;
            for(int j=1;j<=n;++j)
                temp_num*=i;
            if(temp_num==num) {
                System.out.println("nth Root: " + i);
                break;
            }

        }
    }
}
