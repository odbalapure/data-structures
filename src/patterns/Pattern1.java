package patterns;

public class Pattern1 {

    /*Star triangle*/
    public static void pattern1() {
        int n = 5;
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    /*Character pattern*/
    public static void pattern2() {
        int n = 5;
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=n; j++) {
                char jthChar = (char) ('A' + j - 1);
                System.out.print(jthChar);
            }
            System.out.println();
        }
    }

    public static void pattern3() {
        int n = 5;
        for (int i=0; i<n; i++) {
            char jthChar = (char) ('A' + i);
            for (int j=0; j<n; j++) {
                System.out.print(jthChar);
            }
            System.out.println();
        }
    }

    /*Character triangle pattern*/
    public static void pattern4() {
        int n = 4;
        for (int i=0; i<n; i++) {
            char jthChar = (char) ('A' + i);
            for (int j=0; j<=i; j++) {
                System.out.print(jthChar);
                jthChar = (char) (jthChar + 1);
            }
            System.out.println();
        }
    }

    public static void pattern5() {
        int n = 5;
        char startChar = 'E';
        for (int i=0; i<n; i++) {
            char jthChar = (char) (startChar - i);
            for (int j=0; j<=i; j++) {
                System.out.print(jthChar);
                jthChar = (char) (jthChar + 1);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println("####################################");
        pattern1();
        System.out.println("####################################");
        pattern2();
        System.out.println("####################################");
        pattern3();
        System.out.println("####################################");
        pattern4();
        System.out.println("####################################");
        pattern5();
        System.out.println("####################################");
    }
}
/*
####################################
*
**
***
****
*****
####################################
ABCDE
ABCDE
ABCDE
ABCDE
ABCDE
####################################
AAAAA
BBBBB
CCCCC
DDDDD
EEEEE
####################################
A
BC
CDE
DEFG
####################################
E
DE
CDE
BCDE
ABCDE
####################################
*/