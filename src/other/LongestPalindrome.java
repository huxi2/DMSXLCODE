package other;

import java.util.Arrays;

public class LongestPalindrome {

    // 动态规划
    // dp[i][j] 表示以s[i][j]为结尾的子串是否是回文子串
    // 1. dp[i][i]=true;
    // 2. if(s[i]==s[j]) dp[i][j] = dp[i+1][j-1]
    //    if(s[i]!=s[j]) dp[i][j] = false
    // return substring(left,right)
    public String longestPalindrome(String s) {
        int len = s.length(), maxlen = 0, left = 0, right = 0;
        boolean[][] dp = new boolean[len][len];
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j <= len - 1; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 1 || dp[i + 1][j - 1]) {//判断子序列
                        dp[i][j] = true;
                    }
                    if (dp[i][j] && j - i + 1 > maxlen) {
                        maxlen = j - i + 1;
                        left = i;
                        right = j;
                    }
                }
            }
        }
        return s.substring(left, right + 1);
//        return s.substring(left, left + maxlen);
    }

    //中心扩散
    public String longestPalindrome2(String s) {
        int len = s.length(), maxlen = 0, left = 0, right = 0;
        for (int i = 0; i < len; i++) {
            int l = i, r = i;
            //左
            while (l >= 0 && s.charAt(l) == s.charAt(i)) l--;
            //右
            while (r < len && s.charAt(r) == s.charAt(i)) r++;
            //同时动
            while (l >= 0 && r < len && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            }
            if (maxlen < r - l - 1) {
                left = l + 1;
                right = r - 1;//回文串右侧
                maxlen = r - l - 1;
            }
        }
        return s.substring(left, right + 1);
    }
}
