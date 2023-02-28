package dp;

public class MaxSubArray {

    //最大连续子数组和
    // dp[i] 表示以i为结尾的 最大子序列和
    // 1. dp[0] = nums[0];
    // 2. dp[i] = (dp[i-1] + nums[i],nums[i])
    // 3. return max(dp[i])
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            if (ans < dp[i]) ans = dp[i];
        }
        return ans;
    }
}
