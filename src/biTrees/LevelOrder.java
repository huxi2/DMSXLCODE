package biTrees;

import nodes.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LevelOrder {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        TreeNode p;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            ArrayList<Integer> level = new ArrayList<>();
            while (n > 0) {
                p = queue.poll();
                level.add(p.val);
                if (p.left != null) queue.offer(p.left);
                if (p.right != null) queue.offer(p.right);
                n--;
            }
            ans.add(level);
        }
        return ans;
    }
}
