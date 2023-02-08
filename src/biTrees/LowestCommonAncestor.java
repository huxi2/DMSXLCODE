package biTrees;


import nodes.TreeNode;

public class LowestCommonAncestor {
    //普通二叉树
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return root;
        if (root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) return root;
        return left == null ? right : left;
    }

    //二叉搜索树
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root.val > p.val && root.val > q.val) {
            TreeNode left = lowestCommonAncestor2(root.left, p, q);
            if (left != null) return left;
        }
        if (root.val < p.val && root.val < q.val) {
            TreeNode right = lowestCommonAncestor2(root.right, p, q);
            if (right != null) return right;
        }
        return root;
    }
}
