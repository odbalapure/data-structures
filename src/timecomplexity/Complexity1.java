package timecomplexity;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Complexity1 {

    /*
    * Lets say the sorting algorithm complexities are
    * Arrays.sort() uses Quick Sort, complexity: O(n * log n)
    * - for 1st array n * log n
    * - for 2nd array m * log m
    *
    * The comparison will take O ( n ) and O ( m ) time
    * So we have - n * log n + m * log m + n + m
    * Time Complexity will be => O ( n * log n + m * log m )
    *
    * */
    public static void intersection() {
        int a[] = {7, 1, 5, 2, 3, 6};
        int b[] = {3, 8, 6, 20, 7};
        int i = 0, j = 0;
        int n = a.length, m = b.length;

        Arrays.sort(a);
        Arrays.sort(b);

        while (i < n && j < m) {
            if (a[i] > b[j]) {
                j++;
            } else if (a[i] < b[j]) {
                i++;
            } else {
                System.out.print(a[i] + " ");
                i++;
                j++;
            }
        }
        System.out.println();
    }

    /*
    * There is another better approach for the above solution
    * Do a linear search on first array
    * Do binary search on the second array
    *
    * NOTE: Its better to sort the smaller array (for for binary search)
    *
    * Time complexity will: O ( m * log n +  n * log n )
    * This approach is NOT much optimized but will perform little better
    *
    * We are sorting smaller array because less operations will be required
    *
    * */
    public static void intersectionOptimized() {
        int arr1[] = {7, 1, 5, 2, 3, 6};
        int arr2[] = {3, 8, 6, 20, 7, 100, 11};

        // We will sort the smaller array
        if (arr1.length > arr2.length) {
            System.out.println("Sorting 2nd array...");
            Arrays.sort(arr2);
            for (int i=0; i<arr1.length; i++) {
                binarySearch(arr2, arr1[i]);
            }
        } else if (arr1.length < arr2.length) {
            System.out.println("Sorting 1st array...");
            Arrays.sort(arr1);
            for (int i=0; i<arr2.length; i++) {
                binarySearch(arr1, arr2[i]);
            }
        } else {
            // sort any one array
            System.out.println("Sorting any one of the arrays");
            Arrays.sort(arr2);
            for (int i=0; i<arr1.length; i++) {
                binarySearch(arr2, arr1[i]);
            }
        }

        System.out.println();
    }

    private static void binarySearch(int[] arr, int x) {
        int s = 0;
        int e = arr.length - 1;

        while (s <= e) {
            int mid = (s + e)/2;
            if (arr[mid] > x) {
                e = mid - 1;
            } else if (arr[mid] < x){
                s = mid + 1;
            } else {
                System.out.print(arr[mid] + " ");
                return;
            }
        }
    }

    public static void findEquilibriumSum() {
        int arr[] = { 1, 3, 4, 2, 2, 5, 4, 1 };
        int leftSum, rightSum;
        int i = 0, j = 0;

        for (i=0; i<arr.length; i++) {
            // finding left sum
            leftSum = 0;
            for (j=0; j<i; j++) {
                leftSum += arr[j];
            }

            // finding right sum
            rightSum = 0;
            for (j=i+1; j<arr.length; j++) {
                rightSum += arr[j];
            }

            if (leftSum == rightSum) {
                System.out.println(leftSum +" == " + rightSum);
                System.out.println("Equilibrium SUM found, returning now...");
                return;
            }
        }
    }

    /*
    * Time complexity => O ( n )
    *
    * There will be some constant work at each index
    *
    * Doing some k1 * n work for finding right sum
    * Doing some k2 * n work for finding left sum
    *
    * */
    public static int findEquilibriumSumOptimized() {
        int arr[] = { 1, 3, 4, 2, 2, 5, 4, 1 };
        int totalSum = 0;
        int leftSum = 0;

        for (int num : arr) {
            totalSum += num;
        }

        for (int i=0; i<arr.length; i++) {
            totalSum -= arr[i];

            if (leftSum == totalSum) {
                System.out.println(leftSum + " == " + totalSum);
                System.out.println("Equilibrium SUM found, returning now...");
                return leftSum;
            }

            leftSum += arr[i];
        }

        return -1;
    }

    public static void main(String[] args) {

        System.out.println("####################################");
        System.out.println("Intersection of 2 arrays");
        intersection();
        System.out.println("------------------------------------");
        intersectionOptimized();
        System.out.println("####################################");
        System.out.println("Find equilibrium sum in an array");
        findEquilibriumSum();
        System.out.println("------------------------------------");
        findEquilibriumSumOptimized();
        System.out.println("####################################");

    }
}
