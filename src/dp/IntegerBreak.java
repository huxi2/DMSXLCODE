package dp;


import org.junit.Test;

public class IntegerBreak {
    // dp[i] 表示 和为i 所能达到的最大值
    // dp[i] 分两种情况, 1 将i分成j i-j  2 继续将i-j进行细分,
    //              同时在第二层遍历中， 应当保当前值和dp[i]最大值
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i - 1; j++) {
                dp[i] = Math.max(Math.max(i - j, dp[i - j]) * j, dp[i]);
            }
        }
        return dp[n];
    }

    @Test
    public void test(){
        integerBreak(10);
    }
}
