package dp;

//带手续费
public class MaxProfitVI {

    // dp[i][0] 表示购入股票   dp[i][1] 表示出售股票
    // 1.dp[0] = {-price[0]-fee, 0} 买入时收手续费
    // 2.dp[i][0] = max(前一天持有，前一天未持有今天购入)
    //   dp[i][1] = max(前一天未持有，前一天持有今天卖出)
    // 3.return dp[n][1]
    public int maxProfit(int[] prices, int fee) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0]-fee;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]- fee);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }
        return dp[prices.length - 1][1];
    }
}
