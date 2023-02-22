package dp;

import java.util.List;

public class WordBreak {
    // 完全背包+排列问题
    // dp[j] 表示字符串[0-j]能否由字典中字符串组成
    // 1. dp[0] = true;
    // 2. dp[j] = dp[j-nums[i].length]
    // 3. return dp[n]
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int j = 1; j <= s.length(); j++) { //先背包
            for (int i = 0; i < j && !dp[j]; i++) { //后物品
                String temp = s.substring(i, j);
                if (wordDict.contains(temp) && dp[i])
                    dp[j] = true;
            }
        }
        return dp[s.length()];
    }
}
