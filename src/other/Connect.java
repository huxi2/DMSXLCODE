package other;

import nodes.Node;

import java.util.Deque;
import java.util.LinkedList;

public class Connect {
    // 层次遍历
    public Node connect(Node root) {
        if (root == null) return null;
        Deque<Node> que = new LinkedList<>();
        que.offer(root);
        Node pre = null, cur;
        while (!que.isEmpty()) {
            int n = que.size();
            pre = null;
            for (int i = 0; i < n; i++) {
                cur = que.poll();
                if (i > 0) {//设置右指针
                    pre.next = cur;
                }
                pre = cur;

                //继续入队
                if (cur.left != null) que.offer(cur.left);
                if (cur.right != null) que.offer(cur.right);
            }
        }
        return root;
    }
}
