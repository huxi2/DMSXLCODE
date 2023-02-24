package dp;

public class MaxProfit {
    // 只进行一次买卖 所以
    // 贪心 做法就是在左侧最小值买，右侧最大值卖
    // int[] left  right->进一步优化 只需要记录右侧最大值即可
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;
        int[] right = new int[prices.length];
        int ans = 0;

        //记录i右侧最大值
        int max = prices[prices.length - 1];
        for (int i = prices.length - 1; i >= 0; i--) {
            right[i] = max;
            if (prices[i] > max) max = prices[i];
        }

        //从左侧遍历查找最小值并计算当天买入的最大收益
        for (int i = 0; i < prices.length - 1; i++) {
            if (right[i] - prices[i] > ans) {
                ans = right[i] - prices[i];
            }
        }

        return ans;
    }

    //  dp[i][0] 表示第i天未持有股票的最大利润
    //  dp[i][1] 表示第i天持有股票的最大利润
    //  1.dp[0] = {0,-prices[0]}
    //  2.dp[i][0]  max(前一天未持有，前一天持有今天卖出)
    //    dp[i][1]  max(前一天持有，今天的价格)
    //  3.return dp[n][0]  //最后一天未持有的利润
    public int maxProfit2(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][0] - prices[i], dp[i-1][1]);
        }

        return dp[prices.length - 1][0];
    }
}
