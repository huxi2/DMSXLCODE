package other;

import org.junit.Test;

import java.util.Arrays;

public class MinCut {
    // flag[i][j] 表示s[i] s[j] 字串是不是回文
    // dp[i] 表示 s[0~i]最小回文串的分割数量  j表示分割点
    // 1. dp[i]=i;
    // 2. if(flag[0][i]) dp[i] = 0
    //    else for: if(flag[j+1][i]) dp[i] = min(dp[i],dp[j])
    // 3.return dp[0][n]
    public int minCut(String s) {
        int len = s.length();
        boolean[][] flag = new boolean[len][len];
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 1 || flag[i + 1][j - 1]) flag[i][j] = true;
                }
            }
        }

        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
            //初始化
            dp[i]=i;

            if (flag[0][i]) {
                dp[i] = 0;
                continue;
            }
            for (int j = 0; j < i; j++) {
                if (flag[j + 1][i]) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[len - 1];
    }
}
