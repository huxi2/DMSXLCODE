package dp;

import nodes.TreeNode;

public class RobIII {

    public int rob(TreeNode root) {
        int[] dp = postOrder(root);
        return Math.max(dp[0], dp[1]);
    }

    //dp[2] dp[0] 表示不偷该节点的最大利润  dp[1]表示偷该节点的最大利润
    public int[] postOrder(TreeNode root) {
        if (root == null) return new int[]{0, 0};//空节点不偷

        int[] left = postOrder(root.left);
        int[] right = postOrder(root.right);


        int[] dp = new int[2];
        // 不偷root
        dp[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        // 偷root
        dp[1] = left[0] + right[0] + root.val;
        return dp;
    }

}
