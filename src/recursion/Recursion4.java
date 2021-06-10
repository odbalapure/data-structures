package recursion;

import java.util.Arrays;

public class Recursion4 {

    /*Binary search*/
    public static int binarySearch(int arr[], int si, int ei, int x) {
        // main EXIT condition
        if (si > ei) {
            return -1;
        }

        int mid = (si + ei) / 2;
        if (arr[mid] == x) {
            return mid;
        } else if (arr[mid] < x) {
            return binarySearch(arr, mid + 1, ei, x);
        } else {
            return binarySearch(arr, si, mid - 1, x);
        }
    }

    /*Merge sort*/
    public static void mergerSort(int a[]) {
        if (a.length <= 1) {
            return;
        }

        int b[] = new int[a.length/2];
        int c[] = new int[a.length - b.length];

        // create 1st array
        for (int i=0; i<a.length/2; i++) {
            b[i] = a[i];
        }

        // create 2nd array
        for (int i=a.length/2; i<a.length; i++) {
            c[i - a.length/2] = a[i];
        }

        mergerSort(b);
        mergerSort(c);
        merge(b, c, a);
    }

    // combine 2 sorted arrays and created third final sorted array
    private static void merge(int[] s1, int [] s2, int[] d) {
        int i = 0, j = 0, k = 0;
        while (i < s1.length && j < s2.length) {
            if (s1[i] <= s2[j]) {
                d[k++] = s1[i++];
            } else {
                d[k++] = s2[j++];
            }
        }

        // copy remaining elements left in s1
        // we have some space if i != s1.length
        if (i < s1.length) {
            while (i < s1.length) {
                d[k++] = s1[i++];
            }
        }

        // copy remaining elements left in s2
        // we have some space if j != s2.length
        if (j < s2.length) {
            while (j < s2.length) {
                d[k++] = s2[j++];
            }
        }
    }

    /*Quick Sort*/
    public static void quickSort(int[] a, int si, int ei) {
        if (si >= ei) {
            return;
        }

        int pivotIndex = partition(a, si, ei);
        quickSort(a, si, pivotIndex - 1);
        quickSort(a, pivotIndex + 1, ei);
    }

    /*Helper function to find the pivot point in quick sort*/
    private static int partition(int[] a, int si, int ei) {
        int pivotElement = a[0];
        int smallerNumCount = 0;

        for (int i=si+1; i<=ei; i++) {
            if (a[i] < pivotElement) {
                smallerNumCount++;
            }
        }

        int temp = a[si + smallerNumCount];
        a[si + smallerNumCount] = pivotElement;
        a[si] = temp;

        int i = si;
        int j = ei;

        while (i < j) {
            if (a[i] < pivotElement) {
                i++;
            } else if (a[j] >= pivotElement) {
                j--;
            } else {
                temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i++; j--;
            }
        }
        return si + smallerNumCount;
    }

    public static void towerOfHanoi(int n, char s, char h, char d) {
        if (n == 1) {
            System.out.println("Move 1st disk from " + s + " to " + d);
            return;
        }

        towerOfHanoi(n - 1, s, d, h);
        System.out.println("Move " + n  + "th disk from " + s + " to " + d);
        towerOfHanoi(n - 1, h, s, d);
    }

    public static void main(String[] args) {
        System.out.println("####################################");
        int arr[] = {1,2,3,4,5};
        System.out.println("Binary Search");
        System.out.println("The element is present at index: " + binarySearch(arr, 0, 4, 10));
        System.out.println("####################################");
        int arr1[] = { 2, 1, 0, 11, 99, 20, 21, 32, 10 };
        System.out.println("Merge Sort");
        mergerSort(arr1);
        System.out.println(Arrays.toString(arr1));
        System.out.println("####################################");
        System.out.println("Quick Sort");
        quickSort(arr1, 0, arr.length-1);
        System.out.println(Arrays.toString(arr1));
        System.out.println("####################################");
        System.out.println("Tower of Hanoi");
        towerOfHanoi(3, 's', 'h', 'd');
        System.out.println("####################################");
    }
}
