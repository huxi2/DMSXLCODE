package biTrees;

import nodes.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

    //非递归
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while(p!=null || !stack.isEmpty()){
            while(p!=null){
                ans.add(p.val);
                stack.push(p);
                p=p.left;
            }
            p=stack.pop();
            p=p.right;
        }
        return ans;
    }
}

