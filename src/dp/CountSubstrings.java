package dp;

public class CountSubstrings {
    // dp[i][j] 表示从i到j字串是否是回文串
    // 1. dp[i][j] = false
    // 2. dp[i][j] =>  s[i] == s[j]: 可能是回文
    //                  继续判断内部 s[i+1] s[j-1]是不是回文串；
    //                  若j-i>1 存在内部元素:  dp[i+1][j-1]是否是回文串   若是回文串则匹配，不是不匹配
    //                                 dp[i][j] = dp[i+1][j-1]
    //                  若j-i<=1 不存在内部元素：  s[i] s[j] 是相邻元素或者同一元素
    //                                 dp[i][j] = true;
    // 3. sum(dp[i][j])

    // 确定遍历顺序： 因为dp[i][j] 用到了  dp[i+1][j-1] 即左下角元素，
    //  所以i用到i+1 采用 从下向上        j用到j-1 采用从左往右
    public int countSubstrings(String s) {
        int len = s.length(), ans = 0;
        boolean[][] dp = new boolean[len][len];
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {//相等进行判断
                    if (j - i <= 1) {//相邻或者同一个字母
                        dp[i][j] = true;
                        ans++;
                    } else if (dp[i + 1][j - 1]) {//内部元素大于1
                        dp[i][j] = true;
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
}
