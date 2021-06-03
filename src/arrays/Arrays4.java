package arrays;

import java.util.Arrays;

public class Arrays4 {

    public static void pushZerosToEnd() {
        int arr[] = {1,4,0,0,5,8,0,9,10,15,0};
        int n = arr.length;
        int counter = 0;

        for (int i=0; i<n; i++) {
            if (arr[i] != 0) {
                arr[counter++] = arr[i];
            }
        }

        for (int i=counter; i<n; i++) {
            arr[counter++] = 0;
        }

        System.out.println(Arrays.toString(arr));
    }

    public static void sortOneZeroTwo() {
        int arr[] = {2,1,1,0,2,2,0,0,0,1,0,0,0};
        int n = arr.length;
        int zero = 0;
        int one = 0;

        // count the occurrences of 0s and 1s
        for (int i=0; i<n; i++) {
            if (arr[i] == 0) {
                zero++;
            }
            if (arr[i] == 1) {
                one++;
            }
        }

        // push in 0s
        for (int i=0; i<zero; i++) {
            arr[i] = 0;
        }
        // push in 1s
        for (int i=zero; i<one+zero; i++) {
            arr[i] = 1;
        }
        // push 2s in remaining spaces
        for (int i=zero+one; i<n; i++) {
            arr[i] = 2;
        }

        System.out.println(Arrays.toString(arr));
    }

    public static void addTwoArrays() {
        int a[] = { 9, 3, 9 };
        int b[] =    { 6, 1 };
        int n = a.length;
        int m = b.length;

        // array to store sum.
        int[] sum = new int[n];

        int i = n - 1, j = m - 1, k = n - 1;

        int carry = 0, s = 0;

        // Until we reach beginning of array.
        // we are comparing only for second
        // array because we have already compare
        // the size of array in wrapper function.
        while (j >= 0) {
            // find sum of corresponding element
            // of both array.
            s = a[i] + b[j] + carry;
            sum[k] = (s % 10);

            // Finding carry for next sum.
            carry = s / 10;
            k--;
            i--;
            j--;
        }
        System.out.println(carry);

        // If second array size is less
        // the first array size.
        while (i >= 0) {
            // Add carry to first array elements.
            s = a[i] + carry;
            sum[k] = (s % 10);
            carry = s / 10;

            i--;
            k--;
        }
        System.out.println(carry);

        int ans = 0;

        // If there is carry on adding 0 index
        // elements  append 1 to total sum.
        if (carry == 1)
            ans = 10;

        // Converting array into number.
        for (i = 0; i <= n - 1; i++) {
            ans += sum[i];
            ans *= 10;
        }

        System.out.println("Sum: " + ans/10);
    }

    public static void rotateArrayRight() {
        int arr[] = { 1, 2, 3, 8, 9, 10 };
        int k = 3;
        int j = 0;

        while (k > 0) {
            // get the last element
            int temp = arr[arr.length - 1];
            for (j = arr.length-1; j > 0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = temp;
            k--;
        }

        System.out.println(Arrays.toString(arr));
    }

    // time complexity: O ( N * K )
    // space complexity: O ( 1 )
    public static void rotateArrayLeft() {
        int arr[] = {1, 2, 3, 8, 9, 10};
        int k = 1;
        int j = 0;

        while (k > 0) {
            int temp = arr[0];
            for (j = 0; j < arr.length - 1; j++) {
                arr[j] = arr[j + 1];
            }
            arr[j] = temp;
            k--;
        }

        System.out.println(Arrays.toString(arr));
        System.out.println(countRightRotations(arr, arr.length));
    }

    public static int countRightRotations(int arr[], int n) {
        int min = Integer.MAX_VALUE, min_index = -1;
        for (int i = 0; i < n; i++)
        {
            if (min > arr[i])
            {
                min = arr[i];
                min_index = i;
            }
        }
        return min_index;
    }

    public static void secondLargest() {
        int arr[] = { -1, 7, 1, 34, 18 };
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        for (int i=0; i<arr.length; i++) {
            if (arr[i] > largest) {
                secondLargest = largest;
                largest = arr[i];
            }

            if (arr[i] != largest && arr[i] > secondLargest) {
                secondLargest = arr[i];
            }
        }

        System.out.println("Largest: " + largest);
        System.out.println("Second Larges: " + secondLargest);
    }

    public static void main(String[] args) {
        System.out.println("####################################");
        System.out.println("Push 0s to end");
        pushZerosToEnd();
        System.out.println("####################################");
        System.out.println("Sort 0s, 1s and 2s");
        sortOneZeroTwo();
        System.out.println("####################################");
        System.out.println("Add 2 arrays");
        addTwoArrays();
        System.out.println("####################################");
        System.out.println("Rotate array to right");
        rotateArrayRight();
        System.out.println("####################################");
        System.out.println("Rotate array to left");
        rotateArrayLeft();
        System.out.println("####################################");
        System.out.println("Find second largest");
        secondLargest();
        System.out.println("####################################");
    }
}