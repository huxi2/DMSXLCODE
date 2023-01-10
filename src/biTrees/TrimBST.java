package biTrees;


import nodes.TreeNode;

public class TrimBST {

    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) return null;
        if (root.val < low) { //从右侧找
            return trimBST(root.right, low, high);
        }
        if (root.val > high) { // 从左侧找
            return trimBST(root.left, low, high);
        }
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }

    public TreeNode trimBST2(TreeNode root, int low, int high) {
        //处理头节点
        while (root != null && (root.val < low || root.val > high)) {
            if (root.val < low) root = root.right;
            else root = root.left;
        }
        if (root == null) return root;

        // 处理左子树
        TreeNode p = root;
        while (p != null) {
            while (p.left != null && p.left.val < low) {
                p.left = p.left.right;
            }
            p = p.left;
        }

        // 处理左子树
        p = root;
        while (p != null) {
            while (p.right != null && p.right.val > high) {
                p.right = p.right.left;
            }
            p = p.right;
        }

        return root;
    }
}
