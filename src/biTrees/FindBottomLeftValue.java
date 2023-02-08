package biTrees;


import nodes.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class FindBottomLeftValue {
    int max = 0;
    int ans = 0;

    public int findBottomLeftValue(TreeNode root) {
        find(root, 0);
        return ans;
    }

    public void find(TreeNode root, int depth) {
        if (root.left == null && root.right == null) {
            if (depth > max) {
                max = depth;
                ans = root.val;
            }
        }
        if (root == null) return;
        find(root.left, depth + 1);
        find(root.right, depth + 1);
    }


    public int findBottomLeftValue2(TreeNode root) {
        if (root == null) return 0;
        int ans = 0;
        TreeNode q;
        Deque<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while (!que.isEmpty()) {
            int n = que.size();
            ans = que.peek().val;
            while (n > 0) {
                q = que.poll();
                if (q.left != null) que.offer(q.left);
                if (q.right != null) que.offer(q.right);
                n--;
            }
        }
        return ans;
    }
}
