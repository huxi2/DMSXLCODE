package other;

import nodes.TreeNode;

public class SumNumbers {
    int sum = 0;

    public int sumNumbers(TreeNode root) {
        getSum(root, 0);
        return sum;
    }

    public void getSum(TreeNode root, int parent) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            sum += (parent * 10 + root.val);
            return;
        }
        getSum(root.left, parent * 10 + root.val);
        getSum(root.right, parent * 10 + root.val);
    }

}
