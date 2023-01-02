package biTrees;


import nodes.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class MaxDepth {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }

    public int maxDepth2(TreeNode root) {
        int ans = 0;
        Deque<TreeNode> que = new LinkedList<>();
        TreeNode p;
        que.offer(root);
        while (!que.isEmpty()) {
            int n = que.size();
            if (n > 0) ans++;
            while (n > 0) {
                p = que.poll();
                if (p.left != null) que.offer(p.left);
                if (p.right != null) que.offer(p.right);
                n--;
            }
        }
        return ans;
    }
}
