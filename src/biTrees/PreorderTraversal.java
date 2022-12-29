package biTrees;

import nodes.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PreorderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        traversal(root, ans);
        return ans;
    }

    public void traversal(TreeNode root, List<Integer> ans) {
        if (root == null) return;
        ans.add(root.val);
        traversal(root.left, ans);
        traversal(root.right, ans);
    }
}

