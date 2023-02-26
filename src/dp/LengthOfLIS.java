package dp;

public class LengthOfLIS {
    //  由于串是非连续的，所以要二层遍历
    //
    //  dp[i] 表示[0~i]的最长递增子序列
    //  1.dp[i]=1;
    //  2.dp[i]   # 使用二层遍历
    //      if nums[i]>nums[j]:dp[i] = max(dp[i],dp[j]+1) //j<i
    //      else: dp[i] = max(dp[i],1)
    //  3.return max(dp[n])
    public int lengthOfLIS(int[] nums) {
        if (nums.length <= 1) return nums.length;
        int[] dp = new int[nums.length];
        int ans = 1;
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                } else {    //填充
                    dp[i] = Math.max(dp[i], 1);
                }
                if (dp[i] > ans) ans = dp[i];
            }
        }
        return ans;
    }
}
