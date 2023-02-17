package dp;

import java.util.Arrays;

public class CanPartition {

    // 拆分成两个等和数组： 即01背包  是否可以装满容量为sum/2的背包
    // 1. dp[i][j] 从[0~i] 取物品容量为j的背包最大重量
    // 2. dp[0][j] = j>=nums[0]?nums[0]:0
    // 3. dp[i][j] 第 i 件物品  取、不取
    //         dp[i][j] = dp[i-1][j] 不取/容量不够无法取
    //         dp[i][j] = max(dp[i-1][j], dp[i-1][j-nums[i]]+nums[i])
    //4. return dp[n][m] == bagSize
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 == 1) return false;
        // dp填背包
        int bagSize = sum / 2;
        int[][] dp = new int[nums.length][bagSize + 1];
        //初始化
        for (int j = nums[0]; j <= bagSize ; j++) {
            dp[0][j] = nums[0];
        }
        //状态转移
        for (int i = 1; i < nums.length; i++) {//物品
            for (int j = 1; j <= bagSize; j++) {//背包
                if(j<nums[i]){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-nums[i]]+nums[i]);
                }
            }
        }
        return dp[nums.length-1][bagSize]==bagSize;
    }

    //滚动数组
    // 1. dp[j] 从[0~i] 取物品容量为j的背包最大重量
    // 2. dp[j] = j>=nums[0]?nums[0]:0
    // 3. dp[j] 第 i 件物品  取、不取
    //         dp[j] = [j] 不取/容量不够无法取
    //         dp[j] = max(dp[j], dp[j-nums[i]]+nums[i])
    //4. return dp[m] == bagSize
    public boolean canPartition2(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 == 1) return false;
        // dp填背包
        int bagSize = sum / 2;
        int[] dp = new int[bagSize + 1];

        //状态转移
        for (int i = 0; i < nums.length; i++) {//物品
            for (int j = bagSize; j >= nums[i]; j--) {//背包  逆序遍历  因为 容量大背包依赖容量小背包
                dp[j] = Math.max(dp[j], dp[j-nums[i]]+nums[i]);//max前的dp[j]相当于dp[i][j]  max后的dp[j] 相当于dp[i-1][j]
            }
        }
        return dp[bagSize]==bagSize;
    }
}
