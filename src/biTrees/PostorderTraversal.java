package biTrees;

import nodes.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PostorderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        traversal(root, ans);
        return ans;
    }

    public void traversal(TreeNode root, List<Integer> ans) {
        if (root == null) return;
        traversal(root.left, ans);
        traversal(root.right, ans);
        ans.add(root.val);
    }
}
