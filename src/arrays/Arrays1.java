package arrays;

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
        int arr[] = { 1, 4, 6, 1, 7, 6, 5, 5 };
        int n = arr.length;
        boolean hasUnique = false;
        int uniqueNumber = 0;

        Arrays.sort(arr);

        for (int i = 0; i < n - 1; i += 2) {
            if (arr[i] != arr[i + 1]) {
                uniqueNumber = arr[i];
                hasUnique = true;
                break;
            }
        }

        if (hasUnique) {
            System.out.println(uniqueNumber + " is a unique number.");
            return;
        }

        System.out.println("No unique numbers present in this array...");
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

        System.out.println("No unqiue number present in this array...");
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
        System.out.println("####################################");
    }
}