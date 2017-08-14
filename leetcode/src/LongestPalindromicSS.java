/**
 * Created by wang-zhenjun on 9/3/16.
 */

import java.util.*;

public class LongestPalindromicSS {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean [][] dp = new boolean[n][n];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(dp[i], false);
        }

        int max_len = 1;
        int start = 0;

        for (int i = 0; i < n; ++i) {
            dp[i][i] = true;
            for (int j = 0; j < i; ++j) {
                dp[j][i] = (s.charAt(j) == s.charAt(i)) && (i - j < 2 || dp[j + 1][i - 1]);
                if (dp[j][i] && i - j + 1 > max_len) {
                    max_len = i - j + 1;
                    start = j;
                }
            }
        }

        return s.substring(start, max_len + start);
    }

    public static void main(String args[]) {
        LongestPalindromicSS s = new LongestPalindromicSS();
        String res = s.longestPalindrome("aarxhxrauuu");
        System.out.println(res);
    }
}
