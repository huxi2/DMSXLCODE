package biTrees;

import nodes.TreeNode;
import org.junit.Test;

public class IsBalanced {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return balance(root) != -1;
    }

    public int balance(TreeNode root) {
        if (root == null) return 0;
        int left = balance(root.left);
        int right = balance(root.right);

        // 不平衡
        if (left == -1 || right == -1 || Math.abs(left - right) >= 2) return -1;

        // 返回高度
        return Math.max(left, right) + 1;
    }
}
