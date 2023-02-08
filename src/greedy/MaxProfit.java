package greedy;


public class MaxProfit {
    public int maxProfit(int[] prices) {
        int ans = 0, hold = Integer.MAX_VALUE;
        for (int price : prices) {
            if (price >= hold) ans += (price - hold);
            hold = price;
        }
        return ans;
    }
}
