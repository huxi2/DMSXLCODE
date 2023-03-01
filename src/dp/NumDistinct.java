package dp;

public class NumDistinct {

    // 给定一个字符串 s 和一个字符串 t ，计算在 t 在 s 出现的个数。
    // dp[i][j] 表示以s[i-1] t[j-1] 为结尾， t[j-1] 在 s[i-1] 中出现的次数
    // 1. dp[i][0] = 1
    // 2. dp[i][j] ->    s[i-1]==t[j-1]: 相等时  有两种选择 一种：使用该s[i-1]配对  另一种是不使用s[i-1](删除)
    //                        使用s[i-1] 与 t[j-1] 匹配: 即s[i-2] 与 t[j-1] 的数量：  dp[i-1][j-1]
    //                        不使用s[i-1] 与 t[j-1] 匹配: 即s[i-2] 与 t[j-1]的数量   dp[i-1][j]
    //                  故： dp[i][j] = dp[i-1][j-1] + dp[i-1][j]

    //                  s[i]!=t[j] : 不相等即使用s[i-2] 与 t[i-1]匹配：  dp[i][j] = dp[i-1][j]
    // 3. return dp[m][n]
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        //初始化：
        for (int i = 0; i <= s.length(); i++) {
            dp[i][0]=1;
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    // dp[i-1][j-1]:使用s[i-1]进行匹配的数量  s[i-2] t[j-2]
                    // dp[i-1][j]:不使用s[i-1]进行匹配的数量  s[i-2] t[j-1]
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else { //不相等时： 就是s[i-2]以t[j-1]的匹配数量
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[s.length()][t.length()];
    }
}
