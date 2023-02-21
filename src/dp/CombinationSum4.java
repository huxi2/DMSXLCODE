package dp;

import org.junit.Test;

public class CombinationSum4 {

    /*
    //  完全背包问题 + 求组合数
    //  dp[j] 从 0~i 个物品中取，填满背包容量j的组合数
    //  1. dp[0] = 1;
    //  2. dp[i][j] +=  (dp[k][j-nums[k]]) for k in [0..i-1]
    //     -> dp[j] += dp[j-nums[i]] for j in [nums[i].. target]
    //  3. return
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {         // 先物品
            for (int j = nums[i]; j <= target; j++) {   //  再背包  ->  求组合数 即顺序无关  本题是顺序有关 故例题返回4
                dp[j] += dp[j - nums[i]];
                System.out.print(dp[j] + "\t");
            }
            System.out.println();
        }
        return dp[target];
    }
    */


    //  完全背包问题 + 求排列数
    //  dp[j] 从 0~i 个物品中取，填满背包容量j的排列数
    //  1. dp[0] = 1;
    //  2. dp[i][j] +=  (dp[k][j-nums[k]]) for k in [0..i-1]
    //     -> dp[j] += dp[j-nums[i]] for j in [nums[i].. target]
    //  3. return
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int j = 0; j <= target; j++) {   //  先背包  ->  求排列数 即顺序有关
            for (int i = 0; i < nums.length; i++) {  // 再物品
                if (j >= nums[i])//背包容量比物品大
                    dp[j] += dp[j - nums[i]];
            }
        }
        return dp[target];
    }

    @Test
    public void myTest() {
        int[] nums = {1, 2, 3};
        int target = 4;
        System.out.println(combinationSum4(nums, target));
    }
}
