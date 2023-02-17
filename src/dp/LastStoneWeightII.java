package dp;

import java.util.Arrays;

public class LastStoneWeightII {
    // 相当于尽可能将石头分成重量相近的量组，然后让两组相撞
    // 即背包容量为sum/2的01背包问题
    // 1. dp[i][j] = 容量为j的背包从[0~i]物品中能装最大重量
    // 2. dp[0][j] = j>=nums[0]?nums[0]:0;
    // 3. dp[i][j]   第i件物品  分两种：取
    public int lastStoneWeightII(int[] stones) {
        int sum = Arrays.stream(stones).sum();
        int bagSize = sum / 2;

        int[][] dp = new int[stones.length][bagSize + 1];
        for (int j = stones[0]; j <= bagSize; j++) {
            dp[0][j] = stones[0];
        }

        for (int i = 1; i < stones.length; i++) {
            for (int j = 1; j <= bagSize; j++) {
                if (j < stones[i]) {//不取
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - stones[i]] + stones[i]);
                }
            }
        }
        return sum - 2 * dp[stones.length - 1][bagSize];
    }

    //滚动数组
    public int lastStoneWeightII2(int[] stones) {
        int sum = Arrays.stream(stones).sum();
        int bagSize = sum / 2;

        int[] dp = new int[bagSize + 1];

        for (int i = 0; i < stones.length; i++) {
            for (int j = bagSize; j >= stones[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }
        return sum - 2 * dp[bagSize];
    }
}
