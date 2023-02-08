package biTrees;


import nodes.TreeNode;

public class SearchBST {
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode p = root;
        while (p != null) {
            if (p.val == val) break;
            if (p.val > val) p = p.left;
            else p = p.right;
        }
        return p;
    }

    public TreeNode searchBST2(TreeNode root, int val) {
        if (root == null || root.val == val) return root;
        if (root.val > val) return searchBST2(root.left, val);
        else return searchBST2(root.right, val);
    }
}
