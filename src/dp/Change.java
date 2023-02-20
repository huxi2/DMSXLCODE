package dp;

public class Change {
    //  dp[j] 表示从[0~i] 中取硬币，填满背包的组合数
    //  1.dp[0] = 1
    //  2. 此处求满足背包有集中组合方法，故递推公式为： dp[j] += dp[j-coins[i]]
    //  3. return dp[amount]
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {//物品
            for (int j = coins[i]; j <= amount; j++) {// 背包
                dp[j] += dp[j-coins[i]];
            }
        }
        return dp[amount];
    }
}
