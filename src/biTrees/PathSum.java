package biTrees;


import nodes.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PathSum {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new LinkedList<>();
        getPath(root, 0, targetSum, temp, ans);
        return ans;
    }

    public void getPath(TreeNode root, int sum, int targetSum, List<Integer> path, List<List<Integer>> ans) {
        if (root == null) return;
        if (root.left == null && root.right == null && sum + root.val == targetSum) {
            path.add(root.val);
            ans.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
            return;
        }
        path.add(root.val);
        getPath(root.left, sum + root.val, targetSum, path, ans);
        getPath(root.right, sum + root.val, targetSum, path, ans);
        path.remove(path.size() - 1);
    }

}
