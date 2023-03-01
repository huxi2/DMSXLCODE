package dp;

public class IsSubsequence {

    // 判断子序列 s 是否是 t 的子序列
    // dp 最长公共子序列解题 dp[m][n] = s.length
    // dp[i][j] 表示以s[i-1] t[j-1]为结尾的最长公共子序列的长度
    // 1.dp[0][0] = 0
    // 2.dp[i][j]  if s[i]==t[j]: dp[i][j] = dp[i-1][j-1] + 1
    //             else s[i]!=t[j]: dp[i][j] = max(dp[i][j-1],dp[i-1][j])
    // 3.return dp[m][n] == s.length
    public boolean isSubsequence(String s, String t) {
        if(s.length() == 0)return true;
        if(s.length()>t.length())return false;
        int[][] dp = new int[s.length()+1][t.length()+1];

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if(s.charAt(i) == t.charAt(j)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[s.length()][t.length()] == s.length();
    }

    //贪心算法 -> 双指针 s[i]  t[j]
    public boolean isSubsequence2(String s, String t) {
        int i=0,j=0;
        while(i<s.length() && j<t.length()){
            if(s.charAt(i)==t.charAt(j)){
                i++;
            }
            j++;
        }
        return i == s.length();
    }
}
