package biTrees;


import nodes.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GetMinimumDifference {
    public int getMinimumDifference(TreeNode root) {
        List<Integer> val = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            val.add(p.val);
            p = p.right;
        }
        int ans = val.get(1) - val.get(0);
        for (int i = 2; i < val.size(); i++) {
            if (val.get(i) - val.get(i - 1) < ans) {
                ans = val.get(i) - val.get(i - 1);
            }
        }
        return ans;
    }
}
