package arrays;

import java.util.Arrays;

public class Arrays2 {

    /* Find intersection of two arrays */
    public static void findIntersection() {
        int arr1[] = { 1, 2, 4, 5, 6 };
        int arr2[] = { 2, 3, 5, 7 };

        int n = arr1.length;
        int m = arr2.length;

        int i = 0;
        int j = 0;

        while (i < n && j < m) {
            if (arr1[i] < arr2[j]) {
                i++;
            } else if (arr2[j] < arr1[i]) {
                j++;
            } else {
                System.out.println(arr1[i]);
                i++;
                j++;
            }
        }
    }

    /* Pair sum in an array - Brute Force */
    public static void pairSumBrute() {
        int arr[] = { 1, 4, 45, 6, 10, -8 };
        int sum = 16;
        int n = arr.length;

        for (int i = 0; i < n-1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] + arr[j] == sum) {
                    System.out.println(arr[i] + " + " + arr[j] + " = " + sum);
                }
            }
        }
    }

    /* Pair sum in array - Optimized */
    public static void pairSumOptimized() {
        int arr[] = { 1, 5, 7, -1, 5 };
        int sum = 6;
        int n = arr.length;

        Arrays.sort(arr);

        int l = 0;
        int r = n - 1;

        while (l < r) {
            if (arr[l] + arr[r] == sum) {
                System.out.println(arr[l] + " + " + arr[r] + " = " + sum);
                l++;
                r--;
            } else if (arr[l] + arr[r] > sum) {
                r++;
            } else {
                l++;
            }
        }
    }

    /* Triplet sum in an array */
    public static void tripletSum() {
        int[] arr = new int[] { 0, -1, 2, -3, 1 };
        int sum = -2;
        int n = arr.length;

        Arrays.sort(arr);

        for (int i = 0; i < n; i++) {
            int l = i + 1;
            int r = n - 1;
            int x = arr[i];
            while (l < r) {
                if (arr[l] + arr[r] + x == sum) {
                    System.out.println(arr[l] + " + " + arr[r] + " + " + x + " = " + sum);
                    l++;
                    r--;
                } else if (arr[l] + arr[r] + x < sum) {
                    l++;
                } else {
                    r--;
                }
            }
        }
    }

    /* Sort 0s and 1s */
    public static void sortZeroOne() {
        int arr[] = { 0, 1, 1, 0, 1, 0, 1 };
        int counter = 0;
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                arr[counter++] = 0;
            }
        }

        while (counter < n) {
            arr[counter++] = 1;
        }

        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        System.out.println("####################################");
        System.out.println("Intersection of two arrays");
        findIntersection();
        System.out.println("####################################");
        System.out.println("Pair sum - Brute Force");
        pairSumBrute();
        System.out.println("####################################");
        System.out.println("Pair sum - Optimized");
        pairSumOptimized();
        System.out.println("####################################");
        System.out.println("Triple sum");
        tripletSum();
        System.out.println("####################################");
        System.out.println("Sorted 0s and 1s array");
        sortZeroOne();
        System.out.println("####################################");
    }
}
