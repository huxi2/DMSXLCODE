package dp;

public class RobII {

    // dp[i] 表示第i家被偷所获得最高金额
    // 成环需要考虑前后两边， 所以解环
    // dp[i][0] 表示第0开始到n-1家 所得最大利润
    // dp[i][1] 表示第1开始到n家 所得最大利润
    // 每个dp[i] 都是打家劫舍1的问题
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0],nums[1]);
        int[][] dp = new int[nums.length][2];

        dp[0][0] = nums[0];
        dp[1][0] = Math.max(nums[0], nums[1]);

        dp[1][1] = nums[1];
        dp[2][1] = Math.max(nums[1], nums[2]);

        for (int i = 2; i < nums.length; i++) {
            if (i < nums.length - 1) {//0~n-1
                dp[i][0] = Math.max(dp[i - 2][0] + nums[i], dp[i - 1][0]);
            }

            if (i > 2) {// 1~n
                dp[i][1] = Math.max(dp[i - 2][1] + nums[i], dp[i - 1][1]);
            }
        }
        return Math.max(dp[nums.length - 2][0], dp[nums.length - 1][1]);
    }
}
