package dp;

import java.util.Arrays;

public class NumSquares {

    //  dp[j] 表示从[0-i]的平方数中取数  满足容量为j的背包的最小数量
    //  1. dp[0] = 0, dp[j] = MAX
    //  2. dp[j] = min(dp[j], dp[j-i*i]+1) if dp[j-i*i]!=MAX
    //  3. return dp[n]

    // 完全背包（背包从小到大）+组合问题（先物品后背包）
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        int max = Integer.MAX_VALUE;
        Arrays.fill(dp, max);
        dp[0] = 0;

        for (int i = 0; i * i <= n; i++) {  //组合问题
            for (int j = i * i; j <= n; j++) {//完全背包问题
                if (dp[j - i * i] != max) {
                    dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
                }
            }
        }

        return dp[n] == max ? -1 : dp[n];
    }
}
