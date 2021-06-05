package strings;

import java.util.Arrays;
import java.util.Stack;

public class String2 {

    public static void checkPermutation() {
        String str1= "sinrtg";
        String str2 = "string";

        char chArr1[] = str1.toCharArray();
        char chArr2[] = str2.toCharArray();

        if (str1.length() != str2.length()) {
            System.out.println("Not a permutation of each other...");
            return;
        }

        Arrays.sort(chArr1);
        Arrays.sort(chArr2);

        for (int i=0; i<chArr1.length; i++) {
            if (chArr1[i] != chArr2[i]) {
                System.out.println("Not a permutation of each other...");
                return;
            }
        }

        System.out.println("Strings are permutation of each other...");
    }

    public static void removeConsecutiveDuplicate() {
        String str = "aabbca";
        char[] stack = new char[str.length()];
        int i = 0;

        for (int j=0; j<str.length(); j++) {
            char currentChar = str.charAt(j);

            if (i > 0 && stack[i - 1] == currentChar) {
                i--;
            } else {
                stack[i] = currentChar;
                i += 1;
            }
        }

        System.out.println(new String(stack, 0, i));
    }

    public static void removeAdjacentStack() {
        String str = "abbaca";
        Stack<Character> stack = new Stack<>();

        for (int i=0; i<str.length(); i++) {
            if (!stack.isEmpty() && str.charAt(i) == stack.peek()) {
                stack.pop();
            } else {
                stack.push(str.charAt(i));
            }
        }

        System.out.println(stack);
    }

    public static void removeChar() {
        String str = "my name's omi, what's yours?";
        char removeChar = 'i';
        char chArr[] = str.toCharArray();
        int j = 0;

        for (int i=j=0; i<str.length(); i++) {
            if (chArr[i] != removeChar) {
                chArr[j++] = chArr[i];
            }
        }

        System.out.println(new String(chArr, 0, j));
    }

    public static void highestOccurringChar() {
        String str = "abdefgbabfbaaa";
        int count[] = new int[256];
        int max = Integer.MIN_VALUE;
        char maxOccurringChar = ' ';

        for (int i=0; i<str.length(); i++) {
            count[str.charAt(i)]++;
        }

        for (int i=0; i<count.length; i++) {
            if (count[i] != 0 && count[i] > max) {
                max = count[i];
                maxOccurringChar = (char)i;
            }
        }

        System.out.println(maxOccurringChar + ": encountered " +max + " times.");
    }

    public static void compressString() {
        String str = "aaabbcccddaeef";
        String res = "";
        int count = 1;
        res += str.charAt(0);

        for (int i=1; i<str.length(); i++) {
            char curr = str.charAt(i);
            char prev = str.charAt(i - 1);

            if (curr == prev) {
                count++;
            } else {
                if (count > 1 || count == 1) {
                    res += count;
                    count = 1;
                }
                res += curr;
            }
        }

        if (count > 1 || count == 1) {
            res += count;
        }

        System.out.println("Result string: " +res);
    }

    public static void main(String[] args) {
        System.out.println("####################################");
        System.out.println("Check if strings are permutation of each other");
        checkPermutation();
        System.out.println("####################################");
        System.out.println("Remove consecutive duplicates");
        removeConsecutiveDuplicate();
        System.out.println("Remove consecutive duplicates - STACK");
        removeAdjacentStack();
        System.out.println("####################################");
        System.out.println("Remove a character");
        removeChar();
        System.out.println("####################################");
        System.out.println("Maximum occurring character");
        highestOccurringChar();
        System.out.println("####################################");
        System.out.println("Compress String");
        compressString();
        System.out.println("####################################");

    }
}
