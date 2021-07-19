package dynamicprogramming;

public class DP1 {

    public static int fibonacci(int n, int dp[]) {
        if (n == 0 || n == 1) {
            return n;
        }

        int ans1, ans2;
        if (dp[n - 1] == -1) {
            ans1 = fibonacci(n-1, dp);
            dp[n - 1] = ans1;
        } else {
            ans1 = dp[n - 1];
        }

        if (dp[n - 2] == - 1) {
            ans2 = fibonacci(n-2, dp);
            dp[n - 2] = ans2;
        } else {
            ans2 = dp[n - 2];
        }

        return ans1 + ans2;
    }

    // given a number n, no. of steps taken to reach 1
    public static int minStepsTo1(int n, int dp[]) {
        if (n == 1) {
            return 0;
        }

        int ans1;
        if (dp[n - 1] == -1) {
            ans1 = minStepsTo1(n - 1, dp);
            dp[n - 1] = ans1;
        } else {
            ans1 = dp[n - 1];
        }

        int ans2 = Integer.MAX_VALUE;
        if (n % 2 == 0) {
            if (dp[n / 2] == -1) {
                ans2 = minStepsTo1(n/2, dp);
                dp[n/2] = ans2;
            } else {
                ans2 = dp[n / 2];
            }
        }

        int ans3 = Integer.MAX_VALUE;
        if (n % 3 == 0) {
            if (dp[n / 3] == -1) {
                ans3 = minStepsTo1(n / 3, dp);
                dp[n/3] = ans3;
            } else {
                ans3 = dp[n/3];
            }
        }

        int ans = Math.min(ans1, Math.min(ans2, ans3)) + 1;
        return ans;
    }

    public static int minimumSquare(int n, int dp[]) {
        if (n == 0) {
            return 0;
        }

        int minAns = Integer.MAX_VALUE;

        for (int i=1; i*i<=n; i++) {
            int currAns;
            if (dp[n - (i*i)] == -1) {
                currAns = minimumSquare(n - (i*i), dp);
            } else {
                currAns = dp[n - (i*i)];
            }

            if (minAns > currAns) {
                minAns = currAns;
            }
        }

        int ans = 1 + minAns;
        return ans;
    }

    public static void minSquareIterative(int n) {
        int dp[] = new int[n + 1];
        dp[0] = 0;

        for (int i=1; i<=n; i++) {
            int minAns = Integer.MAX_VALUE;
            for (int j=1; j*j<=i; j++) {
                int currAns = dp[i - (j*j)];

                if (minAns > currAns) {
                    minAns = currAns;
                }
            }
            dp[i] = 1 + minAns;
        }

        System.out.println(dp[n]);
    }

    public static void main(String[] args) {
        System.out.println("####################################");
        System.out.println("Nth Fibonacci Number");
        int n = 10;
        int dp1[] = new int[n+1];

        for (int i=0; i<dp1.length; i++) {
            dp1[i] = -1;
        }

        System.out.println(fibonacci(n, dp1));

        System.out.println("####################################");
        System.out.println("Minimum steps from N to 1");
        n = 10;
        int dp2[] = new int[n + 1];
        for (int i=0; i<dp2.length; i++) {
            dp2[i] = -1;
        }
        System.out.println(minStepsTo1(n, dp2));
        System.out.println("####################################");
        System.out.println("Minimum square - recursive");
        n = 41;
        int dp3[] = new int[n + 1];
        for (int i=0; i<dp3.length; i++) {
            dp3[i] = -1;
        }

        System.out.println(minimumSquare(n, dp3));
        System.out.println("####################################");
        System.out.println("Minimum square - iterative");
        minSquareIterative(41);
        System.out.println("####################################");
    }
}
