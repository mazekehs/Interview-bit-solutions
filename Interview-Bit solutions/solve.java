import java.util.*;

public class solve {

    public static void main(String[] args) {
        solve s = new solve();
        int[] A = { 20, 7, 8 };
        System.out.println(s.s(A));
    }

    public int s(final int[] A) {
        int sum = 0;
        int n = A.length;

        for (int i = 0; i < n; i++) {
            sum += A[i];
        }

        sum /= 2;

        int[] dp = new int[sum + 1];
        Arrays.fill(dp, 100);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = sum; j >= A[i]; j--) {
                if (dp[j - A[i]] != 100) {
                    dp[j] = Math.min(dp[j], dp[j - A[i]] + 1);
                }
            }
        }

        for (int i = sum; i >= 0; i--) {
            if (dp[i] != 100) {
                return dp[i];
            }
        }

        return dp[0];
    }

}
