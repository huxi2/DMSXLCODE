package biTrees;

import nodes.TreeNode;

import java.util.Stack;

public class IsSymmetric {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return symmetric(root.left, root.right);
    }

    public boolean symmetric(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;
        return root1.val == root2.val && symmetric(root1.left, root2.right) && symmetric(root1.right, root2.left);
    }

    public boolean isSymmetric2(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> left = new Stack<>(), right = new Stack<>();
        TreeNode p = root.left, q = root.right;
        while ((p != null || !left.isEmpty()) || (q != null || !right.isEmpty())) {
            while (p != null && q != null) {
                left.push(p);
                right.push(q);
                p = p.left;
                q = q.right;
            }
            if (p != null || q != null ) return false;
            p = left.pop();
            q = right.pop();
            if(p==null || q==null || p.val != q.val) return false;
            p = p.right;
            q = q.left;
        }
        return true;
    }
}
