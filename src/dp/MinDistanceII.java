package dp;

// 编辑距离
public class MinDistanceII {

    // dp[i][j] 表示 将以word1[i-1]为结尾  替换成以word2[j-1]为结尾的串最小操作数
    // 1. dp[i][0] = i; dp[0][j]=j;
    // 2. dp[i][j]   word1[i-1] == word2[j-1]： do[i][j] = dp[i-1][j-1]
    //               word1[i-1] != word2[j-1]：
    //               1. 删除word1[i-1]:  dp[i-1][j]+1
    //               2. 增加word1 --> word2删除:  dp[i][j-1]+1    #####
    //               3. 修改word1[i-1]:  dp[i-1][j-1] +1         #####
    // 3. return dp[m][n]
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        // 初始化
        for (int i = 0; i <= word1.length(); i++) dp[i][0] = i;
        for (int j = 0; j <= word2.length(); j++) dp[0][j] = j;
        // 转移
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // 删word1 dp[i-1][j]+1
                    // 增word1 -> word1不增 删word2  dp[i][j-1]+1
                    // 改word1 dp[i-1][j-1]+1
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
