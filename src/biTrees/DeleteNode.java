package biTrees;


import nodes.TreeNode;

public class DeleteNode {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return root;
        TreeNode newHead = new TreeNode();
        newHead.left = root;
        TreeNode pre = newHead, p = root, q;
        //查找节点
        while (p != null) {
            if (p.val == key) break;
            pre = p;
            if (p.val > key) p = p.left;
            else p = p.right;
        }
        if (p == null) return newHead.left;

        //使用q 找到前一节点
        if (p.left != null && p.right != null) {
            pre = p;
            q = p.left;
            while (q.right != null) {
                pre = q;
                q = q.right;
            }
            p.val = q.val;
            p = q;
        }

        //使用pre 删除p
        if (p == pre.left) {
            pre.left = p.left == null ? p.right : p.left;
        }
        if (p == pre.right) {
            pre.right = p.left == null ? p.right : p.left;
        }
        return newHead.left;
    }
}
