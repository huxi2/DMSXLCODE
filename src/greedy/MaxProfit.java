package greedy;


public class MaxProfit {
    // 买卖股票最佳时机  无需考虑特殊情况只需要记录每天的利润就行
    public int maxProfit(int[] prices) {
        int ans = 0, hold = Integer.MAX_VALUE;
        for (int price : prices) {
            if (price >= hold) ans += (price - hold);
            hold = price;
        }
        return ans;
    }

    // 买卖股票含手续费
    // 每笔都收手续  在最低点买入，在最高点卖出  统计利润， 连续收获利润时，
    // 考虑三种情况  1.利润不足手续费亏本时不卖（保持不变）  2.可以持续收获利润时，这一天不是最后一天卖出
    // 3. 不操作
    public int maxProfit(int[] prices, int fee) {
        int ans = 0;
        int minPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            //在最低点买入
            if (minPrice > prices[i]) {
                minPrice = prices[i];
            }

            if (prices[i] - minPrice > fee) {//今天有利润可以算
                ans += prices[i] - minPrice - fee;// 计算当天利润
                minPrice = prices[i] - fee;//  连续多天计算利润时  并不是真正卖出，
            }
        }
        return ans;
    }
}
