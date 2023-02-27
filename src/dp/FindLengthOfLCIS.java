package dp;

public class FindLengthOfLCIS {

    //  dp[i] 表示以i为结尾的最长递增子序列长度
    //  1. dp[0] = 1
    //  2. dp[i] = nums[i]>nums[i-1]?dp[i-1]+1:1;
    //  3. return max(dp[n])
    public int findLengthOfLCIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int ans = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = 1;
            }
            if (dp[i] > ans) ans = dp[i];
        }
        return ans;
    }

    // 贪心
    public int findLengthOfLCIS2(int[] nums) {
        int ans = 1, temp = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                temp = temp + 1;
            } else {
                temp = 1;
            }
            if (temp > ans) ans = temp;
        }
        return ans;
    }
}
