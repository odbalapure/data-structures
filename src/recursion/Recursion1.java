package recursion;

/*
* Principle: A function calls itself but for a smaller value
*
* NOTE: If an answer to a problem depends upon a smaller answer
* of similar nature, then we can use recursion.
*
* PMI says that if we have a 'F' which is true for all natural numbers
* Task 1: then first prove f(0) and f(1) is true
*
* Assume middle one is true i.e f(k) is ture
*
* Task 2: prove that f(k + 1) is true
*
* */

import java.security.PublicKey;

public class Recursion1 {

    /*
    * We are using recursion here because we know when to stop
    * and most importantly we know the smallest possible answer
    * for eg: factorial where 0! = 1
    * */
    public static int fact(int n) {
        if (n == 0) {
            return 1;
        }

        int smallOutput = fact(n - 1);
        int output = n * smallOutput;
        return output;
    }

    public static int sumUpToN(int n) {
        if (n == 0) {
            return 0;
        }

        // Σ n = n + Σ n - 1
        int smallSum = sumUpToN(n - 1);
        int sum = n + smallSum;
        return sum;
    }

    public static int power(int x, int n) {
        if (n == 0) {
            return 1;
        }

        int smallOutput = power(x, n - 1);
        int power = x * smallOutput;
        return power;
    }

    public static int countDigit(int n) {
        if (n == 0) {
            return 0;
        }

        return 1 + countDigit(n/10);
    }

    public static void printNumbers(int n) {
        if (n == 0) {
            return;
        }

        printNumbers(n - 1);
        System.out.print(n + " ");
    }

    public static void main(String[] args) {
        System.out.println("####################################");
        System.out.println("Factorial: " + fact(5));
        System.out.println("####################################");
        System.out.println("Sum up to n numbers: " + sumUpToN(100));
        System.out.println("####################################");
        System.out.println("Power of n: " + power(2, 4));
        System.out.println("####################################");
        System.out.println("Count digits in a number: " + countDigit(12345));
        System.out.println("####################################");
        System.out.println("Print N natural numbers");
        printNumbers(10);
        System.out.println("\n####################################");
    }
}
