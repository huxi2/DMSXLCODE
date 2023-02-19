package dp;

import java.util.Arrays;

public class FindTargetSumWays {
    // diff = sum - abs(target)  只需要找到能够组成 diff/2 的组合数就行  让diff和为0即可
    // // diff<0 || diff%2==1 return 0
    // 1. dp[j] 从[0~i] 挑选和为j的组合数
    // 2. dp[0] = 1;
    // 3. dp[j] 分两种情况： 1.取i  2.不取i
    //      1. 不取： nums[i] > j :  dp[j] = dp[j]
    //      2. 取：  dp[j] = sum(dp[i-1][k-nums[i]]) //遍历k   k=[nums[i]~bagSize]
    public int findTargetSumWays(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        int diff = sum - Math.abs(target);
        if (sum < Math.abs(target) || diff % 2 == 1) return 0;

        int bagSize = diff / 2;
        int[] dp = new int[bagSize + 1];
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = bagSize; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[bagSize];
    }

}
