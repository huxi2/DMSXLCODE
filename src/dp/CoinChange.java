package dp;

import java.util.Arrays;

public class CoinChange {

    //  dp[j] 表示从0~i取物品，能够填满背包容量j的最小组合数
    //  1.dp[0] = 0; dp[i] = MAX
    //  2.dp[j] = min(dp[j],dp[j-coins[i]]+1)  if dp[j-coins[i]]!=MAX
    //  3.return dp[amount]

    //完全背包问题（背包从小到大） -> 组合问题（先物品后背包）
    public int coinChange(int[] coins, int amount) {
        if (amount <= 0) return 0;
        int[] dp = new int[amount + 1];
        int max = Integer.MAX_VALUE;
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {//组合问题
            for (int j = coins[i]; j <= amount; j++) {//完全背包问题
                if (dp[j - coins[i]] != max) {
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }
        return dp[amount] == max ? -1 : dp[amount];
    }
}
