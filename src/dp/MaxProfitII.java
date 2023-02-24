package dp;

public class MaxProfitII {

    // 同贪心中maxProfit 是统一题
    // dp[i][0] 表示第i天未持有所得最大利润
    // dp[i][1] 表示第i天持有所得最大利润
    // 1. dp[0] = {0,-prices[0]}
    // 2. dp[i][0]=max(前一天未持有，前一天持有今天卖出)
    //    dp[i][1]=max(前一天持有，前一天未持有今天购入)
    // 3.return dp[n][0]
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[0]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[0]);
        }

        return dp[prices.length - 1][0];
    }
}
