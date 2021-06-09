package recursion;

public class Recursion3 {

    /*Replace a character with some other character passed as an argument*/
    public static String replaceChar(String str, char a, char b) {
        if (str.length() == 0) {
            return "";
        }

        // call be made this way
        // bxcxddx, xcxddx, ... , ddx, dx, x, " "
        // an empty string will be there at last, " " will be returned acc to base condition
        // so we have b + smallOutput i.e. y + " "
        String smallOutput = replaceChar(str.substring(1), a, b);
        if (str.charAt(0) == a) {
            return b + smallOutput;
        } else {
            return str.charAt(0) + smallOutput;
        }
    }

    /*Remove a particular character from a string*/
    public static String removeChar(String str, char c) {
        // our EXIT condition
        if (str.length() == 0) {
            return "";
        }

        String smallOutput = removeChar(str.substring(1), c);
        if (str.charAt(0) == c) {
            return smallOutput;
        }
        return str.charAt(0) + smallOutput;
    }

    /*Remove consecutive duplicate characters in a string*/
    public static String removeConsecutiveDuplicates(String str) {
        // our EXIT condition
        if (str.length() == 1) {
            return str;
        }
        // a a b c c b a
        String smallOutput = removeConsecutiveDuplicates(str.substring(1));
        System.out.println("Small Output: " + smallOutput);
        // compare the character at 0th with 1st index
        if (str.charAt(0) == smallOutput.charAt(0)) {
            return smallOutput;
        }

        return str.charAt(0) + smallOutput;
    }

    /*Replace pi with 3.14*/
    public static String replacePi(String str) {
        // our EXIT condition
        if (str.length() == 0) {
            return "";
        }

        if (str.charAt(0) == 'p' && str.charAt(1) == 'i') {
            // call recursion on string with length n - 2
            String smallOutput = replacePi(str.substring(2));
            return "3.14" + smallOutput;
        } else {
            // call recursion on string with length n - 1
            String smallOutput = replacePi(str.substring(1));
            return str.charAt(0) + smallOutput;
        }
    }

    public static void main(String[] args) {
        System.out.println("####################################");
        System.out.println("Replace a character with some other: " + replaceChar("abxcxddx", 'x', 'y'));
        System.out.println("####################################");
        System.out.println("Remove a particular character: " + removeChar("My name's Omi!", 'i'));
        System.out.println("####################################");
        System.out.println("Remove duplicates recursively: " + removeConsecutiveDuplicates("aabccba"));
        System.out.println("####################################");
        System.out.println("Replace pi with 3.14: " + replacePi("ab-pi-c-pi-pi"));
        System.out.println("####################################");
    }
}
