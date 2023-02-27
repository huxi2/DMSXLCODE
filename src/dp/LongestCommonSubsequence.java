package dp;

public class LongestCommonSubsequence {
    // 看最长公共子数组的总结
    // 重点在于： 当不相等时，连续子数组直接赋值0，非连续子数组赋值 max(dp[i-1][j],dp[i][j-1])
    //  dp[i][j] 表示nums1[i-1],nums2[j-1] 为结尾的最长公共子序列的长度
    //  1.初始化：dp[0][j] = dp[i][0] = 0
    //  2.状态转移：  if(nums[i-1] == nums[j-1])  dp[i][j] = dp[i-1][j-1]+1
    //              else dp[i][j] = max(dp[i-1][j],dp[i][j-1])
    //  3.return dp[m][n]
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text2 == null) return 0;
        if (text1.length() == 0 || text2.length() == 0) return 0;

        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}
