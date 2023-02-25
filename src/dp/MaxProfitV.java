package dp;

//带冷冻期1天
public class MaxProfitV {
    //  dp[i][0] 表示第i天买入股票利润    dp[i][1] 表示第i天卖出股票利润
    //  1. dp[0] = {-price[0],0}
    //     dp[1][0] = max{dp[0][0],-price[1]}           //持有
    //     dp[1][1] = max{dp[0][1],dp[0][0]+price[1]}   //未持有
    //  2. dp[i][0] = max(前一天持有，前二天未持有今天买入)   //持有
    //              = max(dp[i-1][0],dp[i-2][1]-price[i])
    //     dp[i][1] = max(前一天未持有，前一天持有今天卖出)     //未持有
    //              = max(dp[i-1][1],dp[i-1][0] + prices[i])
    // 3.return dp[n][1];//最后一天未持有
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) return 0;
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];
        dp[1][0] = Math.max(-prices[0], -prices[1]);
        dp[1][1] = Math.max(dp[0][1], dp[0][0] + prices[1]);

        for (int i = 2; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 2][1] - prices[i]);//持有
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);//未持有
        }
        return dp[prices.length - 1][1];
    }
}
