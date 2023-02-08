package biTrees;


import nodes.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        return count(root.left, root) + count(root.right, root);
    }

    public int count(TreeNode root, TreeNode parent) {
        if (root == null) return 0;
        if (root.left == null && root.right == null && root == parent.left) return root.val;
        return count(root.left, root) + count(root.right, root);
    }

    public int sumOfLeftLeaves2(TreeNode root) {
        if (root == null) return 0;
        int ans = 0;
        TreeNode q;
        Deque<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while (!que.isEmpty()) {
            int n = que.size();
            while (n > 0) {
                q = que.poll();
                if (q.left != null) {
                    if (q.left.left == null && q.left.right == null) ans += q.left.val;
                    que.offer(q.left);
                }
                if (q.right != null) que.offer(q.right);
                n--;
            }
        }
        return ans;
    }

}
