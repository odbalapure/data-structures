package strings;

public class Strings1 {

    public static void reverse() {
        String str = "mo";
        str = str.toLowerCase();
        String res = "";

        for (int i=str.length()-1; i >= 0; i--) {
            char c = str.charAt(i);
            res += c;
        }

        System.out.println("Reversed string: " + res);
    }

    public static void palindrome() {
        String str = "madam";
        str = str.toLowerCase();

        if (str.length() == 0) {
            return;
        }

        int s = 0;
        int e = str.length() - 1;

        while (s <= e) {
            if (str.charAt(s) == str.charAt(e)) {
                s++;
                e--;
            } else {
                System.out.println("Not a palindrome!");
                return;
            }
        }

        System.out.println("String is a palindrome.");
    }

    public static void reverseEachWord() {
        String str = "ym eman si mo";
        String ans = "";
        int currentWordStart = 0;
        int i = 0;

        for (i=0; i<str.length(); i++) {
            if (str.charAt(i) == ' ') {
                // reverse current word
                int currentWordEnd = i - 1;

                String reversedWord = "";
                for (int j=currentWordStart; j<=currentWordEnd; j++) {
                    reversedWord = str.charAt(j) + reversedWord;
                }

                // add it to the final string

                ans += reversedWord + " ";
                currentWordStart = i + 1;
            }
        }

        // last word will be skipped so reverse it separately
        int currentWordEnd = i - 1;
        String reversedWord = "";
        for (int j=currentWordStart; j<=currentWordEnd; j++) {
            reversedWord = str.charAt(j) + reversedWord;
        }

        // add it to final string
        ans += reversedWord;
        System.out.println("Reversed String: " + ans);
    }

    public static void allSubString() {
        String str = "pqrs";

        for (int start=0; start<str.length(); start++) {
            for (int end=start; end<str.length(); end++) {
                System.out.println(str.substring(start, end+1));
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("####################################");
        System.out.println("Reverse a string");
        reverse();
        System.out.println("####################################");
        System.out.println("Check palindrome string");
        palindrome();
        System.out.println("####################################");
        System.out.println("Reverse each word");
        reverseEachWord();
        System.out.println("####################################");
        System.out.println("All possible substrings in a string");
        allSubString();
        System.out.println("####################################");
    }
}
