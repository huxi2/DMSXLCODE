package other;

import org.junit.Test;

import java.util.Arrays;

public class FindNumberOfLIS {
    //
    // dp[i] 表示s[i] 为结尾的最长递增子序列的长度
    // count[i]  表示s[i] 为结尾的最长递增子序列的个数
    // 1. dp[i]=1;  count[i]=1
    // 2. dp[j]: for j in (i, len)
    //          if nums[j]>nums[i]: 可以构成递增子数组
    //              j利用i构成了新的最长子序列 原来的序列count[j] + 新增的序列count[i]
    //              if(dp[j] == dp[i]+1)  count[j] += count[i]  // 长度相等的子数组
    //              if(dp[j] < dp[i]+1)  count[i] = count[i]   // 更长的子数组
    //
    //              dp[j] = max(dp[j],dp[i]+1)
    // 3. return sum(count[i]) if dp[i] == max
    public int findNumberOfLIS(int[] nums) {
        int ans = 0, max = Integer.MIN_VALUE;
        int[] dp = new int[nums.length];
        int[] count = new int[nums.length];
        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {

                if (nums[j] > nums[i]) {//计算最长公共子序列
                    // 以[i,j]为结尾的最长公共子序列长度等于  以[i-1,j]为结尾
                    if (dp[j] == dp[i] + 1) {
                        count[j] += count[i];
                    } else if (dp[j] < dp[i] + 1) { // dp[j] 为结尾找到了以dp[i] 为前一个的更长的子序列
                        count[j] = count[i];
                    }
                    dp[j] = Math.max(dp[i] + 1, dp[j]);
                }

            }
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (dp[i] == max) ans += count[i];
        }
        return ans;
    }

    @Test
    public void test() {
        int[] nums = {1, 3, 5, 4, 7};
        System.out.println(findNumberOfLIS(nums));
    }
}
