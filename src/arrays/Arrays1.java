package arrays;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Arrays1 {

    /* print all pairs in an array */
    public static void printAllPairs() {
        int arr[] = { 1, 4, 7, 6, 5 };
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                System.out.println("(" + arr[i] + ", " + arr[j] + ")");
            }
        }
    }

    /* find unique element using loop */
    public static void findUniqueLoop() {
        int arr[] = { 1, 4, 6, 1, 7, 6, 1, 5, 5 };
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int j;
            for (j = 0; j < n; j++) {
                if (i != j && arr[i] == arr[j]) {
                    break;
                }
            }

            if (j == n) {
                System.out.println(arr[i]);
            }
        }
    }

    /* find unique element using XOR */
    public static void findUniqueXor() {
        int arr[] = { 1, 4, 6, 1, 7, 6, 5, 5, 7 };
        int n = arr.length;
        int uniqueNumber = 0;

        for (int i = 0; i < n; i++) {
            uniqueNumber ^= arr[i];
        }

        if (uniqueNumber > 0) {
            System.out.println("The unique number in this array is: " + uniqueNumber + ".");
            return;
        }

        System.out.println("No unique number present in this array...");
    }

    /* Find duplicate element in an array */
    public static void findDuplicate() {
        int arr[] = { 1, 4, 7, 6, 5 };
        int duplicateElement = 0;
        boolean hasDuplicate = false;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    duplicateElement = arr[i];
                    hasDuplicate = true;
                    break;
                }
            }
        }

        if (hasDuplicate) {
            System.out.println("The duplicate element is: " + duplicateElement + ".");
            return;
        }

        System.out.println("No duplicates found in this array.");
    }

    public static void containsDuplicate() {
        int arr[] = { 1, 4, 7, 6, 5, 4 };
        int n = arr.length;
        int duplicateElement = 0;
        boolean hasDuplicate = false;

        Arrays.sort(arr);

        for (int i=0; i<n-1; i++) {
            if (arr[i] == arr[i+1]) {
                duplicateElement = arr[i];
                hasDuplicate = true;
                break;
            }
        }

        if (hasDuplicate) {
            System.out.println("The duplicate element is: " + duplicateElement + ".");
            return;
        }

        System.out.println("No duplicates found in this array.");
    }

    public static void main(String[] args) {
        System.out.println("####################################");
        System.out.println("All possible pairs in this array");
        printAllPairs();
        System.out.println("####################################");
        System.out.println("Print unique element - naive");
        findUniqueLoop();
        System.out.println("####################################");
        System.out.println("Print unique element - XOR");
        findUniqueXor();
        System.out.println("####################################");
        System.out.println("Duplicate element in an array");
        findDuplicate();
        containsDuplicate();
        System.out.println("####################################");
    }
}