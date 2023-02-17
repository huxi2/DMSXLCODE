package dp;

public class NumTrees {

    // n个节点组成的二叉搜索树的个数 可以分成
    // 1为头节点+2为头节点+2为头节点+....
    // 1为头节点  左子树为(0)个节点二叉树的数量 * 右子树为 (n-1)个节点组成二叉搜索数的结构数
    // 2为头节点  左子树为(1)个节点二叉树的数量 * 右子树为 (n-2)个节点组成二叉搜索数的结构数
    // i为头节点  左子树为(i-1)个节点二叉树的数量 * 右子树为 (n-i)个节点组成二叉搜索数的结构数
    // dp[n] 为 以n个节点组成二叉搜索树的种类
    // dp[n] = dp[0]*dp[n-1] + dp[1]*dp[n-2]+... +dp[n-1]*dp[0]
    // dp[0] = dp[1] = 1
    public int numTrees(int n) {
        if (n <= 1) return 1;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {//左子树节点个数为j * 右子树为 i-j-1 个节点二叉树个数
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }
}
