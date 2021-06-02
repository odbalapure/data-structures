package arrays;

import java.util.Arrays;

public class Arrays3 {

    public static void binarySearch() {
        int arr[] = { 1, 4, 5, 10, 20 , 35, 40 };
        int ele = 35;

        if (arr.length == 0) {
            System.out.println(ele + " found at index 0");
        }

        int s = 0;
        int e = arr.length - 1;

        while (s <= e) {
            int mid = (s + e)/2;
            if (arr[mid] > ele) {
                e = mid - 1;
            } else if (arr[mid] < ele){
                s = mid + 1;
            } else {
                System.out.println(ele + " found at index " + mid);
                break;
            }
        }
    }

    public static void selectionSort() {
        int arr[] = { 1,6,4,8,0,3 };
        int n = arr.length;

        // insert the element in ith position
        for (int i = 0; i < n - 1; i++) {
            int min = Integer.MAX_VALUE;
            int minIndex = -1;

            // find the minimum element
            for (int j = i; j < n; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    minIndex = j;
                }
            }

            // swap the minIndex element with ith position element
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }

        System.out.println(Arrays.toString(arr));
    }

    private static void bubbleSort() {
        int arr[] = { 1,6,4,8,0,3 };
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            // to avoid unnecessary comparisons
            // as the largest elements goes at the last
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(arr));
    }

    public static void insertionSort() {
        int arr[] = { 9,6,3,7,2,8,1,5 };
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            // insert ith element in the sorted array
            int j = i - 1;
            int temp = arr[i];
            while (j >= 0 && arr[j] > temp) {
                arr[j+1] = arr[j];
                j--;
            }
            // position of ith element will be j+1
            arr[j + 1] = temp;
        }

        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        System.out.println("####################################");
        System.out.println("Binary Search");
        binarySearch();
        System.out.println("####################################");
        System.out.println("Selection Sort");
        selectionSort();
        System.out.println("####################################");
        System.out.println("Bubble Sort");
        bubbleSort();
        System.out.println("####################################");
        System.out.println("Insertion Sort");
        insertionSort();
        System.out.println("####################################");
    }
}
