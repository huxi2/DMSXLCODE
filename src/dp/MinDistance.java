package dp;

// 两个字符串的删除操作
public class MinDistance {

    // dp[i][j] 表示以以word1[i-1], word2[j-1]为结尾的两个串 相等的最小删除数量
    // 1. dp[0][j] = j,  dp[i][0] = i //初始化问题注意
    // 2. dp[i][j]    当 word1[i-1] == word2[j-1]  不需要删除  dp[i][j] = dp[i-1][j-1]
    //                当 word1[i-1] != word2[j-1]  需要删除
    //                删除1个： 删除word1 dp[i-1][j]   删除word2  dp[i][j-1]
    //                删除2个： dp[i-1][j-1]
    //                  dp[i][j] = min(dp[i-1][j]+1,dp[i][j-1]+1, dp[i-1][j-1]+2) ;
    // 3.return dp[m][n]
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        
        //初始化问题
        for (int i = 0; i <= word1.length(); i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= word2.length(); j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {//相等不需要删除
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int delete1 = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
                    dp[i][j] = Math.min(delete1, dp[i - 1][j - 1] + 2);
                }
                System.out.print(dp[i][j]+"\t");
            }
            System.out.println();
        }
        return dp[word1.length()][word2.length()];
    }
}
