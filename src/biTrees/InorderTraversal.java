package biTrees;

import nodes.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        traversal(root, ans);
        return ans;
    }

    public void traversal(TreeNode root, List<Integer> ans) {
        if (root == null) return;
        traversal(root.left, ans);
        ans.add(root.val);
        traversal(root.right, ans);
    }
}
