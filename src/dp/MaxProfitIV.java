package dp;

public class MaxProfitIV {
    //  同MaxProfitIII相同  数组定义为
    //  dp[i][2*k]-> dp[j*2]表示第(j)次买入最大利润  j=[0,1,..k]
    //               dp[j*2+1]表示第j次卖出最大利润  j=[0,1,..k]
    //  1.dp[0][2*j] = -prices[0]     j=[0,1,..k/2-1]
    //  2.  j=[0,1,..k-1]
    //      买入
    //          j>0 dp[i][2*j] = max(dp[i-1][2*j],dp[i-1][2*j-1]-price[i])
    //          j=0 dp[i][2*j] = max(dp[i-1][2*j],-price[i])
    //      卖出
    //      dp[i][2*j+1] = max(dp[i-1][2*j+1],dp[i-1][2*j]+price[i])
    //  3.return max(dp[n][2*j+1];
    public int maxProfit(int k, int[] prices) {
        int[][] dp = new int[prices.length][2 * k];
        // 初始化
        for (int j = 0; j < k; j++) {
            dp[0][2 * j] = -prices[0];
        }

        for (int i = 1; i < prices.length; i++) {
            for (int j = 0; j < k; j++) {
                //买入
                if (j == 0)
                    dp[i][2 * j] = Math.max(dp[i - 1][2 * j], -prices[i]);
                else
                    dp[i][2 * j] = Math.max(dp[i - 1][2 * j], dp[i - 1][2 * j - 1] - prices[i]);
                //卖出
                dp[i][2 * j + 1] = Math.max(dp[i - 1][2 * j + 1], dp[i - 1][2 * j] + prices[i]);
            }
        }
        int ans = 0;
        for (int j = 0; j < k; j++) {
            if (ans < dp[prices.length - 1][2 * j + 1])
                ans = dp[prices.length - 1][2 * j + 1];
        }
        return ans;
    }
}
