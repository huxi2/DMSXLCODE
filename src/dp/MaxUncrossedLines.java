package dp;

public class MaxUncrossedLines {

    // 不相交的线
    // 即找到A[i] == B[j] 且不和其他线相交
    // 就是找到一组相对位置固定的  重复子数组   ->  最长公共子序列的个数

    // dp[i][j] 表示A[0~i-1] B[0~j-1] 的最长公共子序列长度
    // 1. dp[0][0] = 0;
    // 2. dp[i][j]  A[i-1] == B[j-1]:  dp[i][j] = dp[i-1][j-1]+1;
    //              A[i-1] != B[j-1]:  dp[i][j] = max(dp[i-1][j],dp[i][j-1])//不连续数组
    // 3.return dp[m][n]
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) return 0;
        int m = nums1.length, n = nums2.length;
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[m][n];
    }
}
