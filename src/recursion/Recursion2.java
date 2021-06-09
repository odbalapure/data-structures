package recursion;

public class Recursion2 {

    /*Check if an array is sorted*/
    public static boolean isArraySorted(int arr[]) {
        // this is our EXIT condition
        if (arr.length == 1) {
            return true;
        }

        if (arr[0] > arr[1]) {
            return false;
        }

        int smallArr[] = new int[arr.length - 1];
        for (int i=1; i<arr.length; i++) {
            smallArr[i - 1] = arr[i];
        }

        boolean isSorted = isArraySorted(smallArr);
        return isSorted;
    }

    /*Check if an array is sorted - optimized*/
    public static boolean isArraySortedOptimized(int arr[], int si) {
        // this is our EXIT condition
        if (si == arr.length - 1) {
            return true;
        }

        if (arr[si] > arr[si + 1]) {
            return false;
        }

        boolean isSorted = isArraySortedOptimized(arr, si + 1);
        return isSorted;
    }

    /*Find the sum of elements of an array*/
    public static int sumArray(int arr[]) {
        // Remove 1st element from the array
        int sum = arr[0];

        if (arr.length == 0) {
            return 0;
        }

        // this is our EXIT condition
        if (arr.length == 2) {
            return arr[0] + arr[1];
        }

        int small[] = new int[arr.length - 1];
        for (int i=1; i<arr.length; i++) {
            // We have first element inside sum
            // now create a copy of arr[] w/o first elements
            small[i - 1] = arr[i];
        }

        sum += sumArray(small);
        return sum;
    }

    /*Check if a number is present in an array*/
    public static boolean findNumber(int arr[], int x) {
        if (arr.length == 0) {
            return false;
        }

        // this is our EXIT condition
        if (arr[0] == x) {
            // if x is present at first index
            return true;
        }

        if (arr[arr.length - 1] == x) {
            // if x is present at last index
            return true;
        }

        int small[] = new int[arr.length - 1];
        for (int i=1; i<arr.length; i++) {
            small[i - 1] = arr[i];
        }

        boolean isPresent = findNumber(small, x);
        return isPresent;
    }

    /*Find the first index of an element in an array*/
    public static int firstIndexOfElement(int arr[], int x) {
        if (arr.length == 0) {
            return -1;
        }

        // this is out EXIT condition
        if (arr[0] == x) {
            return 0;
        }

        int small[] = new int[arr.length - 1];
        for (int i=1; i<arr.length; i++) {
            small[i - 1] = arr[i];
        }

        int fi = firstIndexOfElement(small, x);
        if (fi == -1) {
            return -1;
        } else {
            return fi + 1;
        }
    }

    /*Find first index of element - optimized*/
    public static int firstIndexOfElementOptimized(int arr[], int x, int si) {
        if (si == arr.length) {
            return -1;
        }

        if (arr[si] == x) {
            return si;
        }

        int k = firstIndexOfElementOptimized(arr, x, si + 1);
        return  k;
    }

    /*Find last index of an element in an array*/
    public static int lastIndexOfElement(int arr[], int x) {
        // our main EXIT condition
        if (arr.length == 0) {
            return -1;
        }

        // we will check from the last not form the beginning
        // hence not checking this condition
        /*
        * if (arr[0] == x) {
        *   return 0;
        * }
        * */
        int small[] = new int[arr.length - 1];
        for (int i=1; i<arr.length; i++) {
            small[i - 1] = arr[i];
        }

        int k = lastIndexOfElement(small, x);
        if (k != -1) {
            return k + 1;
        } else {
            // x not found so we check at the very beginning
            if (arr[0] == x) {
                return 0;
            } else {
                return -1;
            }
        }
    }

    public static int lastIndexOfElementOptimized(int arr[], int x, int si) {
        // our main EXIT condition
        if (si == arr.length - 1) {
            return -1;
        }

        int k = lastIndexOfElementOptimized(arr, x, si + 1);
        if (k != -1) {
            return k;
        } else {
            if (arr[si] == x) {
                return si;
            } else {
                return -1;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("####################################");
        int arr[] = {1,2,3,4,5};
        System.out.println("Is array sorted? " + isArraySorted(arr));
        System.out.println("####################################");
        System.out.println("Is array sorted - optimized: " + isArraySortedOptimized(arr, 0));
        System.out.println("####################################");
        System.out.println("Sum of the elements of array: "  + sumArray(arr));
        System.out.println("####################################");
        System.out.println("Is element present in the array? " + findNumber(arr, 10));
        System.out.println("####################################");
        int arr1[] = {3,7,5,9,7,6,5};
        System.out.println("First first index of an element: " + firstIndexOfElement(arr1, 5));
        System.out.println("First first index of an element - optimized: " + firstIndexOfElementOptimized(arr1, 5, 0));
        System.out.println("####################################");
        System.out.println("Find last index of an element: " + lastIndexOfElement(arr1, 5));
        System.out.println("Find last index of an element - optimized: " + lastIndexOfElementOptimized(arr1, 5, 0));
        System.out.println("####################################");
    }
}
