package biTrees;


import nodes.TreeNode;

public class HasPathSum {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        return pathSum(root, 0, targetSum);
    }

    public boolean pathSum(TreeNode root, int sum, int targetSum) {
        if (root == null) return false;
        if (root.left == null && root.right == null && sum + root.val == targetSum) return true;
        if (sum + root.val > targetSum) return false;
        return pathSum(root.left, sum + root.val, targetSum) || pathSum(root.right, sum + root.val, targetSum);
    }
}
