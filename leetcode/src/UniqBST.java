/**
 * Created by wang-zhenjun on 9/7/16.
 */

import java.util.*;

public class UniqBST {
    // dp[3] = dp[0] * dp[2] + dp[1] * dp[1] + dp[2] * dp[0]
    // dp[i] = (k = 1-->i)∑{ dp[k - 1] * dp[i - k] }
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        
        for (int i = 2; i <= n; ++i) {
            for (int k = 1; k <= i; ++k) {
                dp[i] += dp[k - 1] * dp[i - k];
            }
        }

        return dp[n];
    }
    
    public static void main(String args[]) {
        UniqBST s = new UniqBST();
        int res = s.numTrees(2);
        System.out.println(res);
    }
}
