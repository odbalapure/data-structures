package priorityqueues;

import java.util.ArrayList;
import java.util.List;

public class PriorityQueue<T> {
    List<Element<T>> heap;

    public PriorityQueue() {
        heap = new ArrayList<>();
    }

    public void insert(T value, int priority) {
        Element<T> element = new Element<>(value, priority);
        heap.add(element);

        // we always insert an element at the last
        // then perform up heap-ify operation
        int childIndex = heap.size() - 1;
        int parentIndex = (childIndex-1) / 2;

        // if child index is 0 that means we are the top
        while (childIndex > 0) {
            if (heap.get(childIndex).priority < heap.get(parentIndex).priority) {
                Element<T> temp = heap.get(childIndex);
                heap.set(childIndex, heap.get(parentIndex));
                heap.set(parentIndex, temp);
            } else {
                return;
            }
        }
    }

    public T removeMin() {
        if (isEmpty()) {
            System.out.println("Queue is EMPTY...");
            return null;
        }

        Element<T> remove = heap.get(0);
        T ans = remove.value;

        heap.set(0, heap.get(heap.size()-1));
        heap.remove(heap.size()-1);

        int parentIndex = 0;
        int leftChildIndex = 2*parentIndex+1;
        int rightChildIndex = 2*parentIndex+2;

        while (leftChildIndex < heap.size()) {
            int minIndex = parentIndex;

            if (heap.get(leftChildIndex).priority < heap.get(minIndex).priority) {
                minIndex = leftChildIndex;
            }

            if (rightChildIndex < heap.size() &&
                    heap.get(rightChildIndex).priority < heap.get(minIndex).priority) {
                minIndex = rightChildIndex;
            }

            if (minIndex == parentIndex) {
                break;
            }

            Element<T> temp = heap.get(minIndex);
            heap.set(minIndex, heap.get(parentIndex));
            heap.set(parentIndex, temp);
            parentIndex = minIndex;

            leftChildIndex = 2*parentIndex+1;
            rightChildIndex = 2*parentIndex+2;
        }

        return ans;
    }

    public T getMin() {
        if (isEmpty()) {
            System.out.println("Heap is EMPTY!");
            return null;
        }

        return heap.get(0).value;
    }

    public int size() {
        return heap.size();
    }

    public boolean isEmpty() {
        return heap.size() == 0;
    }

    public static void main(String[] args) {
        PriorityQueue<String> pq = new PriorityQueue<>();
        pq.insert("abc", 15);
        pq.insert("def", 13);
        pq.insert("fsas", 90);
        pq.insert("fsasfsas", 150);
        pq.insert("xvzxvzaed", 120);

        while (!pq.isEmpty()) {
            System.out.println(pq.getMin());
            pq.removeMin();
        }
    }
}
