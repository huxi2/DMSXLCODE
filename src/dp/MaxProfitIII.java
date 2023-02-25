package dp;

public class MaxProfitIII {

    //  dp[i][0]  表示第i天买入出股票所得利润
    //  dp[i][1]  表示第i天第一次买入出股票所得利润
    //  dp[i][2]  表示第i天第一次卖出未持有股票所得利润
    //  dp[i][3]  表示第i天第二次卖出股票所得利润
    //  1.dp[0] = {-price[0],0,-price[0],0}  //当天买当天卖两次的四个状态
    //  2.  dp[i][0] = max(第一次买入持有，今天买入)
    //                 max(dp[i-1][0],-prices[i])
    //      dp[i][1] = max(前一天第一次卖出，前一天第一次持有今天卖出)
    //                 max(dp[i-1][1],dp[i-1][0]+prices[i])
    //      dp[i][2] = max(前一天第二次买入持有，前一天第二次卖出未持有今天买入)
    //                 max(dp[i-1][2], dp[i-1][1]-price[i])
    //      dp[i][3] = max(前一天第二次卖出，前一天第二次持有今天卖出)
    //                 max(dp[i-1][3], dp[i-1][2]+prices[i])
    //  3.return max(dp[n])
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][4];

        dp[0][0] = -prices[0];
        dp[0][2] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0], -prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]+prices[i]);

            dp[i][2] = Math.max(dp[i-1][2],dp[i-1][1]-prices[i]);
            dp[i][3] = Math.max(dp[i-1][3],dp[i-1][2]+prices[i]);
            System.out.println(prices[i]+": "+dp[i][0]+" "+dp[i][1]+" "+dp[i][2]+" "+dp[i][3]+" ");
        }
        return Math.max(dp[prices.length-1][1],dp[prices.length-1][3]);
    }
}
