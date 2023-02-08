package biTrees;


import nodes.TreeNode;

import java.util.LinkedList;
import java.util.Stack;

public class ConvertBST {
    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) return null;
        convertBST(root.right);
        sum += root.val;
        root.val = sum;
        convertBST(root.left);
        return root;
    }

    public TreeNode convertBST2(TreeNode root) {
        if (root == null) return null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        int sum = 0;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.right;
            }
            p = stack.pop();
            sum += p.val;
            p.val = sum;
            p = p.left;
        }
        return root;
    }
}
