package dp;

public class FindLength {

    //  dp[i][j] 表示nums1[i-1],nums2[j-1] 为结尾的公共子序列的长度
    //  1.初始化：dp[0][j] = dp[i][0] = 0
    //  2.状态转移：  if(nums[i-1] == nums[j-1])  dp[i][j] = dp[i-1][j-1]+1
    //              else dp[i][j] = 0  //相等就赋值0 保证始终计算的是连续的数组
    //  3.return max(dp[m][n])
    public int findLength(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[][] dp = new int[m + 1][n + 1];
        int ans = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                if(dp[i][j]>ans)ans = dp[i][j];
            }
        }
        return ans;
    }


    // 和方法二的区别就在于返回值  nums[i][j] 不相等时赋值给前一个比对的最长子数组长度
    //  dp[i][j] 表示nums1[i-1],nums2[j-1] 为结尾的最长公共子序列的长度
    //  1.初始化：dp[0][j] = dp[i][0] = 0
    //  2.状态转移：  if(nums[i-1] == nums[j-1])  dp[i][j] = dp[i-1][j-1]+1
    //              else dp[i][j] = max(dp[i-1][j],dp[i][j-1])
    //  3.return dp[m][n]
    public int findLength2(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {  //这里把问题变成了最长的非连续子数组
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}
