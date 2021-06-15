package patterns;

public class Pattern2 {

    /*Inverted triangle*/
    public static void pattern1() {
        int n = 5;
        for (int i=n; i>=1; i--) {
            for (int j=1; j<=i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    /*Inverted mirror image triangle*/
    public static void pattern2() {
        int n = 5;
        for (int i=1; i<=n; i++) {
            int spaces = 1;
            while (spaces <= n-i) {
                System.out.print(' ');
                spaces += 1;
            }

            int stars = 1;
            while (stars <= i) {
                System.out.print('*');
                stars += 1;
            }
            System.out.println();
        }
    }

    /*Isosceles triangle pattern*/
    public static void pattern3() {
        int n = 4;
        for (int i=1; i<=n; i++) {
            int spaces = 1;
            while (spaces <= n-i) {
                System.out.print(' ');
                spaces += 1;
            }

            int num = 1;
            while (num <= i) {
                System.out.print(num);
                num += 1;
            }

            int dec = i - 1;
            while (dec >= 1) {
                System.out.print(dec);
                dec -= 1;
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
    }
}
