package dp;

public class LongestPalindromeSubseq {
    // 最长回文子序列
    // dp[i][j] 表示 以 s[i]~s[j]最长回文子序列

    // 1. dp[i][i] = 1
    // 2. dp[i][j]   s[i] == s[j]: 表示可以同时加入ij，构成回文
    //                   dp[i][j] = dp[i+1][j-1]+2;
    //               s[i] != s[j]: 表示不可以同时加入ij 那么选择其中1个加入
    //                  dp[i+1][j-1]的基础上 加入i  dp[i][j-1]    加入j  dp[i+1][j]s
    //                  dp[i][j] = max(dp[i][j-1], dp[i+1][j])
    //3. return dp[0][len-1]

    // 遍历顺序 i用到i+1  从下向上  j用到j-1从左往右
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];

        for (int i = len - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                }
            }
        }
        return dp[0][len - 1];
    }
}
