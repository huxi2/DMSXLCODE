package biTrees;


import nodes.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class MinDepth {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        Deque<TreeNode> que = new LinkedList<>();
        que.offer(root);
        TreeNode p;
        int ans = 0;
        while (!que.isEmpty()) {
            int n = que.size();
            if (n > 0) ans++;
            while (n > 0) {
                p = que.poll();
                if (p.left == null && p.right == null) break;
                if (p.left != null) que.offer(p.left);
                if (p.right != null) que.offer(p.right);
                n--;
            }
            if (n > 0) break;
        }
        return ans;
    }

    public int getDepth(TreeNode root) {
        if (root == null) return Integer.MAX_VALUE;
        if (root.left == null && root.right == null) return 1;
        int left = getDepth(root.left);
        int right = getDepth(root.right);

        int ans;
        if (left == Integer.MAX_VALUE && right == Integer.MAX_VALUE)
            ans = Integer.MAX_VALUE;
        else
            ans = Math.min(left, right) + 1;
        return ans;
    }

    public int minDepth2(TreeNode root) {
        if (root == null) return 0;
        return getDepth(root);
    }
}
