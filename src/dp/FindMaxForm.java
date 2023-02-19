package dp;


public class FindMaxForm {
    // dp[i][j]  表示[0~k]个字符串中最多i个0，j个1的集合最大数量
    // 1. dp[0][0] = 0;
    // 2. str[k] 有取和不取两种
    //      不取  dp[k][i][j] = dp[k-1][i][j]
    //      取    dp[k][i][j] = max(dp[k-1][i][j], dp[k-1][i-count0][j-count1] + 1)
    //
    //      dp[i][j] 因为背包相当于滚动数组  所以内层进行逆序遍历
    //  3. return dp[m][n]
    public int findMaxForm(String[] strs, int m, int n) {

        int[][] dp = new int[m + 1][n + 1];

        for (String s : strs) {
            int count0 = 0, count1 = 0;
            for (char c : s.toCharArray()) {
                if (c == '0') count0++;
                else count1++;
            }
            if(count0>m || count1>n)continue;

            for (int i = m; i >= count0; i--) {
                for (int j = n; j >= count1; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-count0][j-count1] + 1);
                }
            }
        }
        return dp[m][n];
    }
}
