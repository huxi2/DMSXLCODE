package dp;


public class MinCostClimbingStairs {
    //dp
    public int minCostClimbingStairs(int[] cost) {
        int[] pays = new int[cost.length + 1];

        //到达 台阶i 的最小代价
        for (int i = 2; i <= cost.length; i++) {
            pays[i] = Math.min(pays[i - 1] + cost[i - 1], pays[i - 2] + cost[i - 2]);
        }
        return pays[cost.length];
    }
}
