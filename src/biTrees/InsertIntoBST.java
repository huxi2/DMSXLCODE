package biTrees;


import nodes.TreeNode;

import java.util.Stack;

public class InsertIntoBST {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        TreeNode p = root, pre = null;
        while (p != null) {
            pre = p;
            if (p.val > val)
                p = p.left;
            else
                p = p.right;
        }

        if (pre.val > val) {
            pre.left = new TreeNode(val);
        } else {
            pre.right = new TreeNode(val);
        }

        return root;
    }
}
