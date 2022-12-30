package biTrees;

import nodes.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

    //非递归
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while(p!=null || !stack.isEmpty()){
            while(p!=null){
                stack.push(p);
                p=p.left;
            }
            p=stack.pop();
            ans.add(p.val);
            p=p.right;
        }
        return ans;
    }
}
