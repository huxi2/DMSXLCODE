package other;

import nodes.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class IsSameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    //    非递归
    public boolean isSameTree2(TreeNode p, TreeNode q) {
        Deque<TreeNode> que = new LinkedList<>();
        que.offer(p);
        que.offer(q);
        while (!que.isEmpty()) {
            TreeNode temp1 = que.poll();
            TreeNode temp2 = que.poll();
            if (temp1 == null && temp2 == null) continue;
            if (temp1 == null || temp2 == null) return false;
            if (temp1.val != temp2.val) return false;
            que.offer(temp1.left);
            que.offer(temp2.left);
            que.offer(temp1.right);
            que.offer(temp2.right);
        }

        return true;
    }
}
