package stack;

import java.util.Arrays;

public class StackUsingArray {

    private int data[];
    private int topIndex;

    public StackUsingArray() {
        data = new int[10];
        topIndex = -1;
    }

    public StackUsingArray(int size) {
        data = new int[size];
        topIndex = -1;
    }

    public int size() {
        return topIndex + 1;
    }

    public boolean isEmpty() {
        return topIndex == -1;
    }

    public void push(int ele) throws StackFullException {
        if (topIndex == data.length - 1) {
            // throw new StackFullException("STACK IS FULL!");
            doubleCapacity();
        }

        data[++topIndex] = ele;
    }

    public int pop() throws StackEmptyException {
        if (topIndex == -1) {
            throw new StackEmptyException("STACK IS EMPTY!");
        }

        int ele = data[topIndex--];
        return ele;
    }

    public int top() throws StackEmptyException {
        if (topIndex == -1) {
            throw new StackEmptyException("STACK IS EMPTY!");
        }

        return data[topIndex];
    }

    private void doubleCapacity() {
        System.out.println("Stack is full, doubling the stack size...");
        int temp[] = data;
        data = new int[2 * temp.length];

        for (int i=0; i<temp.length; i++) {
            data[i] = temp[i];
        }
    }

    public static void main(String[] args) throws StackFullException, StackEmptyException {
        StackUsingArray stack = new StackUsingArray(5);
        System.out.println("####################################");
        System.out.println("-- Implement a stack using array -- ");
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(4);
        stack.push(4);
        System.out.println("Is stack empty: " + stack.isEmpty());
        System.out.println("Stack size: " + stack.size());
        System.out.println("Top element: " + stack.top());
        System.out.println("Popped element: " + stack.pop());
        System.out.println("Top element: " + stack.top());
        System.out.println("####################################");
    }

}
