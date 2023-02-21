package dp;


public class ClimbStairs {
    public int climbStairs(int n) {
        if (n <= 2) return n;
        int n1 = 1, n2 = 2, i = 3, ans = 0;
        while (i <= n) {
            ans = n1 + n2;
            n1 = n2;
            n2 = ans;
            i++;
        }
        return ans;
    }

    // 若每次可爬【1-m】阶台阶，爬上n的方法
    // 分析：此时问题变成了完全背包问题， 背包容量就是 台阶数n，
    //      每次爬多高就成了物品，  物品【1-m】  且每个物品都是无限的
    //      而且 爬1, 2  和爬2, 1 是两种不同的方法  ->  求的是排列问题  ->先物品再背包
    //  dp[j] 从[0~i]件物品中 挑选爬上j台阶的物品排列数
    //  1. dp[0]=1;
    //  2. dp[j] += dp[j-i]
    //  3. return dp[n]
    public int climbStairs2(int n) {//进阶版
        int[] dp = new int[n + 1];
        dp[0] = 1;
        //物品相当于  [1-m]  这里取m=2
        int[] nums = {1, 2};
        //排列数先背包在背包
        for (int j = 0; j <= n; j++) {
            for (int i = 0; i < nums.length; i++) {//物品数
                if (j >= nums[i]) dp[j] += dp[j - nums[i]];
            }
        }
        return dp[n];
    }
}
