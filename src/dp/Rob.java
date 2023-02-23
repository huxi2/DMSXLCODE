package dp;

public class Rob {
    // d[i][2]  dp[i][0]表示第i家不偷的利润  dp[i][1] 表示第i家偷的利润
    // 1.dp[0] = {0,nums[0]}
    // 2.dp[i][0] = max(dp[i-1][0],dp[i-1][1])
    //   dp[i][1] = max(dp[i-1][0] + nums[i],dp[i-1][1])
    // 3. return max(dp[n][0],dp[n][1])
    public int rob(int[] nums) {
        int[][] dp = new int[nums.length][2];

        dp[0][0] = 0;
        dp[0][1] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = Math.max(dp[i - 1][0] + nums[i], dp[i - 1][1]);
        }

        return Math.max(dp[nums.length - 1][0], dp[nums.length - 1][1]);
    }

    //  一维数组表示  dp[i]表示偷第i家获得最大利润
    //  dp[i] 和 dp[i-1] 与dp[i-2] 有关
    //  1. dp[0] = nums[0] dp[1] = max(nums[0],nums[1])
    //  2. dp[i] = max(dp[i-1],dp[i-2]+nums[i])
    //  3. return dp[n]
    public int rob1(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }

        return dp[nums.length - 1];
    }

    // 去数组表示
    public int rob2(int[] nums) {
        int a = 0, b = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp = Math.max(a, b);
            int temp2 = Math.max(a + nums[i], b);
            a = temp;
            b = temp2;

        }

        return Math.max(a, b);
    }
}
