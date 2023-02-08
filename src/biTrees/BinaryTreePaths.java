package biTrees;


import nodes.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {

    //回溯
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        getPath(root, "", ans);
        return ans;
    }

    public void getPath(TreeNode root, String path, List<String> ans) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            ans.add(path + root.val);
        } else {
            getPath(root.left, path + root.val + "->", ans);
            getPath(root.right, path + root.val + "->", ans);
        }
    }
}
